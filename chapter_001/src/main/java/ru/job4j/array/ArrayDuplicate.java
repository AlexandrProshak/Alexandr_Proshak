package ru.job4j.array;

import java.util.Arrays;

/**
* Removing duplicates of elements of array of String.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class ArrayDuplicate {
	/**
	*@param array input array.
	*@return array of String without duplicates of elements.
	*/
	public String[] remove(String[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i].equals(array[j])) {
                    String tmp = array[j];
                    for (int k = j; k < length - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    array[length - 1] = tmp;
                    length--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, length);
    }
}
