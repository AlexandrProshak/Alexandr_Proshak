package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for merging two sorted arrays to one task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class MergeArraysSortTest {
	/**
	* Test for merging sort algorithm
    * when both arrays have similar length.
	*/
    @Test
    public void whenMergeTwoSortedArraysThenReturnArrayContainBoth() {
        MergeArraysSort mergedArray = new MergeArraysSort();
        int[] firstArray = {1, 3, 4};
        int[] secondArray = {2, 5, 7};
        int[] resultArray = mergedArray.sortedMerge(firstArray, secondArray);
        int[] expectArray = {1, 2, 3, 4, 5, 7};
        assertThat(resultArray, is(expectArray));
    }
    /**
    * Test for merging sort algorithm
    * when the first array is bigger than the second one.
    */
    @Test
    public void whenMergeTwoSortedArraysWherFirstIsBigerThenReturnArrayContainBoth() {
        MergeArraysSort mergedArray = new MergeArraysSort();
        int[] firstArray = {1, 3, 4, 6, 10};
        int[] secondArray = {2, 5, 7};
        int[] resultArray = mergedArray.sortedMerge(firstArray, secondArray);
        int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 10};
        assertThat(resultArray, is(expectArray));
    }
    /**
    * Test for merging sort algorithm
    * when the second array is bigger than the first one.
    */
    @Test
    public void whenMergeTwoSortedArraysWherSecondIsBigerThenReturnArrayContainBoth() {
        MergeArraysSort mergedArray = new MergeArraysSort();
        int[] firstArray = {1, 3, 4};
        int[] secondArray = {2, 5, 6, 7, 10};
        int[] resultArray = mergedArray.sortedMerge(firstArray, secondArray);
        int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 10};
        assertThat(resultArray, is(expectArray));
    }
}