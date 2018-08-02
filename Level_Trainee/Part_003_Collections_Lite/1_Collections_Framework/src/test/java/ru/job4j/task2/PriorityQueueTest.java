package ru.job4j.task2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PriorityQueueTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PriorityQueueTest {

    /**
     * Test.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * Test.
     */
    @Test
    public void whenMiddlePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task take = queue.take();
        Task result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }
}