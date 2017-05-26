package ru.job4j.polymorphism;

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
        boolean flag = true;
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker();

        while (flag) {
            menu.select().execute(tracker, this.input);
        }

    }

    public static void main(String[] args) throws IOException {
        new StartUi(new ConsoleInput()).init();
    }
}
