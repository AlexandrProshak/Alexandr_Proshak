package ru.job4j.task1.model.logic.impl;

import ru.job4j.task1.model.dao.Store;
import ru.job4j.task1.model.dao.impl.MemoryStoreImpl;
import ru.job4j.task1.model.logic.ValidateService;
import ru.job4j.task1.model.entity.User;

import java.util.Collection;
import java.util.Collections;

/**
 * The class ValidateServiceImpl is an implementation of ValidateService interface with memory.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidateServiceImpl implements ValidateService {

    /**
     * The field to store a single INSTANCE of the class.
     */
    private static final ValidateService INSTANCE = new ValidateServiceImpl();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private ValidateServiceImpl() {
        store = MemoryStoreImpl.getInstance();
//        store = DatabaseStoreImpl.getInstance();
    }

    /**
     * The static method to return a single INSTANCE of the class.
     *
     * @return an INSTANCE.
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * The field for an implementation of a Store interface.
     */
    private Store store;

    @Override
    public boolean add(User user) {
        if (!store.findAll().contains(user)) {
            store.add(user);
            return true;
        } else {
            return true;
        }
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

    @Override
    public User isCredential(String login, String password) {
        User result = null;
        Collection<User> all = this.findAll();
        for (User user : all) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        store.clear();
    }
}
