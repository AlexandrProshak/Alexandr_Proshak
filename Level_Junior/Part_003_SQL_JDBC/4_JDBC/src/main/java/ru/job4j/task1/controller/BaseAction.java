package ru.job4j.task1.controller;

/**
 * Class BaseAction.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public abstract class BaseAction implements UserAction {

    /**
     * An index of menu tracker.
     */
    private int key;

    /**
     * An action's name.
     */
    private String name;

    /**
     * A constructor with parameters.
     * @param name is a name;
     * @param key is a key;
     */
    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), this.name);
    }
}
