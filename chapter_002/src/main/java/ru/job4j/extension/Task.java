package ru.job4j.extension;

/**
 * Class Task describing task for student .
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Task {
    /**
     * name of task.
     */
    private String name;

    /**
     * Constructor.
     * @param name of task.
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Geter for name of task.
     * @return name of task.
     */
    public String getName() {
        return name;
    }
}
