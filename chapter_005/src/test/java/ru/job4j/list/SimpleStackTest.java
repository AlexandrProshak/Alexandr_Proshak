package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * SimpleStackTest class.
 */
public class SimpleStackTest {

    /**
     * Tests method push().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenPushElementsThanTheyPulledInReversionOrder() throws Exception {
        ISimpleLine<String> stack = new SimpleStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        StringBuilder builder = new StringBuilder();
        assertThat(builder
                .append(stack.poll())
                .append(stack.poll())
                .append(stack.poll()).toString(), is("321"));
    }

    /**
     * Tests method poll() in case while the collection is empty.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenPullElementFromTheEmptyCollectionThanReturnsNull() throws Exception {
        ISimpleLine<String> stack = new SimpleStack<>();
        stack.push("1");
        stack.push("2");
        stack.poll();
        stack.poll();
        assertNull(stack.poll());
    }
}