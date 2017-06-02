package ru.job4j.polymorphism;

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
     * A method imitates user's input.
     * @param ask a parameter for a method.
     * @return a pre-programmed behavior.
     */
    @Override
    public String input(String ask) {
        return this.answers[position++];
    }
}
