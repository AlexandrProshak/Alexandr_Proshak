package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter returns an iterator of Integer.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    /**
     * A method returns an Iterator<Integer> from Iterator<Iterator<Integer>>.
     * @param it compound iterator.
     * @return Iterator<Integer>.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new ConvertedIterator(it);
    }

    /**
     * Class ConvertedIterator is a inner class of the class Converter
     * witch returns an Iterator<Integer>.
     *
     * @author Alex Proshak (olexandr_proshak@ukr.net)
     * @version $Id$
     * @since 0.1
     */
    private class ConvertedIterator implements Iterator<Integer> {

        /**
         * A field for input Iterator of iterators.
         */
        private final Iterator<Iterator<Integer>> compoundIterator;

        /**
         * Resulting iterator.
         */
        private Iterator<Integer> iterator;

        /**
         * Constructor for the inner class.
         * @param it input Iterator of Iterators
         */
        private ConvertedIterator(Iterator<Iterator<Integer>> it) {
            this.compoundIterator = it;
        }

        @Override
        public boolean hasNext() {
            boolean result = this.compoundIterator.hasNext();
            if (!result) {
                result = this.iterator.hasNext();
            }
            return result;
        }

        @Override
        public Integer next() {
            Integer result = null;

            if (this.iterator == null) {
                if (this.compoundIterator.hasNext()) {
                    this.iterator = this.compoundIterator.next();
                }
            } else if (!this.iterator.hasNext()) {
                if (this.compoundIterator.hasNext()) {
                    this.iterator = this.compoundIterator.next();
                }
            }

            if (this.iterator.hasNext()) {
                result = this.iterator.next();
            } else {
                if (this.compoundIterator.hasNext()) {
                    this.iterator = this.compoundIterator.next();
                    result = this.iterator.next();
                }
            }

            if (result == null) {
                throw new NoSuchElementException();
            } else {
                return result;
            }
        }
    }
}