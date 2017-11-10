package ru.job4j.tree.simpletree;

/**
 * An interface SimpleTree describes a simple tree behavior.
 * @param <E> a generics parameter.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add child's element to a parent.
     * Parent can have a list of child.
     * @param parent parent.
     * @param child child.
     * @return boolean.
     */
    boolean add(E parent, E child);
}
