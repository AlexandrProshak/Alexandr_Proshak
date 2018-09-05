package ru.job4j.task3;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class DynamicList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <T> generic type.
 */
public class DynamicList<T> implements SimpleContainer<T> {

    /**
     * Initial capacity for the new created container.
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * A base container.
     */
    private Object[] container;

    /**
     * An index for iteration by container.
     */
    private int index;

    /**
     * Constructor.
     */
    public DynamicList() {
        this.container = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(Object value) {
        if (value != null) {
            if (!checkFreeSpace()) {
                increaseCapacity();
            }
            this.container[index++] = value;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public T get(int position) {
        T result;
        if (position >= 0 && position < this.index) {
            result = (T) this.container[position];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new DynamicListIterator(this.container);
    }

    /**
     * Checks existing free space in the container.
     * @return true if free space is available.
     */
    private boolean checkFreeSpace() {
        return this.index < this.container.length;
    }

    /**
     * Increases capacity if need it.
     */
    private void increaseCapacity() {
        this.container = Arrays.copyOf(this.container,
                this.container.length * this.container.length >> 1);
    }

    /**
     * Inner class DynamicListIterator describes an iterator
     * for the DynamicList class.
     *
     * @param <E> generic type.
     */
    private class DynamicListIterator<E> implements Iterator<E> {

        /**
         * Container for the iterator.
         */
        private final Object[] container;

        /**
         * An index for the iterator.
         */
        private int index;

        /**
         * Constructor.
         * @param container container for the iteration.
         */
        DynamicListIterator(Object[] container) {
            this.container = container;
        }

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (container.length >= index) {
                if (container[index] != null) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public E next() {
            Object result;
            if (hasNext()) {
                result = container[index++];
            } else {
                throw new IllegalStateException();
            }
            return (E) result;
        }
    }

    @Override
    public SimpleContainer copy() {
        DynamicList copy = new DynamicList();
        Object[] copyCon = new Object[this.container.length];
        System.arraycopy(this.container, 0, copyCon, 0, this.container.length);
        copy.container = copyCon;
        return copy;
    }
}
