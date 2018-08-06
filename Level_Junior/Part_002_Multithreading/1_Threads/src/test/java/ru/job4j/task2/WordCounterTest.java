package ru.job4j.task2;

import org.junit.Test;

/**
 * Tests for the WordCounter class.
 */
public class WordCounterTest {

    /**
     * Tests method wordCounter().
     */
    @Test
    public void whenGiveTextLineThanReturnAmountOfWordsInIt() {
        WordCounter counter = new WordCounter("My name is john, and I like Java ");
        new Thread(counter).start();
    }
}