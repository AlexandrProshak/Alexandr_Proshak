package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Tracker;
import ru.job4j.exceptions.ConsoleInput;
import ru.job4j.exceptions.Input;

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
     * A field of an ask system.
     */
    private Input input;
    /**
     * A field of a tracker instance.
     */
    private Tracker tracker;

    /**
     * A constructor.
     * @param input an ask interface.
     * @param tracker is an instance of a tracker.
     */
    public StartUi(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * An initialisation method.
     * @throws IOException if same thing was wrong.
     */
    public void init() throws IOException {
        boolean flag = true;
        MenuTracker menu = new MenuTracker();
        Action action = new Action();
        //a loop of showing menu.
        while (flag) {
            menu.show();
            int userChoice = Integer.parseInt(input.ask("Select: "));
            flag = action.execute(input, tracker, userChoice);
        }
    }

    /**
     * A main method.
     * @param args for the method main.
     * @throws IOException if something was wrong.
     */
    public static void main(String[] args) throws IOException {
        new StartUi(new Tracker(), new ConsoleInput()).init();
    }
}

