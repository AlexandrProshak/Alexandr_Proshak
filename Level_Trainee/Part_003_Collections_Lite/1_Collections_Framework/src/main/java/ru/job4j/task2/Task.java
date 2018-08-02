package ru.job4j.task2;

/**
 * Task.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Task {

    /**
     * The task description.
     */
    private String desc;

    /**
     * The task priority.
     */
    private int priority;

    /**
     * The constructor.
     * @param desc parameter.
     * @param priority parameter..
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * The getter.
     * @return desc.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * The getter.
     * @return priority.
     */
    public int getPriority() {
        return priority;
    }
}