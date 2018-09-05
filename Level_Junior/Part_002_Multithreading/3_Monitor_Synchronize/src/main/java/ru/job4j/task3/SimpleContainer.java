package ru.job4j.task3;

/**
 * Interface SimpleContainer.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <T> generic type.
 */
public interface SimpleContainer<T> extends Iterable<T>, Copyable {

    /**
     * Adds element.
     * @param value to add.
     */
    void add(T value);

    /**
     * Gets element by index.
     * @param index of getting element.
     * @return element.
     */
    T get(int index);
}
