package ru.job4j.array;

/**
* Turn array.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Turn {
	/**
	*@param array input array.
	*@return turned array.
	*/
	public int[] back(int[] array) {
        int tmp;
        int index = array.length - 1;
        int indexForLoop;

        if (index % 2 == 0) {
            indexForLoop = index / 2;
        } else {
            indexForLoop = index / 2 + 1;
        }
        for (int i = 0; i < indexForLoop; i++) {
            tmp = array[i];
            array[i] = array[index - i];
            array[index - i] = tmp;
        }
    	return array;
    }
}
