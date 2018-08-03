package ru.job4j.task1;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;

/**
 * Class TwoDimensionalArrayIteratorTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class TwoDimensionalArrayIteratorTest {

    /**
     * Testing a method next.
     */
    @Test
    public void whenGetNextThenPointerForward() {
        int[][] array = new int[][] {{1, 2}, {3, 4}};

        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);
        it.next();
        it.next();
        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(4));
    }

    /**
     * Testing a method hasNext.
     */
    @Test
    public void whenGetLastElementThenHasNextFalse() {
        int[][] array = new int[][] {{1, 2}, {3, 4}};

        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);
        it.next();
        it.next();
        it.next();
        it.next();

        assertFalse(it.hasNext());
    }

    /**
     * Testing TwoDimensionalArrayIterator in fight.
     */
    @Test
    public void whenUseHasNextUndNextThenGetAllArray() {
        int[][] array = new int[][] {{1, 2, 3, 4, 5}, {3, 4, 5, 6, 7, 8, 9}};

        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);
        StringBuilder result = new StringBuilder();

        while (it.hasNext()) {
            result.append(it.next());
        }

        assertThat(result.toString(), is("123453456789"));
    }

    /**
     * Testing TwoDimensionalArrayIterator in fight when call the method next
     * after all elements was ended.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextAfterLastElementWithoutCallHasNextThanNoSuchElementException() {
        int[][] array = new int[][] {{1, 2}, {3}};

        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);

        it.next();
        it.next();
        it.next();
        it.next();
    }

    /**
     * Test.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(new int[][] {{1}, {3, 4}, {7}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * Test.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(new int[][] {{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * Test.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(new int[][] {{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }
}