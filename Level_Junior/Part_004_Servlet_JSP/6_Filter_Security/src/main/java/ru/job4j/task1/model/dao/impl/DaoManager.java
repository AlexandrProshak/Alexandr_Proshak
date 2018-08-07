package ru.job4j.task1.model.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.model.dao.BaseDataSource;
import ru.job4j.task1.model.entity.Role;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * The class DaoManager is a simple implementation of the DataSource interface
 * and provides a connection throw the JNDI and the Hikari connection pool.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class DaoManager extends BaseDataSource {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DaoManager.class);

    /**
     * The query string to the init table users.
     */
    private static final String INIT_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users ("
            + "id SERIAL,"
            + "name CHARACTER VARYING(50) NOT NULL,"
            + "login CHARACTER VARYING(50) NOT NULL,"
            + "password CHARACTER VARYING(50) NOT NULL,"
            + "email CHARACTER VARYING(50) NOT NULL,"
            + "role CHARACTER VARYING(50) NOT NULL,"
            + "date TIMESTAMP NOT NULL,"
            + "PRIMARY KEY (id));";

    /**
     * The query string to insert the default user (role = admin).
     */
    private static final String INSERT_DEFAULT_USER = "INSERT INTO "
            + "users(name, login, password, email, role, date) "
            + "VALUES(?, ?, ?, ?, ?, ?);";

    /**
     * The constructor.
     */
    public DaoManager() {
        init();
        insertDefaultUsers();
    }

    @Override
    public Connection getConnection() throws SQLException {
        DataSource dataSource;
        Connection connection = null;
        try {
            InitialContext context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/postgres");
            if (dataSource == null) {
                LOG.error("Data source not found");
            } else {
                connection = dataSource.getConnection();
            }
        } catch (NamingException e) {
            LOG.error(e.getMessage(), e);
        }
        return connection;
    }

    /**
     * The method initializes the tables.
     */
    private void init() {
        try (PreparedStatement userStatement = this.getConnection().prepareStatement(INIT_TABLE_USERS)) {
            userStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The method insert the default users.
     */
    private void insertDefaultUsers() {
        try (Connection connection = this.getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users LIMIT 1")) {
            if (!resultSet.next()) {
                try (PreparedStatement statement = connection.prepareStatement(INSERT_DEFAULT_USER)) {
                    connection.setAutoCommit(false);
                    statement.setString(1, "admin");
                    statement.setString(2, "admin");
                    statement.setString(3, "password");
                    statement.setString(4, "admin@email.su");
                    statement.setString(5, Role.admin.toString());
                    statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                    statement.addBatch();
                    statement.setString(1, "guest");
                    statement.setString(2, "guest");
                    statement.setString(3, "guest");
                    statement.setString(4, "guest@email.su");
                    statement.setString(5, Role.user.toString());
                    statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                    statement.addBatch();
                    statement.executeBatch();
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
