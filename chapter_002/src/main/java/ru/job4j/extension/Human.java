package ru.job4j.extension;

/**
 * Class Human describes a basic human.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Human {
    /**
     * Name of humans being.
     */
    private String name;

    /**
     * A simple constructor.
     */
    public Human() {
    }

    /**
     * A constructor with parameters.
     * @param name of human being.
     */
    public Human(String name) {
        this.name = name;
    }

    /**
     * Geter for name's field.
     * @return name of instance of human.
     */
    public String getName() {
        return name;
    }
}
