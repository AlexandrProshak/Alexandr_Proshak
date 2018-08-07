package ru.job4j.task1.model.dao;

import ru.job4j.task1.model.entity.User;

import java.util.Collection;

/**
 * The Store interface with base CRUD methods.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public interface Store {

    /**
     * Adds user.
     * @param user to add.
     */
    void add(User user);

    /**
     * Updates user.
     * @param user to updates.
     */
    void update(User user);

    /**
     * Removes user.
     * @param id of user to remove.
     */
    void delete(int id);

    /**
     * Finds all users into a storage.
     * @return a collection with users.
     */
    Collection<User> findAll();

    /**
     * Finds a user by id.
     * @param id of user to search.
     * @return user; in case of absent - returns null.
     */
    User findById(int id);
}
