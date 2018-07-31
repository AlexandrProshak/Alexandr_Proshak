package ru.job4j.oldtask;

/**
* Merging two sorted arrays into one.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class MergeArraysSort {
	/**
	*@param firstArray first input array.
	*@param secondArray second input array.
	*@return merged array.
	*/
	public int[] sortedMerge(int[] firstArray, int[] secondArray) {
		int firstArraySize = firstArray.length;
        int secondArraySize = secondArray.length;
        //creating the resulting array
        int[] result = new int[firstArraySize + secondArraySize];
        //index for iteration by the first array
        int i = 0;
        //index for iteration by the second array
        int j = 0;
        //index for iteration by the resulting array
        int k = 0;
        //compare elements of arrays until one of them will be ended
        //if they have different length
        while (i < firstArraySize && j < secondArraySize) {
        	if (firstArray[i] < secondArray[j]) {
        		result[k] = firstArray[i];
        		i++;
        	} else {
        		result[k] = secondArray[j];
        		j++;
        	}
        	k++;
        }
		//if the first array was bigger than the second
		//append the remained elements of it to resulting array
        while (i < firstArraySize) {
        	result[k] = firstArray[i];
        	i++;
        	k++;
        }
        //if the second array was bigger than the first
		//append the remained elements of it to resulting array
        while (j < secondArraySize) {
        	result[k] = secondArray[j];
        	j++;
        	k++;
        }
    	return result;
    }
}