package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Class EvenIteratorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class EvenIteratorTest {

    /**
     * Testing a method next.
     */
    @Test
    public void whenGetNextThenPointerForward() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};

        EvenIterator it = new EvenIterator(array);
        it.next();
        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(6));
    }

    /**
     * Testing a method hasNext.
     */
    @Test
    public void whenGetLastElementThenHasNextFalse() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 5};

        EvenIterator it = new EvenIterator(array);
        it.next();
        it.next();
        it.next();

        assertFalse(it.hasNext());
    }

    /**
     * Testing EvenIterator in fight.
     */
    @Test
    public void whenUseHasNextUndNextThenGetAllArray() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 5};

        EvenIterator it = new EvenIterator(array);
        StringBuilder result = new StringBuilder();

        while (it.hasNext()) {
            result.append(it.next());
        }

        assertThat(result.toString(), is("246"));
    }

    /**
     * Testing EvenIterator in fight when call the method next
     * after all elements was ended.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextAfterLastElementWithoutCallHasNextThanNoSuchElementException() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 5};

        EvenIterator it = new EvenIterator(array);

            it.next();
            it.next();
            it.next();
            it.next();
    }
}