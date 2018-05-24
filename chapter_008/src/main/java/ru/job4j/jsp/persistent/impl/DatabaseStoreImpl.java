package ru.job4j.jsp.persistent.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.persistent.Store;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * The class DatabaseStoreImpl is an implementation of Store interface
 * for a database usage.
 */
public class DatabaseStoreImpl implements Store {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseStoreImpl.class);

    /**
     * The implementation the DataSource interface with connection pool HikariCP.
     */
    private static DataSource source = new DaoManager();

    /**
     * The private field to store only one instance of the class.
     */
    private static final DatabaseStoreImpl INSTANCE = new DatabaseStoreImpl();

    /**
     * The getter for the only one instance of the class.
     * @return INSTANCE.
     */
    public static DatabaseStoreImpl getInstance() {
        return INSTANCE;
    }

    /**
     * The private constructor to avoid create instance.
     */
    private DatabaseStoreImpl() {
    }

    /**
     * The query string for inserting user to database.
     */
    private static final String INSERT = "INSERT INTO "
            + "users(id, name, login, email, date) "
            + "VALUES(?, ?, ?, ?, ?);";

    /**
     * The query string for updating the user by id.
     */
    private static final String UPDATE = "UPDATE users SET "
            + "name = ?,"
            + "login = ?,"
            + "email = ? WHERE users.id = ?;";

    /**
     * The query string for removing the user by id from database.
     */
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?;";

    /**
     * The query string for selecting all user from database.
     */
    private static final String SELECT_ALL = "SELECT "
            + "users.id AS id, "
            + "users.name AS name, "
            + "users.login AS login, "
            + "users.email AS email, "
            + "users.date AS date FROM users;";

    /**
     * The query string for selecting the user by id from database.
     */
    private static final String SELECT_BY_ID = "SELECT "
            + "users.id AS id, "
            + "users.name AS name, "
            + "users.login AS login, "
            + "users.email AS email, "
            + "users.date AS date FROM users WHERE id = ?;";

    @Override
    public void add(User user) {
        if (user != null) {
            try (Connection con = source.getConnection();
                 PreparedStatement statement = con.prepareStatement(INSERT)) {
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getLogin());
                statement.setString(4, user.getEmail());
                statement.setTimestamp(5, user.getCrateDate());
                statement.execute();
            } catch (SQLException e) {
                LOG.error(e.getSQLState(), e);
            }
        } else {
            LOG.error("Trying to add null user.");
        }
    }

    @Override
    public void update(User user) {
        if (user != null) {
            try (Connection con = source.getConnection();
                 PreparedStatement statement = con.prepareStatement(UPDATE)) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getLogin());
                statement.setString(3, user.getEmail());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                LOG.error(e.getSQLState(), e);
            }
        } else {
            LOG.error("Trying to update null user.");
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0) {
            try (Connection conn = source.getConnection();
                 PreparedStatement statement = conn.prepareStatement(DELETE_BY_ID)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                LOG.error(e.getSQLState(), e);
            }
        } else {
            LOG.error("Trying to remove users by negative id.");
        }
    }

    @Override
    public Collection<User> findAll() {
        List<User> result = new LinkedList<>();
        try (Connection con = source.getConnection();
             PreparedStatement statement = con.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(Integer.valueOf(resultSet.getInt("id")));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail((resultSet.getString("email")));
                user.setCrateDate(resultSet.getTimestamp("date"));
                result.add(user);
            }
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        User user = null;
        if (id >= 0) {
            try (Connection conn = source.getConnection();
                 PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    user = new User();
                    user.setId(Integer.valueOf(resultSet.getInt("id")));
                    user.setName(resultSet.getString("name"));
                    user.setLogin(resultSet.getString("login"));
                    user.setEmail((resultSet.getString("email")));
                    user.setCrateDate(resultSet.getTimestamp("date"));
                }
            } catch (SQLException e) {
                LOG.error(e.getSQLState(), e);
            }
        } else {
            LOG.error("Negative id to find");
        }
        return user;
    }
}
