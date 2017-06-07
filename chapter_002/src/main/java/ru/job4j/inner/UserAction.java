package ru.job4j.inner;

import ru.job4j.encapsulation.Tracker;
import ru.job4j.polymorphism.Input;

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
     * An unique method for tracker.
     * @param input is an input interface.
     * @param tracker is an instance of a class Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * An information about the current method does.
     * @return an information.
     */
    String info();
}
