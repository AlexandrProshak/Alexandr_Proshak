package ru.job4j.task3;

import java.util.List;
import java.util.Scanner;

/**
 * Class ConsoleInput performs ask from a console.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConsoleInput implements Input {

    /**
     * A class scanner is used for ask date from a console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * A method ask provides an users ask.
     * @param ask a question for user to help make a choice.
     * @return a line which contents users answer.
     */
    public String ask(String ask) {
        print(ask);
        return scanner.nextLine();
    }

    /**
     * A method of printing in a console.
     * @param message for print.
     */
    public void print(String message) {
        System.out.print(message);
    }

    /**
     * An overloaded method for yhe validation of user input.
     * @param ask a parameter for a method.
     * @param range is a list of a menu's indexes.
     * @return index of the menu.
     */
    @Override
    public int ask(String ask, List<Integer> range) {
        int key = Integer.valueOf(this.ask(ask));
        boolean exit = false;
        for (int value : range) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        if (exit) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
