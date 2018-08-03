package ru.job4j.task0;

/**
 * Class SimpleArrayList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <E> generic type.
 */
public class SimpleArrayList<E> {

    /**
     * The size of a list.
     */
    private int size;

    /**
     * The head.
     */
    private Node<E> first;

    /**
     * The method inserts the element into a head.
     * @param date parameter.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * The method removes the first element from the list.
     * @return date for the removed element.
     */
    public E delete() {
        Node<E> first = this.first;
        this.first = first.next;
        return first.date;
    }

    /**
     * The method retrieves the element by index.
     * @param index of element.
     * @return element.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * The method returns a size of a list.
     * @return size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * The Node class.
     * @param <E> generic parameter.
     */
    private static class Node<E> {

        /**
         * A data.
         */
        private E date;

        /**
         * The next node.
         */
        private Node<E> next;

        /**
         * The constructor.
         * @param date parameter.
         */
        Node(E date) {
            this.date = date;
        }
    }
}