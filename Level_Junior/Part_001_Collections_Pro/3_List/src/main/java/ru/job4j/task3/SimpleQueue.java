package ru.job4j.task3;

import ru.job4j.task1.ISimpleLine;
import ru.job4j.task2.LinkedContainer;

/**
 * Class SimpleQueue works according to the FIFO principle.
 * First in first out.
 *
 * @param <T> generic type.
 */
public class SimpleQueue<T> implements ISimpleLine<T> {

    /**
     * Link to the instance of LinkedContainer class.
     */
    private LinkedContainer<T> container = new LinkedContainer<>();

    /** Returns the first added element to the collection and removes it.
     * In case while the collection is empty returns null.
     * @return the last element.
     */
    @Override
    public T poll() {
        T result = null;
        if (this.container.getSize() > 0) {
            result = this.container.getFirstItem();
            this.container.removeFirst();
        }
        return result;
    }

    /**
     * Inserts the given parameter to the end of the collection.
     * @param value to be inserted.
     */
    @Override
    public void push(T value) {
        this.container.add(value);
    }
}
