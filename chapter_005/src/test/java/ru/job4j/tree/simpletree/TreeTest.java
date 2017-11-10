package ru.job4j.tree.simpletree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the SimpleTree class.
 */
public class TreeTest {

    /**
     * A link to the instance of a working tree.
     */
    private Tree<String> tree;

    /**
     * Preparing initial date.
     */
    @Before
    public void setUp() {
        tree = new Tree<>();
        tree.add("Pavel", "Alexandr");
        tree.add("Alexandr", "Artem");
        tree.add("Pavel", "Irina");
        tree.add("Irina", "Alina");
    }

    /**
     * Testing method add.
     */
    @Test
    public void whenAddCorrectDataThanTheyAllAreInTree() {
        StringBuilder result = new StringBuilder();
        String expectedResult = "AlinaIrinaArtemAlexandrPavel";
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method add when child value is null.
     */
    @Test
    public void whenAddNullChildElementThanItAreNotInTree() {
        tree.add("Alexandr", null);
        StringBuilder result = new StringBuilder();
        String expectedResult = "AlinaIrinaArtemAlexandrPavel";
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method add when parent value is null.
     */
    @Test
    public void whenAddNullParentElementThanItAreNotInTree() {
        tree.add(null, "Maik");
        StringBuilder result = new StringBuilder();
        String expectedResult = "AlinaIrinaArtemAlexandrPavel";
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method add when give a duplicates.
     */
    @Test
    public void whenAddDuplicatesThanTheyAreNotInTree() {
        tree.add("Pavel", "Alexandr");
        tree.add("Alexandr", "Artem");
        tree.add("Pavel", "Irina");
        tree.add("Irina", "Alina");
        StringBuilder result = new StringBuilder();
        String expectedResult = "AlinaIrinaArtemAlexandrPavel";
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            result.append(it.next());
        }
        assertThat(result.toString(), is(expectedResult));
    }

    /**
     * Testing method isBinary.
     */
    @Test
    public void whenTreeIsBinaryThanReturnTrue() {
        assertTrue(tree.isBinary());
    }

    /**
     * Testing method isBinary, in case when root has tree children.
     */
    @Test
    public void whenTreeIsNotBinaryThanReturnFalse() {
        tree.add("Pavel", "Alex");
        assertTrue(!tree.isBinary());
    }

    /**
     * Testing method isBinary, in case when any child has tree kids.
     */
    @Test
    public void whenChildHasTreeKidsThanReturnFalse() {
        tree.add("Alexandr", "Josh");
        tree.add("Alexandr", "Bob");
        assertTrue(!tree.isBinary());
    }
}