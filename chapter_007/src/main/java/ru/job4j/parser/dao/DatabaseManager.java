package ru.job4j.parser.dao;

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
    private static final Logger LOG = LoggerFactory.getLogger(ru.job4j.jdbc.tracker.dao.DatabaseManager.class);

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
     * The creating Vacancies table SQL.
     */
    private static final String VACANCIES_CREATE_SQL = "CREATE TABLE IF NOT EXISTS Vacancies ("
            + "id INTEGER,"
            + "description TEXT NOT NULL,"
            + "date TIMESTAMP NOT NULL,"
            + "link TEXT NOT NULL,"
            + "PRIMARY KEY (id))";

    /**
     * The creating information table of update.
     */
    private static final String UPDATE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS Updates ("
            + "attempt SERIAL,"
            + "date TIMESTAMP NOT NULL,"
            + "PRIMARY KEY (attempt))";

    /**
     * The creating information table of update.
     */
    private static final String SET_DEFAULT_DATE_SQL = "INSERT INTO Updates(date) VALUES('2018-01-01 00:00:00');";

    /**
     * The constructor.
     */
    public DatabaseManager() {
        this.initDataBase();
        this.createTables();
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
    private void createTables() {
        try (Statement statement = this.getConnection().createStatement()) {
            statement.execute(VACANCIES_CREATE_SQL);
            statement.execute(UPDATE_CREATE_SQL);
            statement.execute(SET_DEFAULT_DATE_SQL);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
