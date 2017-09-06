package ru.job4j.list;

/**
 * Interface ISimpleLine.
 * @param <T> generic type.
 */
public interface ISimpleLine<T> {

    /**
     * Returns element from the collections.
     * @return element.
     */
    T poll();

    /**
     * Insert the element to the collection.
     * @param value to be inserted.
     */
    void push(T value);
}
