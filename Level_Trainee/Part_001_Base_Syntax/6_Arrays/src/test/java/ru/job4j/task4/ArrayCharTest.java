package ru.job4j.task4;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayCharTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ArrayCharTest {

    /**
     * Test.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    /**
     * Test.
     */
    @Test
    public void whenPrefixIsEmptyStringThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("");
        assertThat(result, is(false));
    }

    /**
     * Test.
     */
    @Test
    public void whenTextIsEmptyThenFalse() {
        ArrayChar word = new ArrayChar("");
        boolean result = word.startWith("He");
        assertThat(result, is(false));
    }
}