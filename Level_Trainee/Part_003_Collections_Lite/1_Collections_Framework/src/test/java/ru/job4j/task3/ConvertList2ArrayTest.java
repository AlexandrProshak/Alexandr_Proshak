package ru.job4j.task3;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConvertList2ArrayTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertList2ArrayTest {

    /**
     * Test.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void when9ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void when10ElementsThen10() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void when9ElementsThen90() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0}
        };
        assertThat(result, is(expect));
    }
}