package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for turning array task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class TurnTest {
	/**
	* Test for even amount of elements of array.
	*/
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] arr = {2, 6, 1, 4};
        int[] resultArray = turn.back(arr);
        int[] expectArray = {4, 1, 6, 2};
        assertThat(resultArray, is(expectArray));
    }
    /**
	* Test for odd amount of elements of array.
	*/
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] arr = {1, 2, 3, 4, 5};
        int[] resultArray = turn.back(arr);
        int[] expectArray = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }
}