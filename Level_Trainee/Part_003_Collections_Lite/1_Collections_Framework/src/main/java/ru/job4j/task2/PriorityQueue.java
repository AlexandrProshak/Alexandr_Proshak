package ru.job4j.task2;

import java.util.LinkedList;

/**
 * PriorityQueue.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PriorityQueue {

    /**
     * The storage.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method inserts element into the right position.
     * The position figure out according to the priority field..
     * To inserting use method add(int index, E value)
     * @param task to be added.
     */
    public void put(Task task) {
        boolean added = false;
        int priority = task.getPriority();
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            for (int i = 0; i < this.tasks.size(); i++) {
                if (priority <= this.tasks.get(i).getPriority()) {
                    this.tasks.add(i, task);
                    added = true;
                    break;
                }
            }
            if (!added) {
                this.tasks.add(task);
            }
        }
    }

    /**
     * The method retrieves and removes the head (first element) of this list.
     * @return first element of this list.
     */
    public Task take() {
        return this.tasks.poll();
    }
}