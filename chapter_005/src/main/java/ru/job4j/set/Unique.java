package ru.job4j.set;
import ru.job4j.list.SimpleContainer;

import java.util.Iterator;

/**
 * Unique class.
 *
 * @param <E> generic type.
 */
public class Unique<E> {

    /**
     * Checks existing element in the set.
     *
     * @param it iterator of the container.
     * @param container is a collection to be checked.
     * @param e to be checked.
     * @return true in case if element is unique, false - otherwise.
     */
    private boolean checkUniqueElement(Iterator<E> it, SimpleContainer<E> container, E e) {
        boolean result = true;
        while (it.hasNext()) {
            if (e.equals(it.next())) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Adds given elements to the given container in case if the element is unique.
     * @param it iterator of the container.
     * @param container for the unique elements.
     * @param e element.
     * @return true in case if the element was unique
     *          and it was added to the container.
     *          False - when such element was not unique and it was not added to the container.
     */
    public boolean addUniqueElement(Iterator<E> it, SimpleContainer<E> container, E e) {
        boolean result = true;
        if (e != null) {
            if (this.checkUniqueElement(it, container, e)) {
                container.add(e);
            } else {
                result = false;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
