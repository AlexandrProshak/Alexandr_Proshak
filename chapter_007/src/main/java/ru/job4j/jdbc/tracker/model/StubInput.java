package ru.job4j.jdbc.tracker.model;

import ru.job4j.jdbc.tracker.controller.Input;

/**
 * Class StubInput.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * An array for a programed user's activity.
     */
    private String[] answers;

    /**
     * An index for iterations by an array.
     */
    private int position;

    /**
     * A constructor for the class.
     * @param answers a variant of the programed user's activity
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * A method imitates user's ask.
     * @param ask a parameter for a method.
     * @return a pre-programmed behavior.
     */
    @Override
    public String ask(String ask) {
        return this.answers[position++];
    }

    /**
     * A method imitates user's ask with a validation of ask.
     * @param ask a parameter for a method.
     * @param range is range of the menu.
     * @return a pre-programmed behavior.
     */
    @Override
    public int ask(String ask, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }
}
