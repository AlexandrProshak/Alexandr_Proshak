package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator.
 * Returns an iterator of even numbers for the given array.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator implements Iterator {

    /**
     * An array for iterator.
     */
    private final int[] values;

    /**
     * An index for the iteration by tmpIterator array.
     */
    private int index = 0;

    /**
     * A temporary index.
     */
    private int tmpIndex = 0;


    /**
     * A constructor.
     * @param values array to iterate.
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.values.length > index) {
            for (int i = index; i < this.values.length; i++) {
                if (this.values[i] % 2 == 0) {
                    result = true;
                    tmpIndex = i;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Object next() {
        int result;

        if (this.hasNext()) {
            index = tmpIndex;
            result = this.values[index];
            index++;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
