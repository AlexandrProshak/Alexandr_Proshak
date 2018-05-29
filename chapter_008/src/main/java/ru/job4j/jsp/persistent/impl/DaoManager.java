package ru.job4j.jsp.persistent.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.parser.dao.BaseDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The class DaoManager is a simple implementation of the DataSource interface
 * and provides a connection throw the JNDI and the Hikari connection pool.
 */
public class DaoManager extends BaseDataSource {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DaoManager.class);

    /**
     * The query string to the init table users.
     */
    private static final String INIT_TABLE = "CREATE TABLE IF NOT EXISTS users ("
            + "id INTEGER,"
            + "name CHARACTER VARYING(50) NOT NULL,"
            + "login CHARACTER VARYING(50) NOT NULL,"
            + "email CHARACTER VARYING(50) NOT NULL,"
            + "date TIMESTAMP NOT NULL,"
            + "PRIMARY KEY (id));";

    /**
     * The constructor to only call a method init.
     */
    public DaoManager() {
        init();
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
     * The method initializes the table users.
     */
    private void init() {
        try (PreparedStatement statement = this.getConnection().prepareStatement(INIT_TABLE)) {
            statement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
