package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;

/**
 * Class AddAction.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class AddAction implements Action {
    @Override
    public void execute(Tracker tracker, Input input) {
        String name = input.input("enter name: ");
        String desc = input.input("enter desc: ");
        tracker.add(new Item(name, desc));
    }
}
