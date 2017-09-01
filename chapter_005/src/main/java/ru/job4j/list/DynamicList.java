package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class DynamicList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 * @param <T> generic type.
 */
public class DynamicList<T> implements SimpleContainer, Iterable {

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
     * An index for the internal iterator.
     */
    private int iteratorIndex;

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

    /**
     * Increases capacity if need it.
     */
    private void increaseCapacity() {
        this.container = Arrays.copyOf(this.container,
                this.container.length * this.container.length >> 1);
    }

    /**
     * Checks existing free space in the container.
     * @return true if free space is available.
     */
    private boolean checkFreeSpace() {
        return this.index < this.container.length;
    }

    @Override
    public Object get(int position) {
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
        return new Iterator() {

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (container.length > iteratorIndex) {
                    if (container[iteratorIndex] != null) {
                        result = true;
                    }
                }
                return result;
            }

            @Override
            public Object next() {
                Object result = null;
                if (hasNext()) {
                    result = container[iteratorIndex++];
                }
                return result;
            }
        };
    }
}
