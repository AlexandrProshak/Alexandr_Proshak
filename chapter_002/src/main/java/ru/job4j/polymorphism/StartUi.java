package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;

import java.io.IOException;

/**
 * Class StartUi.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class StartUi {

    private Input input;

    public StartUi(Input input) {
        this.input = input;
    }

    private void init() throws IOException {

        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker();
        int choice = menu.select();

    }

    public static void main(String[] args) throws IOException {
        new StartUi(new ConsoleInput()).init();
    }
}
