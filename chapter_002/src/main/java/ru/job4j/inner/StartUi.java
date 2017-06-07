package ru.job4j.inner;

import ru.job4j.encapsulation.Tracker;
import ru.job4j.polymorphism.ConsoleInput;
import ru.job4j.polymorphism.Input;

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
     * A constructor for a class.
     * @param input is an input interface.
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
            menu.select(Integer.parseInt(this.input.input("Please select action: ")));
            System.out.println();
        } while (!"y".equals(this.input.input("For exit enter Y : ")));
    }

    /**
     * A main method.
     * @param args for the method main.
     * @throws IOException if something was wrong.
     */
    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        new StartUi(input).init();
    }
}
