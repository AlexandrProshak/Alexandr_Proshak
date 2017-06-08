package ru.job4j.exceptions;

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
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            System.out.println();
            System.out.println("    Menu:");
            System.out.println();
            menu.showMenu();
            System.out.println();
            menu.select(this.input.ask("Please select action: ", menu.getUserActionIndexes()));
            System.out.println();
        } while (!"y".equals(this.input.ask("For exit enter Y : ")));
    }

    /**
     * A main method.
     * @param args for the method main.
     * @throws IOException if something was wrong.
     */
    public static void main(String[] args) throws IOException {
        Input input = new ValidateInput();
        new StartUi(input).init();
    }
}
