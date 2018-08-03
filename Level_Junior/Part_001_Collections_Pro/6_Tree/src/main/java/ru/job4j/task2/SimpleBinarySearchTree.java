package ru.job4j.task2;

/**
 * An interface SimpleBinarySearchTree describes a simple binary search tree behavior.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 *
 * @param <E> a generics parameter.
 */
public interface SimpleBinarySearchTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add element to the Binary Search Tree.
     * @param e element to be added.
     * @return boolean.
     */
    boolean add(E e);
}
