package ru.job4j.task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for calculator task.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CalculatorTest {

    /**
     * Test for method add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method subtraction.
     */
    @Test
    public void whenTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method div.
     */
    @Test
    public void whenTwoDivideTwoThenOne() {
        Calculator calc = new Calculator();
        calc.div(2D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method multiply.
     */
    @Test
    public void whenTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiply(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}