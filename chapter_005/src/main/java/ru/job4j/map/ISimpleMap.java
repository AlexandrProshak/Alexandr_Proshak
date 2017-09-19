package ru.job4j.map;

import java.security.InvalidKeyException;

/**
 * ISimpleMap is an interface for simple map.
 *
 * @param <T> generic type for key.
 * @param <V> generic type for value.
 */
public interface ISimpleMap<T, V> extends Iterable {

    /**
     * Inserts the given value in case of unique key.
     * @param key is key.
     * @param value is value to be inserted.
     * @return true if it's inserted; false - if not.
     */
    boolean insert(T key, V value);

    /**
     * Returns the value from the map by the key.
     * @param key is key.
     * @return value.
     * @throws InvalidKeyException if key is wrong.
     */
    V get(T key) throws InvalidKeyException;

    /**
     * Deletes value from the map by the key.
     * @param key is kay.
     * @return true if it's deleted; false - if not.
     */
    boolean delete(T key);
}
