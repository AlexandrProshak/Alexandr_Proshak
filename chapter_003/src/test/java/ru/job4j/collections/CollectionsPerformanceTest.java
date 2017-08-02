package ru.job4j.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class CollectionsPerformanceTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class CollectionsPerformanceTest {

    /**
     * A link for instance of a CollectionsPerformance class.
     */
    private CollectionsPerformance collectionsPerformance;

    /**
     * String line for tests.
     */
    private String line = " line for tests";

    /**
     * An amount of the iterations.
     */
    private static final int AMOUNT = 50000;

    /**
     * Set up an initial date.
     */
    @Before
    public void setUp() {
        this.collectionsPerformance = new CollectionsPerformance();
    }
    /**
     * A test for calculating adding and deleting time for LinkedList.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenAddAndDeleteToAndFromLinkedListThenPrintTime() throws Exception {
        Collection<String> linkedList = new LinkedList<>();
        System.out.println("Time for add into LinkedList    - " + collectionsPerformance.add(linkedList, AMOUNT));
        Collection<String> list = new LinkedList<>();
        for (int i = 0; i < AMOUNT + 10; i++) {
            list.add(line);
        }
        System.out.println("Time for delete from LinkedList - " + collectionsPerformance.delete(list, AMOUNT));
        System.out.println("*****");
    }

    /**
     * A test for calculating adding and deleting time for ArrayList.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenAddAndDeleteToAndFromArrayListThenPrintTime() throws Exception {
        Collection<String> arrayList = new ArrayList<>();
        System.out.println("Time for add into ArrayList     - " + collectionsPerformance.add(arrayList, AMOUNT));
        Collection<String> list = new ArrayList<>();
        for (int i = 0; i < AMOUNT + 10; i++) {
            list.add(line);
        }
        System.out.println("Time for delete from ArrayList  - " + collectionsPerformance.delete(list, AMOUNT));
        System.out.println("*****");
    }

    /**
     * A test for calculating adding and deleting time for TreSet.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenAddAndDeleteToAndFromTreeSetThenPrintTime() throws Exception {
        Collection<String> treeSet = new TreeSet<>();
        System.out.println("Time for add into TreeSet     - " + collectionsPerformance.add(treeSet, AMOUNT));
        Collection<String> list = new TreeSet<>();
        for (int i = 0; i < AMOUNT + 10; i++) {
            list.add(line + i);
        }
        System.out.println("Time for delete from TreeSet  - " + collectionsPerformance.delete(list, AMOUNT));
        System.out.println("*****");
    }
}