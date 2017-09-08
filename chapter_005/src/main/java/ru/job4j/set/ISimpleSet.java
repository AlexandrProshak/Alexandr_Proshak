package ru.job4j.set;

import java.util.Iterator;

/**
 * Interface ISimpleSet.
 * @param <E> generic type.
 */
public interface ISimpleSet<E> extends Iterable<E> {

    /**
     * Adds element to the set.
     * @param e to be added.
     * @return true in case successfully operation.
     */
    boolean add(E e);

    @Override
    Iterator<E> iterator();
}
