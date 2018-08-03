package ru.job4j.task2;

import java.util.Iterator;
import java.util.Stack;

/**
 * Class BinarySearchTree describes a simple Binary SearchT tree implementation.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 *
 * @param <E> generics parameter.
 */
public class BinarySearchTree<E extends Comparable<E>> implements SimpleBinarySearchTree<E> {

    /**
     * A class Node describes an element of a Binary SearchT tree.
     * @param <E> generics parameter.
     */
    private class Node<E> {
        /**
         * A value of a node.
         */
        private E value;
        /**
         * A left kid.
         */
        private Node<E> left;
        /**
         * A right kid.
         */
        private Node<E> right;

        /**
         * A constructor.
         * @param value of a node.
         */
        Node(E value) {
            this.value = value;
        }
    }

    /**
     * A root af the tree.
     */
    private Node<E> root;

    @Override
    public boolean add(E e) {
        boolean result = false;
        try {
            if (this.root == null) {
                this.root = new Node<>(e);
                result = true;
            } else {
                return recursionAdd(this.root, e);
            }
        } catch (Exception exception) {
            return false;
        }
        return result;
    }

    /**
     * A method inserts new value use a recursion call.
     * @param currentNode current node element.
     * @param e new value to be inserted.
     * @return true in case of success, or false otherwise.
     */
    private boolean recursionAdd(Node<E> currentNode, E e) {
        if (currentNode.value.compareTo(e) >= 0) {
            if (currentNode.left == null) {
                currentNode.left = new Node<>(e);
                return true;
            } else {
                return recursionAdd(currentNode.left, e);
            }
        } else if (currentNode.value.compareTo(e) < 0) {
            if (currentNode.right == null) {
                currentNode.right = new Node<>(e);
                return true;
            } else {
                return recursionAdd(currentNode.right, e);
            }
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = root;
            private Stack<Node<E>> stack = new Stack<>();

            @Override
            public boolean hasNext() {
                return (node != null || !stack.isEmpty());
            }

            @Override
            public E next() {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                Node<E> result = node;
                node = node.right;
                return result.value;
            }
        };
    }
}
