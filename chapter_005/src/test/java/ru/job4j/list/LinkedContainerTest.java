package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class LinkedContainerTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class LinkedContainerTest {

    /**
     * The linc for the instance of DynamicList class.
     */
    private SimpleContainer<String> linkedContainer;

    /**
     * Setups initial date for the tests.
     * @throws Exception if something went wrong.
     */
    @Before
    public void setUp() {
        this.linkedContainer = new LinkedContainer<>();
        this.linkedContainer.add("one");
        this.linkedContainer.add("two");
        this.linkedContainer.add("three");
    }

    /**
     * Tests method add().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenAddElementsThanTheyAreThere() throws Exception {
        this.linkedContainer.add("four");
        this.linkedContainer.add("fife");
        this.linkedContainer.add("six");
        this.linkedContainer.add("seven");
        this.linkedContainer.add("eight");
        this.linkedContainer.add("nine");
        this.linkedContainer.add("ten");
        this.linkedContainer.add("eleven");
        this.linkedContainer.add("twelve");
        this.linkedContainer.add("thirteen");

        assertThat(this.linkedContainer.get(12), is("thirteen"));
    }

    /**
     * Tests method get().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGetElementThanItReturns() throws Exception {
        assertThat(this.linkedContainer.get(0), is("one"));
    }

    /**
     * Tests method get() in case when IndexOutOfBoundsException.
     * @throws Exception if something went wrong.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonexistentElementThanThrowIndexOutOfBoundsException() throws Exception {
        this.linkedContainer.get(5);
    }


    /**
     * Tests an iterator.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenHasNextThanReturnNext() throws Exception {
        Iterator<String> it = this.linkedContainer.iterator();
        StringBuilder result = new StringBuilder();
        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }
        assertThat(result.toString(), is("one two three "));
    }
}