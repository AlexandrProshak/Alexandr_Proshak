package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class TwoDimensionalArrayIterator.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class TwoDimensionalArrayIterator implements Iterator {

    /**
     * An array for iterator.
     */
    private final int[] values;

    /**
     * An index for the iteration by tmpIterator array.
     */
    private int index = 0;


    /**
     * A constructor.
     * @param values two dimensional array.
     */
    public TwoDimensionalArrayIterator(int[][] values) {
        int counter = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                counter++;
            }
        }

        int[] result = new int[counter];
        int position = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                result[position++] = values[i][j];
            }
        }
        this.values = result;
    }


    @Override
    public boolean hasNext() {
        return this.values.length > index;
    }

    @Override
    public Object next() {
        Object result;
        if (this.hasNext()) {
            result = this.values[index++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
