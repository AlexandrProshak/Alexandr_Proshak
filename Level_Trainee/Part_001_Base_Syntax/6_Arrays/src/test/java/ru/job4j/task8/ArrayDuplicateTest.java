package ru.job4j.task8;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ArrayDuplicateTest {

    /**
     * Test.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Привет", "Привет", "Мир", "Привет", "Супер", "Мир", "Супер", "Мир"};
        String[] resultArray = arrayDuplicate.remove(array);
        String[] expectArray = {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * Test.
     */
    @Test
    public void whenEmptyArrayThenEmptyArray() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {""};
        String[] resultArray = arrayDuplicate.remove(array);
        String[] expectArray = {""};
        assertThat(resultArray, is(expectArray));
    }
}