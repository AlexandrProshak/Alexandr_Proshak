package ru.job4j.task0;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SquareTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SquareTest {

    /**
     * Test.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenBound0ThenEmptyArray() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {};
        assertThat(rst, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenBound1Then1() {
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1};
        assertThat(rst, is(expect));
    }
}