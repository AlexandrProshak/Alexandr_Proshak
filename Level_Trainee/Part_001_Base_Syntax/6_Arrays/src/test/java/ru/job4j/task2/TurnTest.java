package ru.job4j.task2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class TurnTest {

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnEmptyArrayThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {};
        int[] result = turner.turn(input);
        int[] expect = new int[] {};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithOneElementThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1};
        int[] result = turner.turn(input);
        int[] expect = new int[] {1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithTwoElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[] {2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArrayRec() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.turnRec(input, 0);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArrayRec() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turnRec(input, 0);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnEmptyArrayThenTurnedArrayRec() {
        Turn turner = new Turn();
        int[] input = new int[] {};
        int[] result = turner.turnRec(input, 0);
        int[] expect = new int[] {};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithOneElementThenTurnedArrayRec() {
        Turn turner = new Turn();
        int[] input = new int[] {1};
        int[] result = turner.turnRec(input, 0);
        int[] expect = new int[] {1};
        assertThat(result, is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenTurnArrayWithTwoElementsThenTurnedArrayRec() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2};
        int[] result = turner.turnRec(input, 0);
        int[] expect = new int[] {2, 1};
        assertThat(result, is(expect));
    }
}