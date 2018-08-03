package ru.job4j.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator.
 * Returns an iterator of prime numbers for the given array.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PrimeIterator implements Iterator {

    /**
     * Input numbers for iteration.
     */
    private final int[] numbers;

    /**
     * Index for iteration by numbers.
     */
    private int index = 0;

    /**
     * Temporary index for iteration.
     */
    private int tmpIndex = 0;

    /**
     * Constructor.
     * @param array to iterate.
     */
    public PrimeIterator(int[] array) {
        this.numbers = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        tmpIndex = index;
        while (this.numbers.length > tmpIndex && !result) {
            result = true;

            if (this.numbers[tmpIndex] == 1) {
                result = false;
                tmpIndex++;
            }

            for (int i = 2; i < this.numbers[tmpIndex]; i++) {
                if (this.numbers[tmpIndex] % i == 0) {
                    result = false;
                    tmpIndex++;
                    i = 1;
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
            result = this.numbers[tmpIndex];
            index++;
        } else {
            throw new NoSuchElementException();
        }
        return  result;
    }
}
