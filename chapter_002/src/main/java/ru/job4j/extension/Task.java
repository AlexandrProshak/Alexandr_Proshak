package ru.job4j.extension;

/**
 * Class Task describes a simple template of a task.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Task {
    /**
     * A name of task.
     */
    private String name;

    /**
     * A constructor.
     * @param name of a task.
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Geter for name's of a ask.
     * @return name of a task.
     */
    public String getName() {
        return name;
    }
}
