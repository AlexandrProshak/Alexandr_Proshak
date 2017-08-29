package ru.job4j.generic;

/**
 * Class SimpleArray.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 * @param <T>
 */
public class SimpleArray<T> {

    /**
     * A private class field for store working array.
     */
    private final Object[] value;

    /**
     * An index for iteration by an array.
     */
    private int index = 0;

    /**
     * The capacity of new created array.
     */
    private  int capacity;

    /**
     * A constructor.
     * @param capacity of a new created array.
     */
    public SimpleArray(int capacity) {
        this.value = new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Adds the new element to the end of the array.
     * @param newValue is the new value to add.
     * @return true if the operation complete successfully; false if not.

     */
    public boolean add(T newValue) {
        boolean result = false;
        if (this.capacity > this.index) {
            this.value[index++] = newValue;
            result = true;
        } else {
            throw new UnsupportedOperationException("There is not enough capacity of the array.");
        }
        return result;
    }

    /**
     * Updates the new value by the given index.
     * @param index is the position of the updated element.
     * @param newValue is the new value.
     * @return true if the operation complete successfully; false if not.
     */
    public boolean update(int index, T newValue) {
        boolean result = false;
        if (index >= 0 && this.capacity > index) {
            this.value[index] = newValue;
            result = true;
        } else {
            throw new UnsupportedOperationException("There is not this index in this array.");
        }
        return result;
    }

    /**
     * Deletes the element from the array by value.
     * @param oldValue the value to delete.
     * @return true if the operation complete successfully; false if not.
     */
    public boolean delete(T oldValue) {
        boolean result = false;
        for (int i = 0; i < this.capacity; i++) {
            if (this.value[i] == oldValue) {
                this.value[i] = null;
                result = true;
                break;
            } else {
                throw new UnsupportedOperationException("There is not this value " + oldValue + " in the array");
            }
        }
        return result;
    }

    /**
     * Returns the element from the array by index.
     * @param index of the element.
     * @return the element.
     */
    public T get(int index) {
        T result;
        if (index >= 0 && this.capacity > index) {
            result = (T) this.value[index];
        } else {
            throw new UnsupportedOperationException("There is not this index in the array.");
        }
        return result;
    }
}
