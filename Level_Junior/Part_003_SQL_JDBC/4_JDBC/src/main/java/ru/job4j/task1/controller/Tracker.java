package ru.job4j.task1.controller;

import ru.job4j.task1.model.Item;

/**
 * The interface tracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public interface Tracker {

    /**
     * The method adds new item to the database.
     * @param item to be added.
     * @return newly added items.
     */
    Item add(Item item);

    /**
     * The method updates existing an item in the database.
     * @param item updated item.
     */
    void update(Item item);

    /**
     * The method removes the item from the database by id.
     * @param id deleted item.
     */
    void delete(int id);

    /**
     * The method searches all items in the data base.
     * @return an array of items.
     */
    Item[] findAll();

    /**
     * The method finds the item by the name.
     * @param name of the item to search.
     * @return an array of items.
     */
    Item[] findByName(String name);

    /**
     * The method finds the item by the id.
     * @param id of item to searched.
     * @return an item.
     */
    Item findById(int id);
}
