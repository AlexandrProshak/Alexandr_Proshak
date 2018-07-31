package ru.job4j.task3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CheckTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CheckTest {

    /**
     * Test.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataHasOneElementTrueByThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataHasOneElementFalseByThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataIsEmptyElementThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

}