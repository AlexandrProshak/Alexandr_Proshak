package ru.job4j.extension;

/**
 * Class Human describe basic human.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Human {
    /**
     * name of humans being.
     */
    private String name;

    /**
     * Constructor.
     */
    public Human() {
    }

    /**
     * Constructor.
     * @param name of human being.
     */
    public Human(String name) {
        this.name = name;
    }

    /**
     * Geter name.
     * @return name of instance of human.
     */
    public String getName() {
        return name;
    }
}
