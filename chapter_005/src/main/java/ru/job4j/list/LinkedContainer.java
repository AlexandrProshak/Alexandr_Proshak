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
     * Getter for the value of the head of the collection.
     * @return first Node.
     */
    public T getFirstItem() {
        return this.first.item;
    }

    /**
     * Pointer to last node.
     */
    private Node<T> last;

    /**
     * Getter for the value of the of the collection.
     * @return first Node.
     */
    public T getLastItem() {
        return this.last.item;
    }

    /**
     * Size of the LinkedContainer.
     */
    private int size;

    /**
     * Getter for the field size.
     * @return size of the collection.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Index for the iterator.
     */
    private int index;

    /**
     * Removes the last element from the collection.
     * @return if operation was successful returns true, otherwise - false.
     */
    public boolean removeLast() {
        boolean result = false;
        if (this.size > 0) {
            this.last = this.last.prev;
            this.size--;
            result = true;
        }
        return result;
    }

    /**
     * Removes the first element from the collection.
     * @return if operation was successful returns true, otherwise - false.
     */
    public boolean removeFirst() {
        boolean result = false;
        if (this.size > 0) {
            this.first = this.first.next;
            this.size--;
            result = true;
        }
        return result;
    }

    /**
     * Returns the Node according to given index.
     * @param index for Node to be returned.
     * @return Node.
     */
    public Node<T> node(int index) {
        Node<T> result = this.first;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return result;
    }

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
        Node<T> result;
        result = node(index);
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
