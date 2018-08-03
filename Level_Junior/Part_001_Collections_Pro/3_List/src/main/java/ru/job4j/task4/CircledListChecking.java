package ru.job4j.task4;

/**
 * CircledListChecking class.
 * @param <T> generic type.
 */
public class CircledListChecking<T> {

    /**
     * Nested class Node.
     *
     * @param <T> generic type.
     */
    static class Node<T> {

        /**
         * Value of the node.
         */
        private T value;

        /**
         * Next Node.
         */
        private Node<T> next;

        /**
         * Setter for the field next.
         * @param next Node.
         */
        void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Constructor.
         * @param value to store.
         */
        Node(T value) {
            this.value = value;
        }
    }

    /**
     * Checking a list on having a loop by given Node.
     * @param first Node from the list.
     * @return true in case when the list has a circle and false if has not.
     */
    public boolean hasCircle(Node<T> first) {
        boolean result = false;
        if (first != null) {
            Node<T> second = first.next;
            while (second != null) {
                if (first.equals(second)) {
                    result = true;
                    break;
                } else {
                    second = second.next;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
