package ru.job4j.set;

import ru.job4j.list.LinkedContainer;
import ru.job4j.list.SimpleContainer;

import java.util.Iterator;

/**
 * SimpleSetLinkedList class.
 * @param <E> generic type.
 */
public class SimpleSetLinkedList<E> implements ISimpleSet<E> {

    /**
     * Link to the Linked container to store elements.
     */
    private SimpleContainer<E> container;

    /**
     * Constructor.
     */
    public SimpleSetLinkedList() {
        this.container = new LinkedContainer<>();
    }

    /**
     * Adds unique elements to the collection.
     * @param e to be added.
     */
    @Override
    public boolean add(E e) {
        Unique<E> unique = new Unique<>();
        Iterator<E> it = this.container.iterator();
        return unique.addUniqueElement(it, this.container, e);
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
