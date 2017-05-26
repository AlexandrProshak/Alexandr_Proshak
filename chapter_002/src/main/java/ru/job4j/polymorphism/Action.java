package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Tracker;

/**
 * Class Action.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public interface Action {
    void execute(Tracker tracker, Input input);


}
