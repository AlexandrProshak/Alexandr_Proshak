package ru.job4j.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class LinkedContainerTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class LinkedContainerTest {

    /**
     * The linc for the instance of DynamicList class.
     */
    private LinkedContainer<String> linkedContainer;

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

    /**
     * Tests a removeLast().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTheLastElementIsDeletedThanReturnTrue() throws Exception {
        assertTrue(this.linkedContainer.removeLast());
    }

    /**
     * Tests a removeFirst().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTheFirstElementIsDeletedThanReturnTrue() throws Exception {
        assertTrue(this.linkedContainer.removeFirst());
    }

    /**
     * Tests rest of collection after removeFirst() by an iterator.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTheFirstElementIsDeletedThanCollectionHasNotTheFirstElement() throws Exception {
        Iterator<String> it = this.linkedContainer.iterator();
        StringBuilder result = new StringBuilder();
        this.linkedContainer.removeFirst();
        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }
        assertThat(result.toString(), is("two three "));
    }

    /**
     * Tests decreasing size after removeLast() .
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTheLastElementIsDeletedThanSizeIsDecreased() throws Exception {
        this.linkedContainer.removeLast();
        assertThat(this.linkedContainer.getSize(), is(2));
    }

    /**
     * Tests rest of collection after removeLast() by an iterator.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenTheLastElementIsDeletedThanCollectionHasNotTheLastElement() throws Exception {
        Iterator<String> it = this.linkedContainer.iterator();
        StringBuilder result = new StringBuilder();
        this.linkedContainer.removeLast();
        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }
        assertThat(result.toString(), is("one two "));
    }
}