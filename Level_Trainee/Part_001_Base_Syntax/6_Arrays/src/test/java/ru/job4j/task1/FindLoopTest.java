package ru.job4j.task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FindLoopTest.
 */
public class FindLoopTest {

    /**
     * Test.
     */
    @Test
    public void whenArrayHasLength5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenArrayHasLength0ThenNegativeOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenArrayHasLength10Then9() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int value = 9;
        int result = find.indexOf(input, value);
        int expect = 9;
        assertThat(result, is(expect));
    }
}