package ru.job4j.tree.simpletree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class tree describes a simple tree structure.
 * @param <E> generics parameter.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * A class Node describes an element of a SimpleTree.
     * @param <E> generics parameter.
     */
    private class Node<E> {
        /**
         * A value of a node.
         */
        private E value;
        /**
         * A list of children node.
         */
        private List<Node<E>> children;
        /**
         * A constructor.
         * @param value of a node.
         */
        Node(E value) {
            this.value = value;
            this.children = new LinkedList<>();
        }
    }

    /**
     * A root of a tree.
     */
    private Node<E> root;

    @Override
    public boolean add(E parent, E child) {
        if (parent == null | child == null) {
            return false;
        }
        boolean result = false;
        if (this.root == null) {
            this.root = new Node<>(parent);
            this.root.children.add(new Node<>(child));
        } else {
            result = recMove(this.root, parent, child);
        }
        return result;
    }

    /**
     * A method inserts new value use a recursion call.
     * @param currentRoot current root element.
     * @param parent value of parent node.
     * @param child value of child node.
     * @return true in case of success, or false otherwise.
     */
    private boolean recMove(Node<E> currentRoot, E parent, E child) {
        boolean result = false;
        if (currentRoot.value.compareTo(parent) == 0) {
            for (Node<E> node : currentRoot.children) {
                if (node.value.compareTo(child) == 0) {
                    return false;
                }
            }
            currentRoot.children.add(new Node<>(child));
            return true;
        } else {
            for (Node<E> node : currentRoot.children) {
                if (node.value.compareTo(parent) == 0) {
                    return recMove(node, parent, child);
                }
            }
            Node<E> parentNode = new Node<>(parent);
            parentNode.children.add(new Node<>(child));
            currentRoot.children.add(parentNode);
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Stack<Node<E>> stack = new Stack<>();
            private Node<E> node = root;
            private boolean flag = true;

            @Override
            public boolean hasNext() {
                return (!stack.isEmpty() || node != null);
            }

            @Override
            public E next() {
                if (flag) {
                    addToStack(node);
                }
                flag = false;
                return stack.pop().value;
            }

            private void addToStack(Node<E> propagatedNode) {
                stack.add(propagatedNode);
                if (!propagatedNode.children.isEmpty()) {
                    for (Node<E> innerChild : propagatedNode.children) {
                        addToStack(innerChild);
                    }
                }
                node = null;
            }
        };
    }
}