package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

/**
 * SimpleHashSetTest class.
 */
public class SimpleHashSetTest {

    /**
     * Link to the instance of SimpleSetArray class.
     */
    private SimpleSetArray<String> setArray;

    /**
     * Link to the instance of SimpleSetLinkedList class.
     */
    private SimpleSetLinkedList<String> setList;

    /**
     * Link to the instance of SimpleHashSet class.
     */
    private SimpleHashSet<String> setHash;

    /**
     * Link to the array of initial data.
     */
    private String[] data;

    /**
     * Times of iteration of lop.
     */
    private int times;

    /**
     * Prepared initial data.
     */
    @Before
    public void setUp() {
        setArray = new SimpleSetArray();
        setList = new SimpleSetLinkedList<>();
        setHash = new SimpleHashSet<>();
        times = 1000;
        data = new String[]{
                "first element", "first element",
                "nt", "first element", "second element",
                "second element", "second element", "second element", "second element",
                "third element", "third element", "third element", "third element",
                "one", "one", "one", "two", "two", "two", "two", "two",
                "three", "three", "three", "three", "three", "aaa", "bbb", "bbb",
                "third element", "third element", "third element", "third element",
                "one", "one", "one", "two", "two", "two", "two", "two",
                "three", "three", "three", "three", "three", "aaa", "bbb", "bbb",
                "first element", "first element", "first element", "second element",
                "second element", "second element", "second element", "second element",
                "third element", "third element", "third element", "third element",
                "one", "one", "one", "two", "two", "two", "two", "two",
                "second element", "second element", "second element", "second element",
                "third element", "third element", "third element", "third element",
                "one", "one", "one", "two", "two", "two", "two", "two",
                "three", "three", "three", "three", "three", "aaa", "bbb", "bbb",
                "third element", "third element", "third element", "third element",
                "one", "one", "one", "two", "two", "two", "two", "two",
                "three", "three", "three", "three", "three", "aaa", "bbb", "bbb",
                "bbb", "bbb", "bbb", "ddd"};
    }

    /**
     * Tests speed of adds element to the SimpleSetArray.
     */
    @Test
    public void whenAddUniqueElementToSimpleSetArrayReturnDifferenceInMs() {
        long start = System.currentTimeMillis();
        long finish;
        long result = 0L;

        while (times-- >= 0) {
            for (int i = 0; i < data.length; i++) {
                setArray.add(data[i]);
            }
            finish = System.currentTimeMillis();
            result = result + (finish - start);
        }
        System.out.println("SimpleSetArray - " + result);
    }


    /**
     * Tests speed of adds element to the SimpleSetLinkedList.
     */
    @Test
    public void whenAddUniqueElementToSimpleSetLinkedListReturnDifferenceInMs() {
        long start = System.currentTimeMillis();
        long finish;
        long result = 0L;

        while (times-- >= 0) {
            for (int i = 0; i < data.length; i++) {
                setList.add(data[i]);
            }
            finish = System.currentTimeMillis();
            result = result + (finish - start);
        }
        System.out.println("SimpleSetLinkedList - " + result);
    }

    /**
     * Tests speed of adds element to the SimpleHashSet.
     */
    @Test
    public void whenAddUniqueElementToSimpleHashSetReturnDifferenceInMs() {
        long start = System.currentTimeMillis();
        long finish;
        long result = 0L;

        while (times-- >= 0) {
            for (int i = 0; i < data.length; i++) {
                setHash.add(data[i]);
            }
            finish = System.currentTimeMillis();
            result = result + (finish - start);
        }
        System.out.println("SimpleHashSet - " + result);
    }
}


