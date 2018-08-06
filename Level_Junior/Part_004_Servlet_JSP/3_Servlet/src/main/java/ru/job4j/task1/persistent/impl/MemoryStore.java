package ru.job4j.task1.persistent.impl;


import ru.job4j.task1.logic.entity.User;
import ru.job4j.task1.persistent.Store;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The class of implementation the Store interface for memory.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
        User testUser1 = new User();
        testUser1.setId(1);
        testUser1.setName("John");
        testUser1.setLogin("john_login");
        testUser1.setEmail("john_login@gmail.com");
        User testUser2 = new User();
        testUser2.setId(2);
        testUser2.setName("Kate");
        testUser2.setLogin("kate_login");
        testUser2.setEmail("kate_login@gmail.com");
        this.add(testUser1);
        this.add(testUser2);
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
