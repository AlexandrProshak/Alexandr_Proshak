package ru.job4j.set;

import org.junit.Test;
import ru.job4j.list.LinkedContainer;
import ru.job4j.list.SimpleContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * UniqueTest class.
 */
public class UniqueTest {

    /**
     * Tests method addUniqueElement() in case if the element is unique.
     */
    @Test
    public void whenAddUniqueElementThanReturnTrue() {
        SimpleContainer<String> list = new LinkedContainer<>();

        Unique<String> unique = new Unique<>();
        list.add("1");
        list.add("2");
        list.add("3");

        assertTrue(unique.addUniqueElement(list.iterator(), list, "4"));
    }

    /**
     * Tests method addUniqueElement() in case if the element is unique.
     */
    @Test
    public void whenAddUniqueElementThanItIsInContainer() {
        SimpleContainer<String> list = new LinkedContainer<>();
        List<String> result = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");

        Unique<String> unique = new Unique<>();
        list.add("1");
        list.add("2");
        list.add("3");

        unique.addUniqueElement(list.iterator(), list, "4");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }

        assertTrue(result.containsAll(expected));
    }
    /**
     * Tests method addUniqueElement() in case if the element is not unique.
     */
    @Test
    public void whenAddNoneUniqueElementThanReturnFalse() {
        SimpleContainer<String> list = new LinkedContainer<>();

        Unique<String> unique = new Unique<>();
        list.add("1");
        list.add("2");

        assertFalse(unique.addUniqueElement(list.iterator(), list, "1"));
    }
}