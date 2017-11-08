package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * A class tree describes a simple tree structure.
 * The tree can not store null elements.
 * @param <E> a generics parameter.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * The root element o the tree.
     */
    private Node<E> root;

    @Override
    public boolean add(E parent, E child) {
        if (parent == null | child == null) {
            return false;
        }
        boolean result;
        Node<E> parentNode = new Node<>(parent);
        Node<E> childNode = new Node<>(child);
        if (this.root == null) {
            this.root = parentNode;
            this.root.children.add(childNode);
            result = true;
        } else {
            translate(this.root, parentNode, childNode);
            result = true;
        }
        return result;
    }

    /**
     * A recursion method adds nodes to the tree.
     * @param currentRoot existing root of the tree.
     * @param parent a rooted node for the given child.
     * @param child a child node for the given parent.
     */
    private void translate(Node<E> currentRoot, Node<E> parent, Node<E> child) {
        if (currentRoot.value.compareTo(parent.value) > 0) {
            if (currentRoot.left == null) {
                currentRoot.left = parent;
                currentRoot.left.children.add(child);
            } else {
                translate(currentRoot.left, parent, child);
            }
        } else if (currentRoot.value.compareTo(parent.value) < 0) {
            if (currentRoot.right == null) {
                currentRoot.right = parent;
                currentRoot.right.children.add(child);
            } else {
                translate(currentRoot.right, parent, child);
            }
        } else if (currentRoot.value.compareTo(parent.value) == 0) {
            currentRoot.children.add(child);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> node = root;
            private Stack<Node<E>> stack = new Stack<>();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (!stack.isEmpty()) {
                    result = true;
                } else if (node != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                Node<E> tmp = node;
                node = node.right;
                E value = tmp.value;
                return value;
            }
        };
    }

    /**
     * class Node describes an element of the tree.
     * @param <E> generics parameter.
     */
    private class Node<E> {
        /**
         * A value of a node.
         */
        private E value;
        /**
         * A link to the left node.
         */
        private Node<E> left;
        /**
         * A link to the right node.
         */
        private Node<E> right;
        /**
         * A list of the node's children.
         */
        private List<Node<E>> children;

        /**
         * A constructor.
         * @param value of a node.
         */
        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.children = new LinkedList<>();
        }
    }
}