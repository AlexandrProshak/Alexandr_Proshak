package ru.job4j.task3;

/**
 * Interface Copyable.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <T> generic type.
 */
public interface Copyable<T> {

    /**
     * Makes a copy of a SimpleContainer implementation.
     * @return a copy.
     */
    SimpleContainer<T> copy();
}
