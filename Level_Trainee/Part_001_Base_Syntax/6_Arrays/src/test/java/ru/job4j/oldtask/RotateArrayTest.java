package ru.job4j.oldtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for rotating array task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class RotateArrayTest {
	/**
	* Test for rotating array 2x2.
	*/
    @Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotate = new RotateArray();
		//dimensoin of array
		int m = 2;
        int[][] array = new int[m][m];
		int[][] expectArray = {
			{2, 0},
			{3, 1}
		};
		//fill array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = m * i + j;
            }
        }
		int[][] resultArray = rotate.rotate(array);
		assertThat(resultArray, is(expectArray));
    }
	/**
	* Test for rotating array 3x3.
	*/
    @Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotate = new RotateArray();
		//dimensoin of array
		int m = 3;
        int[][] array = new int[m][m];
		int[][] expectArray = {
			{6, 3, 0},
			{7, 4, 1},
			{8, 5, 2}
		};
		//fill array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = m * i + j;
            }
        }
		int[][] resultArray = rotate.rotate(array);
		assertThat(resultArray, is(expectArray));
    }
}