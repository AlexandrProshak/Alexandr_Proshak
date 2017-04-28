package ru.job4j.array;

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
		int[][] expectArray = new int[m][m];
		//fill array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = m * i + j;
            }
        }
		//fill expected array
		expectArray[0][0] = 2;
		expectArray[0][1] = 0;
		expectArray[1][0] = 3;
		expectArray[1][1] = 1;
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
		int[][] expectArray = new int[m][m];
		//fill array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = m * i + j;
            }
        }
		//fill expected array
		expectArray[0][0] = 6;
		expectArray[0][1] = 3;
		expectArray[0][2] = 0;
		expectArray[1][0] = 7;
		expectArray[1][1] = 4;
		expectArray[1][2] = 1;
		expectArray[2][0] = 8;
		expectArray[2][1] = 5;
		expectArray[2][2] = 2;
		int[][] resultArray = rotate.rotate(array);
		assertThat(resultArray, is(expectArray));
    }
}