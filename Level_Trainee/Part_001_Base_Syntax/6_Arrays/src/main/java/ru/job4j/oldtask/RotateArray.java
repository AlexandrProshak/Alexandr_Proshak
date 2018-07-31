package ru.job4j.oldtask;

/**
* Rotate two-dimensional array clockwise.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class RotateArray {
	/**
	*@param array input array.
	*@return clockwised rotated array.
	*/
	public int[][] rotate(int[][] array) {
		int tmp;
        int index = array.length;
        for (int k = 0; k < index / 2; k++) {
            for (int j = k; j < index - 1 - k; j++) {
                tmp = array[k][j];
                array[k][j] = array[index - 1 - j][k];
                array[index - 1 - j][k] = array[index - 1 - k][index - 1 - j];
                array[index - 1 - k][index - 1 - j] = array[j][index - 1 - k];
                array[j][index - 1 - k] = tmp;
            }
        }
    	return array;
    }
}
