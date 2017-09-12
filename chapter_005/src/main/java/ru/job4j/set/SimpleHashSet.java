package ru.job4j.set;

import ru.job4j.list.LinkedContainer;

import java.util.Iterator;

/**
 * SimpleHashSet class.
 * @param <E> generic type.
 */
public class SimpleHashSet<E> {

    /**
     * An array of baskets.
     */
    private Object[] baskets;

    /**
     * Constructor.
     */
    public SimpleHashSet() {
        this.baskets = new Object[10];
    }

    /**
     * Adds an unique element to the collections.
     * @param element to be added.
     * @return true if - added; false if not.
     */
    public boolean add(E element) {
        if (element != null) {
            boolean result = false;
            int hashIndex = Math.abs(element.hashCode() % this.baskets.length);
            if (this.baskets[hashIndex] == null) {
                LinkedContainer<E> list = new LinkedContainer<>();
                list.add(element);
                this.baskets[hashIndex] = list;
                result = true;
            } else {
                LinkedContainer<E> presentList = (LinkedContainer<E>) this.baskets[hashIndex];
                Iterator<E> it = presentList.iterator();
                result = true;

                while (it.hasNext()) {
                    if (element.equals(it.next())) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    presentList.add(element);
                }
            }
            return result;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns a string which contains all elements of the collection.
     * @return string which contains from collections elements.
     */
    public String stringOfElements() {
        StringBuilder result = new StringBuilder();
        for (Object e: this.baskets) {
            if (e != null) {
                LinkedContainer<E> list = (LinkedContainer<E>) e;
                Iterator<E> it = list.iterator();
                while (it.hasNext()) {
                    result.append(it.next());
                }
            }
        }
        return result.toString();
    }
}