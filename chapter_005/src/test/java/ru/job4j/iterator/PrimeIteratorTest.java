package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class PrimeIteratorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class PrimeIteratorTest {

    /**
     * Testing a method next.
     */
    @Test
    public void whenGetNextThenPointerMoveForward() {
        int[] array = new int[] {1, 2, 3, 4, 5, 8, 11, 13, 9, 10, 17};

        PrimeIterator it = new PrimeIterator(array);
        it.next();
        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(5));
    }

    /**
     * Testing a method hasNext.
     */
    @Test
    public void whenGetLastPrimeElementThenHasNextFalse() {
        int[] array = new int[] {1, 2, 3, 4, 5, 8, 11};

        PrimeIterator it = new PrimeIterator(array);
        it.next();
        it.next();
        it.next();
        it.next();

        assertFalse(it.hasNext());
    }

    /**
     * Testing PrimeIterator in fight.
     */
    @Test
    public void whenUseHasNextUndNextThenGetAllPrimeElements() {
        int[] array = new int[] {1, 2, 3, 4, 5, 8, 11, 13, 9, 10, 17};

        PrimeIterator it = new PrimeIterator(array);
        StringBuilder result = new StringBuilder();

        while (it.hasNext()) {
            result.append(it.next());
        }

        assertThat(result.toString(), is("235111317"));
    }

    /**
     * Testing TwoDimensionalArrayIterator in fight when call the method next
     * after all elements was ended.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextAfterLastPrimeElementWithoutCallHasNextThanNoSuchElementException() {
        int[] array = new int[] {1, 2, 3};

        PrimeIterator it = new PrimeIterator(array);

        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
    }
}