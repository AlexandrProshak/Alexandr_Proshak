package ru.job4j.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Class Converter returns an iterator of Integer.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Converter {

    /**
     * A method returns an Iterator<Integer> from Iterator<Iterator<Integer>>.
     * @param it compound iterator.
     * @return Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> innerIterator = initInnerIterator();
            @Override
            public void forEachRemaining(Consumer<? super Integer> action) {
                throw new UnsupportedOperationException();
            }

            /**
             * The method init check inner iterator points on empty collection or not.
             * @return iterator.
             */
            public Iterator<Integer> initInnerIterator() {
                Iterator<Integer> currentIterator = (new ArrayList<Integer>()).iterator();
                while (it.hasNext()) {
                    currentIterator = it.next();
                    if (currentIterator.hasNext()) {
                        break;
                    }
                }
                return currentIterator;
            }
            @Override
            public boolean hasNext() {
                return innerIterator.hasNext();
            }
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer result = innerIterator.next();
                if (!innerIterator.hasNext() && it.hasNext()) {
                    this.innerIterator = initInnerIterator();
                }
                return result;
            }
        };
    }
}