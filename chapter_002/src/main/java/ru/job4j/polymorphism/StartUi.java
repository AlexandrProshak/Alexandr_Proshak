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
    /**
     * A field of an input system.
     */
    private Input input;

    /**
     * A constructor.
     * @param input an input interface.
     */
    public StartUi(Input input) {
        this.input = input;
    }

    /**
     * An initialisation method.
     * @throws IOException if same thing was wrong.
     */
    private void init() throws IOException {
        boolean flag = true;
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker();
        Action action = new Action();
        //a loop of showing menu.
        while (flag) {
            int userChoice = menu.select();
            flag = action.execute(input, tracker, userChoice);
        }
    }

    /**
     * A main method.
     * @param args for the mathod main.
     * @throws IOException if something was wrong.
     */
    public static void main(String[] args) throws IOException {
        new StartUi(new ConsoleInput()).init();
    }
}

