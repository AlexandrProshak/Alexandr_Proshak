package ru.job4j.mvc.model.dao.impl;

import ru.job4j.mvc.model.dao.Store;
import ru.job4j.mvc.model.entity.City;
import ru.job4j.mvc.model.entity.Country;
import ru.job4j.mvc.model.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The class of implementation the Store interface for memory.
 */
public class MemoryStoreImpl implements Store {

    /**
     * The generator id.
     */
    private static AtomicInteger index = new AtomicInteger(1);

    /**
     * The field to store a single INSTANCE of the class.
     */
    private static final MemoryStoreImpl INSTANCE = new MemoryStoreImpl();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    private MemoryStoreImpl() {
    }

    /**
     *  The static method to return a single INSTANCE of the class.
     * @return an INSTANCE.
     */
    public static MemoryStoreImpl getInstance() {
        return INSTANCE;
    }

    /**
     * The threadsafe memory storage.
     */
    private Map<Integer, User> store = new ConcurrentHashMap<>();

    @Override
    public void add(User user) {
        int id = index.getAndIncrement();
        user.setId(id);
        store.put(id, user);
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

    //TODO
    @Override
    public Collection<Country> findAllCountries() {
        return null;
    }

    //TODO
    @Override
    public Collection<City> findAllCitiesByCountry(String countryName) {
        return null;
    }
}
