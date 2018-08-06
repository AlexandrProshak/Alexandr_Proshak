package ru.job4j.task1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.dao.DatabaseManager;
import ru.job4j.task1.dao.ItemDao;
import ru.job4j.task1.exception.ItemDaoExceptions;
import ru.job4j.task1.model.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The class TrackerDbImpl describes an implementation of the Tracker interface for using database.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class TrackerDbImpl implements Tracker {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TrackerDbImpl.class);

    /**
     * The dao for working with the database.
     */
    private final ItemDao dao;

    /**
     * The database manager who is responsible for using the database.
     */
    private final DatabaseManager databaseManager;

    /**
     * The constructor.
     * @param dao for using with the database.
     */
    public TrackerDbImpl(ItemDao dao) {
        this.dao = dao;
        this.databaseManager = new DatabaseManager();
    }

    @Override
    public Item add(Item item) {
        int index = 0;
        try (Connection connection = this.databaseManager.getConnection()) {
            index = this.dao.addItem(connection, item);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        item.setId(index);
        return item;
    }

    @Override
    public void update(Item newItem) {
        try (Connection connection = this.databaseManager.getConnection()) {
            this.dao.updateItem(connection, newItem);
        } catch (ItemDaoExceptions | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = this.databaseManager.getConnection()) {
            this.dao.deleteItemById(connection, id);
        } catch (ItemDaoExceptions | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public Item[] findAll() {
        List<Item> it = new LinkedList<>();
        try (Connection connection = this.databaseManager.getConnection()) {
            it = this.dao.findAllItems(connection);
        } catch (ItemDaoExceptions | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        Item[] result = new Item[it.size()];
        it.toArray(result);
        return result;
    }

    @Override
    public Item[] findByName(String name) {
        List<Item> it = new LinkedList<>();
        try (Connection connection = this.databaseManager.getConnection()) {
            it = this.dao.findItemByName(connection, name);
        } catch (ItemDaoExceptions | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        Item[] result = new Item[it.size()];
        it.toArray(result);
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (Connection connection = this.databaseManager.getConnection()) {
            result = this.dao.findItemById(connection, id);
        } catch (ItemDaoExceptions | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
