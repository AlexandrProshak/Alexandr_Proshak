package ru.jobj4.simpleequals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * The class describes tests for the class SimpleWordMatcher.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SimpleWordMatcherTest {

    /**
     * A link for the initial date.
     */
    private SimpleWordMatcher matcher;

    /**
     * Set up initial date.
     */
    @Before
    public void setUp() {
        this.matcher = new SimpleWordMatcher();
    }

    /**
     * Tests method match(). Both words are in lover register.
     */
    @Test
    public void whenTwoWordWithAllLetterInSimilarRegisterThanReturnTrue() {
        assertTrue(this.matcher.match("java", "avaj"));
    }

    /**
     * Tests method match(). One word is in lover register.
     */
    @Test
    public void whenTwoWordInDifferentRegisterThanReturnFalse() {
        assertFalse(this.matcher.match("java", "Avaj"));
    }

    /**
     * Tests method matchIgnoreCase(). Both words are in lover register.
     */
    @Test
    public void whenWordAreInSimilarRegister() {
        assertTrue(this.matcher.matchIgnoreCase("java", "avaj"));
    }

    /**
     * Tests method matchIgnoreCase(). One word is in lover register.
     */
    @Test
    public void whenTwoWordInDifferentRegisterThanReturnTrue() {
        assertTrue(this.matcher.matchIgnoreCase("java", "Avaj"));
    }

    /**
     * Tests method hasMapWordMatcher().
     */
    @Test
    public void whenTwoWordContainsSameCharacterSetThanHasMapWordMatcherTrue() {
        assertTrue(this.matcher.hasMapWordMatcher("hello", "hello"));
    }

    /**
     * Tests method hasSetWordMatcher().
     */
    @Test
    public void whenTwoWordContainsSameCharacterSetThanHasSetWordMatcherTrue() {
        assertTrue(this.matcher.hasSetWordMatcher("hello", "hello"));
    }

    /**
     * Tests method hasSetWordMatcher().
     */
    @Test
    public void whenTwoWordContainsDifferentCharacterSetThanHasSetWordMatcherFalse() {
        assertFalse(this.matcher.hasSetWordMatcher("hello", "world"));
    }
}