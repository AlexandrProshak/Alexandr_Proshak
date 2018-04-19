package ru.job4j.jdbc.tracker.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * The class DatabaseManager is responsible for using the database.
 */
public class DatabaseManager {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseManager.class);

    /**
     * The properties.
     */
    private Properties properties;

    /**
     * The url to the database.
     */
    private String url;

    /**
     * The user of the database.
     */
    private String user;

    /**
     * The password to database.
     */
    private String password;

    /**
     * The creating Items table SQL.
     */
    private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS Items ("
            + "id SERIAL,"
            + "create_date TIMESTAMP NOT NULL DEFAULT NOW(),"
            + "name CHARACTER VARYING(50) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "user_id INTEGER,"
            + "category_id INTEGER,"
            + "state_id INTEGER,"
            + "PRIMARY KEY (id))";

    /**
     * The constructor.
     */
    public DatabaseManager() {
        this.initDataBase();
        this.createItemsTable();
    }

    /**
     * The method initializes the database.
     */
    private void initDataBase() {
        this.properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("tracker_db.properties")) {
            properties.load(stream);
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The method creates a singleton connection to the DB.
     * @return connection.
     */
    public Connection getConnection() {
        Connection result = null;
        try {
            result = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * The method creates the table items in case if it isn't exists.
     */
    private void createItemsTable() {
        try (Statement statement = this.getConnection().createStatement()) {
            statement.execute(CREATE_SQL);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
