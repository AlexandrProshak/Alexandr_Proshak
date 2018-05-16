package ru.job4j.crudservlet.persistent.impl;

import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.persistent.Store;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The class of implementation the Store interface for memory.
 */
public class MemoryStore implements Store {

    /**
     * The field to store a single INSTANCE of the class.
     */
    private static final MemoryStore INSTANCE = new MemoryStore();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private MemoryStore() {
    }

    /**
     *  The static method to return a single INSTANCE of the class.
     * @return an INSTANCE.
     */
    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    /**
     * The threadsafe memory storage.
     */
    private Map<Integer, User> store = new ConcurrentHashMap<>();

    @Override
    public void add(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        if (store.containsKey(user.getId())) {
            store.put(user.getId(), user);
        }
    }

    @Override
    public void delete(int id) {
        if (store.containsKey(id)) {
            store.remove(id);
        }
    }

    @Override
    public Collection<User> findAll() {
        return store.values();
    }

    @Override
    public User findById(int id) {
        return store.get(id);
    }
}
