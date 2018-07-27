package ru.job4j.task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * FactorialTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class FactorialTest {

    /**
     * Test.
     */
    @Test
    public void whenNumber5ThanReturn120() {
        Factorial fac = new Factorial();
        int result = fac.calc(5);
        assertEquals(120, result);
    }

    /**
     * Test.
     */
    @Test
    public void whenNumber0ThanReturn1() {
        Factorial fac = new Factorial();
        int result = fac.calc(0);
        assertEquals(1, result);
    }

    /**
     * Test.
     */
    @Test
    public void whenNumberNegativeThanReturnNegative1() {
        Factorial fac = new Factorial();
        int result = fac.calc(-250);
        assertEquals(-1, result);
    }

    /**
     * Test.
     */
    @Test
    public void recursionWhenNumber5ThanReturn120() {
        Factorial fac = new Factorial();
        int result = fac.recursionFac(5);
        assertEquals(120, result);
    }

    /**
     * Test.
     */
    @Test
    public void recursionWhenNumber0ThanReturn1() {
        Factorial fac = new Factorial();
        int result = fac.recursionFac(0);
        assertEquals(1, result);
    }

    /**
     * Test.
     */
    @Test
    public void recursionWhenNumberNegativeThanReturnNegative1() {
        Factorial fac = new Factorial();
        int result = fac.recursionFac(-250);
        assertEquals(-1, result);
    }
}