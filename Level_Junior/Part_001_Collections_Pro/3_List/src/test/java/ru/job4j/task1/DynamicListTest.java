package ru.job4j.task1;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DynamicListTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class DynamicListTest {

    /**
     * The linc for the instance of DynamicList class.
     */
    private DynamicList<String> dynamicList;

    /**
     * Setups initial date for the tests.
     * @throws Exception if something went wrong.
     */
    @Before
    public void setUp() {
        this.dynamicList = new DynamicList<>();
        this.dynamicList.add("one");
        this.dynamicList.add("two");
        this.dynamicList.add("three");
    }

    /**
     * Tests method add().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenAddElementsThanTheyAreThere() throws Exception {
        this.dynamicList.add("four");
        this.dynamicList.add("fife");
        this.dynamicList.add("six");
        this.dynamicList.add("seven");
        this.dynamicList.add("eight");
        this.dynamicList.add("nine");
        this.dynamicList.add("ten");
        this.dynamicList.add("eleven");
        this.dynamicList.add("twelve");
        this.dynamicList.add("thirteen");

        assertThat(this.dynamicList.get(12), is("thirteen"));
    }

    /**
     * Tests method get().
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGetElementThanItReturns() throws Exception {
        assertThat(this.dynamicList.get(0), is("one"));
    }

    /**
     * Tests method get() in case when ArrayIndexOutOfBoundsException.
     * @throws Exception if something went wrong.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetNonexistentElementThanThrowArrayIndexOutOfBoundsException() throws Exception {
        this.dynamicList.get(5);
    }


    /**
     * Tests an iterator.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenHasNextThanReturnNext() throws Exception {
        Iterator<String> it = this.dynamicList.iterator();
        StringBuilder result = new StringBuilder();
        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }
        assertThat(result.toString(), is("one two three "));
    }
}