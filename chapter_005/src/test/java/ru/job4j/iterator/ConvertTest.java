package ru.job4j.iterator;

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
 * @version $Id$
 * @since 0.1
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
}