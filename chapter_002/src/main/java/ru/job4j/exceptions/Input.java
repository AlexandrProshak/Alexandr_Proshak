package ru.job4j.exceptions;

/**
 * Interface Input.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * A method to implement.
     * @param ask a parameter for a method.
     * @return entered String line.
     */
    String ask(String ask);

    /**
     * An overwritten method to implement.
     * @param ask a parameter for a method.
     * @param range is an array of menu's indexes.
     * @return entered number of a range.
     */
    int ask(String ask, int[] range);
}
