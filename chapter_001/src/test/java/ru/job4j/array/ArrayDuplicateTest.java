package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for remuving dublicates from array.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class ArrayDuplicateTest {
	/**
	* Test for even amount of elements of array.
	*/
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] resultArray = arrayDuplicate.remove(array);
        String[] expectArray =  {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }
}