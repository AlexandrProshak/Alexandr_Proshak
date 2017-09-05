package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedContainer.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 * @param <T> generic type.
 */
public class LinkedContainer<T> implements SimpleContainer<T> {

    /**
     * Nested inner class Node, describes linked nodes.
     * @param <T> generic type.
     */
    private static class Node<T> {

        /** Link to the store date.*/

        private T item;

        /** Link to the previous node.*/
        private Node<T> prev;

        /** Link to the next node.*/
        private Node<T> next;

        /**
         * Constructor.
         * @param prev is a previous node.
         * @param item is a element for store.
         * @param next is a next node.
         */
        private Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    /**
     * Pointer to first node.
     */
    private Node<T> first;

    /**
     * Pointer to last node.
     */
    private Node<T> last;

    /**
     * Size of the LinkedContainer.
     */
    private int size;

    /**
     * Index for the iterator.
     */
    private int index;

    @Override
    public void add(T value) {
        Node<T> l = this.last;
        Node<T> newNode = new Node<>(l, value, null);
        this.last = newNode;

        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> result = this.first;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return result.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < size) {
                    result = true;
                }
                return result;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return get(index++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
