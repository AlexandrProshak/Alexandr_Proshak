package ru.job4j.task2;

import org.junit.Test;

/**
 * Tests for the SpacingCounter class.
 */
public class SpacingCounterTest {

    /**
     * Tests method spaceCounter().
     */
    @Test
    public void whenGiveTextLineThanReturnAmountOfWhiteSpaceInIt() {
        SpacingCounter counter = new SpacingCounter("My name is john, and I like Java");
        new Thread(counter).start();
    }
}