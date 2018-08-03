package ru.job4j.task1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class SimpleArrayTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {

    /**
     * The array for the executions.
     */
    private SimpleArray<String> array;

    /**
     * The capacity of this simple array.
     */
    private int capacity = 10;

    /**
     * Setups initial date for the tests.
     * @throws Exception if something went wrong.
     */
    @Before
    public void setUp() throws Exception {
        this.array = new SimpleArray<>(capacity);
    }

    /**
     * Testing the method add().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenAddNewElementThanIrIsInSimpleArray() throws Exception {
        this.array.add("one");
    }

    /**
     * Testing the method add() in the case when there is not enough capacity.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenAddMoreNewElementsThanCapacityThanThrowUnsupportedOperationException() throws Exception {
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        assertTrue(this.array.add("one"));
    }

    /**
     * Testing the method update() by the index.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenUpdateExistingElementThanReturnTrue() throws Exception {
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        this.array.add("one");
        assertTrue(this.array.update(2, "two"));
    }

    /**
     * Testing the method update() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenUpdateUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add("one");
        this.array.update(-1, "two");
    }

    /**
     * * Testing the method delete() by the value.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenDeleteExistingElementThanReturnTrue() throws Exception {
        this.array.add("one");
        this.array.add("two");
        this.array.add("one");
        assertTrue(this.array.delete("two"));
    }

    /**
     * Testing the method delete() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenDeleteUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add("one");
        assertFalse(this.array.delete("fife"));
    }

    /**
     * Testing the method get() by the index.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGetExistingElementThanReturnThisElement() throws Exception {
        this.array.add("one");
        this.array.add("two");
        this.array.add("three");
        assertThat(this.array.get(1), is("two"));
    }

    /**
     * Testing the method get() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenGetUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add("one");
        this.array.add("two");
        this.array.get(-1);
    }
}