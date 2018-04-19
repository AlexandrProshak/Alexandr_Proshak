package ru.job4j.jdbc.tracker.controller;

/**
 * Interface UserAction.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    /**
     * Number of an action.
     * @return a number of an action.
     */
    int key();

    /**
     * An unique method for trackerArrayImpl.
     * @param input is an ask interface.
     * @param tracker is an instance of a class TrackerDbImpl.
     */
    void execute(Input input, Tracker tracker);

    /**
     * An information about the current method does.
     * @return an information.
     */
    String info();
}
