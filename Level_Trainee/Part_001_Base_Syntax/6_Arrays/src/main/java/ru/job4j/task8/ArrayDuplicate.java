package ru.job4j.task8;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ArrayDuplicate {

    /**
     * The method removes duplicates in an array.
     *
     * @param array to be processed.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int length = array.length;
        for (int element = 0; element < length; element++) {
            for (int comparable = element + 1; comparable < length; comparable++) {
                if (array[element].equals(array[comparable])) {
                    String tmp = array[comparable];
                    System.arraycopy(array, comparable + 1, array, comparable, length - comparable - 1);
                    array[length - 1] = tmp;
                    length--;
                    comparable--;
                }
            }
        }
        return Arrays.copyOf(array, length);
    }
}