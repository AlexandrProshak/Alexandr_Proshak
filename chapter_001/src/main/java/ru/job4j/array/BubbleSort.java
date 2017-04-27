package ru.job4j.array;

/**
* Sort array by bubble.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class BubbleSort {
	/**
	*@param array input array.
	*@return sorted array.
	*/
	public int[] sort(int[] array) {
        int tmp;
        int size = array.length;
        //external loop
        for (int i = 0; i < size; i++) {
			//internal loop; iterate of array is from back to i and
			//smaller elements are coming to begin of the array
			for (int j = size - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
				tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
				}
			}
		}
    	return array;
    }
}
