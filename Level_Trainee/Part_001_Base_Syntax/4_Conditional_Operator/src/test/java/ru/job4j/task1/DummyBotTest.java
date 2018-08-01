package ru.job4j.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * DummyBotTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class DummyBotTest {

    /**
     * Test.
     */
    @Test
    public void whenQuestionIsHelloBotThanAnswerHiWiseGuy() {
        DummyBot bot = new DummyBot();
        String answer = bot.answer("Hello, Bot.");
        assertEquals(answer, "Hi, wise guy.");
    }

    /**
     * Test.
     */
    @Test
    public void whenQuestionIsByeThanAnswerSeeYouSoon() {
        DummyBot bot = new DummyBot();
        String answer = bot.answer("Bye.");
        assertEquals(answer, "See you soon.");
    }

    /**
     * Test.
     */
    @Test
    public void whenQuestionIsUnknownThanAnswerConfusesMe() {
        DummyBot bot = new DummyBot();
        String answer = bot.answer("Boo.");
        assertEquals(answer, "This confuses me. Ask another question.");
    }
}