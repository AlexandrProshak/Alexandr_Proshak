package ru.job4j.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertTest {

    /**
     * Test in case when the method convert() has to work correct.
     */
    @Test
    public void whenItHasTreeInnerIteratorThenWorksLikeWithOne() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(1).iterator(),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.next();
        convert.next();
        int result = convert.next();

        assertThat(result, is(3));
    }

    /**
     * Test in case using in a loop.
     */
    @Test
    public void whenItHasTreeInnerIteratorThenReturnsAllElements() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(1).iterator(),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        String expectedResult = "11234567";

        StringBuilder result = new StringBuilder();

        while (convert.hasNext()) {
            result.append(convert.next());
        }

        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Test case when NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextAfterLastElementThenNoSuchElementException() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                new ArrayList<>(Arrays.asList(2, 3)).iterator()
        ).iterator();

        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.next();
        convert.next();
        convert.next();
    }

    /**
     * An iterator.
     */
    private Iterator<Integer> it;

    /**
     * The set up method.
     */
    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
    }

    /**
     * Test.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Test.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Test.
     */
    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        Iterator<Integer> itt1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> itt2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> itt3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(itt1, itt2, itt3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test.
     */
    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }
}