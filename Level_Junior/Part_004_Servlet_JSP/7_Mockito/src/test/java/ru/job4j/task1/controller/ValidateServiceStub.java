package ru.job4j.task1.controller;

import ru.job4j.task1.model.entity.User;
import ru.job4j.task1.model.logic.ValidateService;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The ValidateServiceStub class provides base CRUD operation for tests.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidateServiceStub implements ValidateService {

    /**
     * The field for a stub implementation of a Store interface.
     */
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    /**
     * Private constructor to avoid client applications to use constructor.
     */
    public ValidateServiceStub() {
    }

    @Override
    public boolean add(User user) {
        map.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean update(User user) {
        if (!map.replace(user.getId(), user).equals(user)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (map.remove(id) == null) {
            return false;
        }
        return true;
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
    public User isCredential(String login, String password) {
        Collection<User> all = this.findAll();
        for (User user: all) {
            if (user.getLogin().equals(login)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
