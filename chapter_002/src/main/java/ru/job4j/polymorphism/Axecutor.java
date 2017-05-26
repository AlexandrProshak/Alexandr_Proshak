package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Tracker;

/**
 * Class Axecutor.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Axecutor implements Action {
    @Override
    public void execute(Tracker tracker, Input input) {
        if (Integer.parseInt(String.valueOf(input)) == 1) {

        }
    }
}
