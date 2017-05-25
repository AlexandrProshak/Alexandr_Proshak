package ru.job4j.polymorphism;

import java.util.Scanner;

/**
 * Class ConsoleInput performs input from a console.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input{
    /**
     * A class scanner is used for input date from a console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * A method input provides an users input.
     * @param ask a question for user to help make a choice.
     * @return a line which contents users answer.
     */
    public String input(String ask) {
        System.out.print(ask);
        return scanner.nextLine();
    }
}
