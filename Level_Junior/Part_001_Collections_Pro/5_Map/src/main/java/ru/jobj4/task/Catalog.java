package ru.jobj4.task;

import java.security.InvalidKeyException;
import java.util.Iterator;

/**
 * Catalog class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 *
 * @param <T> generic type for key.
 * @param <V> generic type for value.
 */
public class Catalog<T, V> implements ISimpleMap<T, V> {

    /**
     * Nested inner class Node.
     *
     * @param <T> generic type for key.
     * @param <V> generic type for value.
     */
    class Node<T, V> {

        /**
         * Field for key.
         */
        private T key;

        /**
         * Field for value.
         */
        private V value;

        /**
         * Constructor.
         * @param key is a key.
         * @param value is a value.
         */
        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter for the key.
         * @return key.
         */
        public T getKey() {
            return key;
        }

        /**
         * Getter for the value.
         * @return value.
         */
        public V getValue() {
            return value;
        }
    }

    /**
     * An array for storing elements with unique key.
     */
    private Node<T, V>[] table;

    /**
     * A default amount of baskets.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Amount of elements.
     */
    private int size = 0;

    /**
     * LoadFactor.
     */
    private float  loadFactor = 0.75f;

    /**
     * Constructor.
     */
    public Catalog() {
        this.table = new Node[DEFAULT_CAPACITY];
    }

    /**
     * Constructor with capacity.
     * @param capacity is initial capacity.
     */
    public Catalog(int capacity) {
        this.table = new Node[capacity];
    }

    /**
     * Constructor with capacity and load factor.
     * @param capacity is initial capacity.
     * @param loadFactor is initial load factor.
     */
    public Catalog(int capacity, float loadFactor) {
        this.table = new Node[capacity];
        this.loadFactor = loadFactor;
    }

    @Override
    public boolean insert(T key, V value) {
        boolean result = false;

        if (((int) (this.table.length * loadFactor)) <= size) {
            resize();
        }

        int insertIndex = getTableIndexByKey(key);
        if (this.table[insertIndex] == null) {
            this.table[insertIndex] = new Node<>(key, value);
            this.size++;
            result = true;
        }
        return result;
    }

    /**
     * Returns index of basket.
     * @param key is a key of element.
     * @return index.
     */
    private int getTableIndexByKey(T key) {
        int h = key != null ? key.hashCode() : 0;
        int result = Math.abs(h) % (this.table.length);
        return result;
    }

    /**
     * Creates new array with increased capacity with content all elements from the table.
     * @return true when everything was ok; false - otherwise.
     */
    private boolean resize() {
        boolean result;
        Catalog<T, V> newTable = new Catalog<>(this.size * 2);
        for (Node node: this.table) {
            if (node != null) {
                newTable.insert((T) node.key, (V) node.value);
            }
        }
        this.table = newTable.table;
        result = true;
        return result;
    }

    @Override
    public V get(T key) throws InvalidKeyException {
        V result;
        try {
            result = this.table[getTableIndexByKey(key)].value;
        } catch (Exception e) {
            throw new InvalidKeyException();
        }
        return result;
    }

    @Override
    public boolean delete(T key) {
        boolean result = true;
        if (this.table[getTableIndexByKey(key)] == null) {
            result = false;
        }
        if (true) {
            this.table[getTableIndexByKey(key)] = null;
            size--;
        }
        return result;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {

            /**
             * Index for an iterator.
             */
            private int index = 0;

            /**
             * Index for an iterator.
             */
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (table.length > index) {
                    for (int i = index; i < table.length; i++) {
                        if (table[i] != null) {
                            currentIndex = i;
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Node next() {
                Node result = null;
                if (hasNext()) {
                    index = currentIndex;
                    result = table[index++];
                }
                return result;
            }
        };
    }
}
