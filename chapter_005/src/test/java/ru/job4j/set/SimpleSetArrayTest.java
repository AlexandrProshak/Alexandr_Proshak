package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * SimpleSetArrayTest class.
 */
public class SimpleSetArrayTest {

    /**
     * Link to the instance of SimpleSetArray.
     */
    private ISimpleSet<String> set;

    /**
     * Setups initialize date.
     */
    @Before
    public void setUp() {
        this.set = new SimpleSetArray<>();
        this.set.add("one");
        this.set.add("two");
        this.set.add("three");
        this.set.add("three");
        this.set.add("2");
        this.set.add("1");
        this.set.add("one");
    }

    /**
     * Tests method add().
     */
    @Test
    public void whenAddUniqueElementThanReturnTrue() {
        assertTrue(this.set.add("3"));
    }

    /**
     * Tests method add() in case adds none unique element.
     */
    @Test
    public void whenAddNoneUniqueElementThanReturnFalse() {
        assertFalse(this.set.add("one"));
    }

    /**
     * Tests iterator in fight.
     */
    @Test
    public void whenHasNextThenReturnAllUniqueElement() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("one");
        expectedResult.add("two");
        expectedResult.add("three");
        expectedResult.add("1");
        expectedResult.add("2");

        List<String> result = new ArrayList<>();
        Iterator<String> it = this.set.iterator();

        while (it.hasNext()) {
            result.add(it.next());
        }

        assertTrue(result.containsAll(expectedResult));
    }
}