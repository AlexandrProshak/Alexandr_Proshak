package ru.job4j.task1;

import java.util.Iterator;

/**
 * SimpleSetArray class.
 * @param <E> generic type.
 */
public class SimpleSetArray<E> implements ISimpleSet<E> {

    /** Link to the container of unique elements. */
    private DynamicList<E> container;

    /**
     * Constructor.
     */
    public SimpleSetArray() {
        this.container = new DynamicList<>();
    }

    /**
     * Adds unique elements to the collection.
     * @param e to be added.
     */
    @Override
    public boolean add(E e) {
        Unique<E> unique = new Unique<>();
        Iterator<E> it = this.container.newIterator();
        return unique.addUniqueElement(it, this.container, e);
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
