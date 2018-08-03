package ru.job4j.task0;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayListTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SimpleArrayListTest {

    /**
     * The common link.
     */
    private SimpleArrayList<Integer> list;

    /**
     * The set up method.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Test.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Test.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Test.
     */
    @Test
    public void whenRemoveFirstElementsThenReturnsFirstData() {
        assertThat(list.delete(), is(3));
    }

    /**
     * Test.
     */
    @Test
    public void whenRemoveFirstElementsThenFirstIsSecond() {
        list.delete();
        assertThat(list.get(0), is(2));
    }
}