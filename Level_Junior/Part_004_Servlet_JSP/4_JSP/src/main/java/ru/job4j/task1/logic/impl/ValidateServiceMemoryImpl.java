package ru.job4j.task1.logic.impl;


import ru.job4j.task1.logic.ValidateService;
import ru.job4j.task1.logic.entity.User;
import ru.job4j.task1.persistent.Store;
import ru.job4j.task1.persistent.impl.DatabaseStoreImpl;

import java.util.Collection;
import java.util.Collections;

/**
 * The class ValidateServiceMemoryImpl is an implementation of ValidateService interface with memory.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidateServiceMemoryImpl implements ValidateService {

    /**
     * The field to store a single INSTANCE of the class.
     */
    private static final ValidateServiceMemoryImpl INSTANCE = new ValidateServiceMemoryImpl();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private ValidateServiceMemoryImpl() {
        store = DatabaseStoreImpl.getInstance();
    }

    /**
     *  The static method to return a single INSTANCE of the class.
     * @return an INSTANCE.
     */
    public static ValidateServiceMemoryImpl getInstance() {
        return INSTANCE;
    }

    /**
     * The field for an implementation of a Store interface.
     */
    private Store store;

    @Override
    public boolean add(User user) {
        if (store.findById(user.getId()) == null) {
            store.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        if (store.findById(user.getId()) != null) {
            store.update(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (store.findById(id) != null) {
            store.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<User> findAll() {
        if (!store.findAll().isEmpty()) {
            return store.findAll();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public User findById(int id) {
        return store.findById(id);
    }
}
