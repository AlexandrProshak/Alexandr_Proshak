package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for sort array task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class BubbleSortTest {
	/**
	* Test for sort array by bubble sort algorithm.
	*/
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] array = {2, 6, 1, 4, 0, 7, 8, 3, 5, 9};
        int[] resultArray = sort.sort(array);
        int[] expectArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(resultArray, is(expectArray));
    }
}