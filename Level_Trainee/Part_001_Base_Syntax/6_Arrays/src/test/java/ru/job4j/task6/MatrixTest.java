package ru.job4j.task6;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MatrixTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class MatrixTest {

    /**
     * Test.
     */
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSizeOne() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(1);
        int[][] expect = {{1}};
        assertThat(table, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSizeZero() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(0);
        int[][] expect = {};
        assertThat(table, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenSizeThree() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(3);
        int[][] expect = {
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        assertThat(table, is(expect));
    }
}