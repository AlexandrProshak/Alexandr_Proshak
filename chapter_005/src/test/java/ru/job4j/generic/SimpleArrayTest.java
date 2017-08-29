package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
    private SimpleArray<Integer> array;

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
        assertTrue(array.add(8));
    }

    /**
     * Testing the method add() in the case when there is not enough capacity.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenAddMoreNewElementsThanCapacityThanThrowUnsupportedOperationException() throws Exception {
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        this.array.add(8);
        assertTrue(this.array.add(8));
    }

    /**
     * Testing the method update() by the index.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenUpdateExistingElementThanReturnTrue() throws Exception {
        this.array.add(8);
        this.array.add(8);
        this.array.add(1);
        this.array.add(8);
        this.array.add(8);
        assertTrue(this.array.update(2, 25));
    }

    /**
     * Testing the method update() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenUpdateUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add(8);
        this.array.update(-1, 25);
    }

    /**
     * * Testing the method delete() by the value.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenDeleteExistingElementThanReturnTrue() throws Exception {
        this.array.add(8);
        this.array.add(8);
        assertTrue(this.array.delete(8));
    }

    /**
     * Testing the method delete() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenDeleteUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add(8);
        this.array.delete(7);
    }

    /**
     * Testing the method get() by the index.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGetExistingElementThanReturnThisElement() throws Exception {
        this.array.add(8);
        this.array.add(8);
        assertThat(this.array.get(1), is(8));
    }

    /**
     * Testing the method get() in case while there is not given index.
     * @throws Exception if something went wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenGetUnExistingElementThanThrowUnsupportedOperationException() throws Exception {
        this.array.add(8);
        this.array.add(8);
        assertThat(this.array.get(-1), is(8));
    }
}