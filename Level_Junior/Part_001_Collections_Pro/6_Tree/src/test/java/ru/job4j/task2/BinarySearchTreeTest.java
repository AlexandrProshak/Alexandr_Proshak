package ru.job4j.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for the BinarySearchTree class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class BinarySearchTreeTest {

    /**
     * A link to the instance of a working tree.
     */
    private BinarySearchTree<Integer> tree;

    /**
     * Preparing initial date.
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
        tree.add(50);
        tree.add(34);
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(120);
        tree.add(15);
        tree.add(34);
        tree.add(6);
    }

    /**
     * Testing method add.
     */
    @Test
    public void whenAddElementsThanTheyAreInTree() {
        StringBuilder result = new StringBuilder();
        String expectedResult = "1 2 6 8 15 34 34 50 120 ";
        Iterator<Integer> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next() + " ");
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method add in case add duplicates.
     */
    @Test
    public void whenAddDuplicatesThanTheyAreInTree() {
        tree.add(1);
        tree.add(1);
        tree.add(2);
        tree.add(120);
        tree.add(8);
        StringBuilder result = new StringBuilder();
        String expectedResult = "1 1 1 2 2 6 8 8 15 34 34 50 120 120 ";
        Iterator<Integer> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next() + " ");
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method add with String parameter.
     */
    @Test
    public void whenAddStringThanTheyAreInTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        StringBuilder result = new StringBuilder();
        String expectedResult = "A A B C D E F F G G ";
        tree.add("E");
        tree.add("A");
        tree.add("C");
        tree.add("A");
        tree.add("D");
        tree.add("B");
        tree.add("G");
        tree.add("G");
        tree.add("F");
        tree.add("F");
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next() + " ");
        }
        assertThat(result.toString(), is(expectedResult));
    }
}