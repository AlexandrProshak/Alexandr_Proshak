package ru.job4j.task1.model.logic.impl;

import ru.job4j.task1.model.dao.Store;
import ru.job4j.task1.model.logic.ValidateService;
import ru.job4j.task1.model.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The class ValidateServiceImpl is an implementation of ValidateService interface with memory.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidateServiceImpl implements ValidateService {

    /**
     * The field to store a single INSTANCE of the class.
     */
    private static final ValidateServiceImpl INSTANCE = new ValidateServiceImpl();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private ValidateServiceImpl() {
//        store = MemoryStoreImpl.getInstance();
//        store = DatabaseStoreImpl.getInstance();

        //This is a stub for testing purposes.
        store = new Store() {
            private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

            @Override
            public void add(User user) {
            map.put(user.getId(), user);
            }

            @Override
            public void update(User user) {
                map.replace(user.getId(), user);
            }

            @Override
            public void delete(int id) {
                map.remove(id);
            }

            @Override
            public Collection<User> findAll() {
                return map.values();
            }

            @Override
            public User findById(int id) {
                return map.get(id);
            }

            @Override
            public void clear() {
                map.clear();
            }
        };
    }

    /**
     * The static method to return a single INSTANCE of the class.
     *
     * @return an INSTANCE.
     */
    public static ValidateServiceImpl getInstance() {
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
