package ru.job4j.task1;

/**
 * Class Human describes a basic human.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
     * Getter for name's field.
     * @return name of instance of human.
     */
    public String getName() {
        return name;
    }
}
