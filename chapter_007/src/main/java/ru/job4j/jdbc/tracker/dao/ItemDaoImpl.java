package ru.job4j.jdbc.tracker.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.jdbc.tracker.exception.ItemDaoExceptions;
import ru.job4j.jdbc.tracker.model.Item;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The class ItemDaoImpl is an implementation of the ItemDao interface.
 */
public class ItemDaoImpl implements ItemDao {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ItemDaoImpl.class);

    /**
     * The SQL line for adding an item to the db.
     */
    private static final String INSERT = "INSERT INTO Items "
            + "(name, description, user_id, category_id, state_id) "
            + "VALUES (?, ?, ?, ?, ?);";

    /**
     * The SQL line for removing an item from the db.
     */
    private static final String DELETE = "DELETE FROM Items WHERE Items.id = ?;";

    /**
     * The SQL line for finding an item into the db by the id.
     */
    private static final String FIND_BY_ID = "SELECT "
            + "id, name, description, user_id, category_id, state_id FROM Items WHERE id = ?;";

    /**
     * The SQL line for finding an item into the db by the name.
     */
    private static final String FIND_BY_NAME = "SELECT "
            + "id, name, description, user_id, category_id, state_id FROM Items WHERE name = ?;";

    /**
     * The SQL line for finding all items into the db.
     */
    private static final String SELECT_ALL = "SELECT "
            + "it.id AS id, it.name AS name, it.description AS description, "
            + "it.user_id AS userId, it.category_id AS catId, it.state_id AS stId "
            + "FROM Items AS it;";

    /**
     * The SQL line for update the item by id.
     */
    private static final String UPDATE_BY_ID = "UPDATE Items "
            + "SET name = ?, "
            + "description = ?, "
            + "user_id = ?, "
            + "category_id = ?, "
            + "state_id = ? "
            + "WHERE id = ?;";

    @Override
    public int addItem(Connection connection, Item item) {
        int currentId = -1;
        try (PreparedStatement st = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, item.getUserId());
            st.setInt(4, item.getCategoryId());
            st.setInt(5, item.getStateId());
            currentId = st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method addItem() failed.", e);
        } finally {
            return currentId;
        }
    }

    @Override
    public boolean deleteItemById(Connection connection, int id) throws ItemDaoExceptions {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(DELETE)) {
            st.setInt(1, id);
            result = st.execute();
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method deleteItemById() failed.", e);
        }
        return result;
    }

    @Override
    public Item findItemById(Connection connection, int id) throws ItemDaoExceptions {
        Item item = new Item();
        try (PreparedStatement st = connection.prepareStatement(FIND_BY_ID)) {
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setId(resultSet.getInt("user_id"));
                item.setCategoryId(resultSet.getInt("category_id"));
                item.setStateId(resultSet.getInt("state_id"));
            }
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method findItemById() failed.", e);
        }
        return item;
    }

    @Override
    public List<Item> findItemByName(Connection connection, String name) throws ItemDaoExceptions {
        List<Item> list = new LinkedList<>();
        try (PreparedStatement st = connection.prepareStatement(FIND_BY_NAME)) {
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("state_id")
                );
                list.add(item);
            }
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method findItemByName() failed.", e);
        }
        return list;
    }

    @Override
    public List<Item> findAllItems(Connection connection) throws ItemDaoExceptions {
        List<Item> list = new LinkedList<>();
        try (PreparedStatement st = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("userId"),
                        resultSet.getInt("catId"),
                        resultSet.getInt("stId")
                );
                list.add(item);
            }
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method findAllItems() failed.", e);
        }
        return list;
    }

    @Override
    public Item updateItem(Connection connection, Item newItem) throws ItemDaoExceptions {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_BY_ID)) {
            st.setString(1, newItem.getName());
            st.setString(2, newItem.getDescription());
            st.setInt(3, newItem.getUserId());
            st.setInt(4, newItem.getCategoryId());
            st.setInt(5, newItem.getStateId());
            st.setInt(6, newItem.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
            throw new ItemDaoExceptions("Method updateItem() failed.", e);
        } finally {
            return newItem;
        }
    }
}
