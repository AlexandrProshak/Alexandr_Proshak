package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

/**
 * Class AbstractStore.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractStore implements Store {

    /**
     * Store of the Base element.
     */
    private SimpleArray<Base> store;

    /**
     * Constructor.
     * @param size of SimpleArray.
     */
    public AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
    }

    /**
     * Adds element.
     * @param element to add.
     * @return true if the operation complete successfully; false if not.
     */
    @Override
    public boolean add(Base element) {
        return this.store.add(element);
    }

    /**
     * Updates element.
     * @param oldElement old value.
     * @param newElement new value.
     * @return true if the operation complete successfully; false if not.
     */
    @Override
    public boolean update(Base oldElement, Base newElement) {
        return this.store.update(oldElement, newElement);
    }

    /**
     * Deletes element.
     * @param element to delete.
     * @return true if the operation complete successfully; false if not.
     */
    @Override
    public boolean delete(Base element) {
        return this.store.delete(element);
    }
}
