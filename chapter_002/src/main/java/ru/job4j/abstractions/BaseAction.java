package ru.job4j.abstractions;

import ru.job4j.encapsulation.Tracker;
import ru.job4j.exceptions.Input;
import ru.job4j.inner.UserAction;

/**
 * Class BaseAction.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {

    private String key;
    private String name;

    /**
     * A constructor with parameters.
     * @param name is a name;
     * @param key is a key;
     */
    public BaseAction(String key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), this.name);
    }
}
