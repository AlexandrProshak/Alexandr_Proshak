package ru.job4j.polymorphism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class ConsoleInput performs input from a console.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput {
    /**
     * A buffered class reader uses for input date from a console.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * A method consoleInput provides an users input.
     * @param ask a question for user to help make a choice.
     * @return a line which contents users answer.
     * @throws IOException if same was wrong.
     */
    public String consoleInput(String ask) throws IOException {
        System.out.print(ask);
        return reader.readLine();
    }
}
