package ru.job4j.task1;

/**
 * An interface SimpleTree describes a simple tree behavior.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 *
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
