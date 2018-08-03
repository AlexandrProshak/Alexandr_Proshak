package ru.job4j.task2;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIteratorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)

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

    /**
     * Test.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator<Integer> it = new EvenIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Test.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator<Integer> it = new EvenIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    /**
     * Test.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        Iterator<Integer> it = new EvenIterator(new int[] {1});
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test.
     */
    @Test
    public void allNumbersAreEven() {
        Iterator<Integer> it = new EvenIterator(new int[] {2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}