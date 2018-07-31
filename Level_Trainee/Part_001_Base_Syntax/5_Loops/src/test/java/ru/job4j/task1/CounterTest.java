package ru.job4j.task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CounterTest {

    /**
     * Test.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int sum = counter.add(1, 10);
        assertThat(sum, is(30));
    }
}