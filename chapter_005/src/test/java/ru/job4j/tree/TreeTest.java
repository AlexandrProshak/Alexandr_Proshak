package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for the SimpleTree class.
 */
public class TreeTest {

    /**
     * Tests method add.
     */
    @Test
    public void whenAddElementsToTreeThanTheyAreThere() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5, 3);
        tree.add(5, 7);
        tree.add(7, 6);
        tree.add(7, 8);
        tree.add(8, 9);
        tree.add(9, 12);
        tree.add(3, 4);
        tree.add(3, 2);
        tree.add(2, 2);

        StringBuilder result = new StringBuilder();
        String expectedResult = "235789";
        Iterator it = tree.iterator();

        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(expectedResult, is(result.toString()));
    }

    /**
     * Tests method add in case when add similar elements.
     */
    @Test
    public void whenAddSimilarElementsToTreeThanTheyAreNotAllThere() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5, 3);
        tree.add(5, 3);
        tree.add(5, 3);

        StringBuilder result = new StringBuilder();
        String expectedResult = "5";
        Iterator it = tree.iterator();

        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(expectedResult, is(result.toString()));
    }

    /**
     * Tests method add in case when add null parent.
     */
    @Test
    public void whenAddNullParentToTreeThanTheyAreNot() {
        Tree<Integer> tree = new Tree<>();
        tree.add(null, 3);
        tree.add(null, 2);


        StringBuilder result = new StringBuilder();
        String expectedResult = "";
        Iterator it = tree.iterator();

        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(expectedResult, is(result.toString()));
    }

    /**
     * Tests method add in case when add null child.
     */
    @Test
    public void whenAddNullChildToTreeThanTheyAreNot() {
        Tree<Integer> tree = new Tree<>();
        tree.add(3, null);
        tree.add(1, null);


        StringBuilder result = new StringBuilder();
        String expectedResult = "";
        Iterator it = tree.iterator();

        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(expectedResult, is(result.toString()));
    }
}