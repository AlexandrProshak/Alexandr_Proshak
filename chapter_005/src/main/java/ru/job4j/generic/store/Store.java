package ru.job4j.generic.store;

/**
 * Class Store.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 *
 *  @param <T> generic type.
*/
public interface Store<T extends Base> {

    /**
     * Adds element.
     *
     * @param element to add.
     * @return true if the operation complete successfully; false if not.
     */
    boolean add(T element);

    /**
     * Updates element.
     *
     * @param oldElement old element.
     * @param newElement new element.
     * @return true if the operation complete successfully; false if not.
     */
    boolean update(T oldElement, T newElement);

    /**
     * Deletes element.
     *
     * @param element to delete.
     * @return true if the operation complete successfully; false if not.
     */
    boolean delete(T element);
}