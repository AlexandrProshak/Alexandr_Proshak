package ru.job4j.task1.dao;

import ru.job4j.task1.exception.ItemDaoExceptions;
import ru.job4j.task1.model.Item;

import java.sql.Connection;
import java.util.List;

/**
 * The interface describes the contract of the item's behavior with the database.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public interface ItemDao {

    /**
     * The method adds an item to the db.
     * @param connection to db.
     * @param item to be added.
     * @return the item's id in the db.
     * -1 means that such item was not added to the db.
     */
    int addItem(final Connection connection, final Item item);

    /**
     * The method removes an item from a db.
     * @param connection to db.
     * @param id of the item to be deleted.
     * @return true in case of success, false otherwise.
     * @throws ItemDaoExceptions the special exception for database implementation.
     */
    boolean deleteItemById(final Connection connection, final int id) throws ItemDaoExceptions;

    /**
     * The method finds the item by the id.
     * @param connection to db.
     * @param id of the item to be searched.
     * @return the item.
     * @throws ItemDaoExceptions the special exception for database implementation.
     */
    Item findItemById(final Connection connection, final int id) throws ItemDaoExceptions;

    /**
     * The method finds the items by the name.
     * @param connection to db.
     * @param name of item to be searched.
     * @return list of items with a similar name.
     * @throws ItemDaoExceptions the special exception for database implementation.
     */
    List<Item> findItemByName(final Connection connection, final String name) throws ItemDaoExceptions;

    /**
     * The method finds all items by the name.
     * @param connection to db.
     * @return list of items with a similar name.
     * @throws ItemDaoExceptions the special exception for database implementation.
     */
    List<Item> findAllItems(final Connection connection) throws ItemDaoExceptions;

    /**
     * The method updates the item by id.
     * @param connection to db.
     * @param newItem to update.
     * @return updated item.
     * @throws ItemDaoExceptions the special exception for database implementation.
     */
    Item updateItem(final Connection connection, Item newItem) throws ItemDaoExceptions;

}
