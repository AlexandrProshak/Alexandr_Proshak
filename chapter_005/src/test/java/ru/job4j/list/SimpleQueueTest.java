package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * SimpleQueueTest class.
 */
public class SimpleQueueTest {

    /**
     * Tests method push().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenPushElementsThanTheyPulledInInsertionOrder() throws Exception {
        ISimpleLine<String> stack = new SimpleQueue<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        StringBuilder builder = new StringBuilder();
        assertThat(builder
                .append(stack.poll())
                .append(stack.poll())
                .append(stack.poll()).toString(), is("123"));
    }

    /**
     * Tests method poll() in case while the collection is empty.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenPullElementFromTheEmptyCollectionThanReturnsNull() throws Exception {
        ISimpleLine<String> stack = new SimpleQueue<>();
        stack.push("1");
        stack.push("2");
        stack.poll();
        stack.poll();
        assertNull(stack.poll());
    }
}