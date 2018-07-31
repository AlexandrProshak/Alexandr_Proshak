package ru.job4j.task5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSortTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class BubbleSortTest {

    /**
     * Test.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(array);
        int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSortArrayWithOneElementThenSortedArray() {
        int[] array = {1};
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(array);
        int[] expect = {1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSortArrayIsEmptyElementThenArray() {
        int[] array = {};
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(array);
        int[] expect = {};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSortArrayWithTwoElementThenSortedArray() {
        int[] array = {100, 1};
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(array);
        int[] expect = {1, 100};
        assertThat(result, is(expect));
    }
}