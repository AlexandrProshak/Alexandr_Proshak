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
    private final int[][] values;

    /**
     * An positionX for the iteration by X direction.
     */
    private int positionX = 0;

    /**
     * An positionY for the iteration by Y direction.
     */
    private int positionY = 0;

    /**
     * A constructor.
     * @param values two dimensional array.
     */
    public TwoDimensionalArrayIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        if (this.values.length > positionX && this.values[positionX].length > positionY) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next() {
        Object result;

        if (hasNext()) {
            result = this.values[positionX][positionY++];
        } else {
            throw new NoSuchElementException();
        }

        if (this.values[positionX].length == positionY) {
            positionX++;
            positionY = 0;
        }
        return result;
    }
}
