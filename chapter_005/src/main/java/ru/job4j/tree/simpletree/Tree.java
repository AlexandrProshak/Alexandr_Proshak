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
            result = recursiveMove(this.root, parent, child);
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
    private boolean recursiveMove(Node<E> currentRoot, E parent, E child) {
        boolean result;
        Node<E> parentNodeValue = new Node<>(parent);
        Node<E> childNodeValue = new Node<>(child);
        Node<E> foundParent = findNode(parent);
        Node<E> foundChild = findNode(child);

        if (foundParent == null) {
            if (foundChild == null) {
                parentNodeValue.children.add(childNodeValue);
                currentRoot.children.add(parentNodeValue);
                result = true;
            } else {
                currentRoot.children.add(parentNodeValue);
                result = true;
            }
        } else if (foundChild == null) {
            foundParent.children.add(childNodeValue);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * A method searches a node by given value.
     * @param value is value to be found.
     * @return node which contains given value.
     */
    private Node<E> findNode(E value) {
        Node<E> result = this.root;
        if (result.value.compareTo(value) != 0) {
            result = recursiveSearch(result, value);
        }
        return result;
    }

    /**
     * A method recursive searches a node with given value.
     * @param currentRoot current node to start searching.
     * @param value is value to be found.
     * @return node which contains given value.

     */
    private Node<E> recursiveSearch(Node<E> currentRoot, E value) {
    Node<E> result = null;
        for (Node<E> child : currentRoot.children) {
            if (child.value.compareTo(value) == 0) {
                result = child;
                break;
            }
            if (result == null) {
                result = recursiveSearch(child, value);
            }
        }
    return result;
    }

    /**
     * A method check the tree is it binary or not.
     * @return true if a tree is binary, or false otherwise.
     */
    public boolean isBinary() {
        try {
            if (!root.children.isEmpty()) {
                return recursiveBinaryCheck(this.root);
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * A method check a propagated root, uses a recursion call,
     * has the root <= 2 children or not.
     * @param propagatedRoot root to check.
     * @return true if root has <= children, or false otherwise.
     */
    private boolean recursiveBinaryCheck(Node<E> propagatedRoot) {
        boolean result = true;
        if (propagatedRoot.children.size() <= 2) {
            for (Node<E> node : propagatedRoot.children) {
                return recursiveBinaryCheck(node);
            }
        } else {
            result = false;
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