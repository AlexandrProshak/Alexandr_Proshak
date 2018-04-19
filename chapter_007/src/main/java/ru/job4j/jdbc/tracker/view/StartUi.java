package ru.job4j.jdbc.tracker.view;

import ru.job4j.jdbc.tracker.controller.Tracker;
import ru.job4j.jdbc.tracker.controller.Input;
import ru.job4j.jdbc.tracker.controller.MenuTracker;
import ru.job4j.jdbc.tracker.controller.TrackerDbImpl;
import ru.job4j.jdbc.tracker.controller.ValidatedInput;
import ru.job4j.jdbc.tracker.dao.ItemDaoImpl;

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
     * A constructor for a class.
     * @param input is an ask interface.
     */
    public StartUi(Input input) {
        this.input = input;
    }

    /**
     * A method for initialization the program.
     */
    public void init() {
        Tracker tracker = new TrackerDbImpl(new ItemDaoImpl());
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        String ask;
        do {
            System.out.println("    Menu:");
            System.out.println();
            menu.showMenu();
            System.out.println();
            menu.select(this.input.ask("Please select action: ", menu.getUserActionIndexes()));
            System.out.println();
            ask = this.input.ask("To continue press ENTER .../ to exit write Y ~> ENTER ");
            System.out.println();
        } while (!"y".equalsIgnoreCase(ask));
    }

    /**
     * A main method.
     * @param args for the method main.
     * @throws IOException if something was wrong.
     */
    public static void main(String[] args) throws IOException {
        Input input = new ValidatedInput();
        new StartUi(input).init();
    }
}
