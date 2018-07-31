package ru.job4j.task5;

/**
 * BubbleSort.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class BubbleSort {

    /**
     * The method sorts an array by permutation algorithm.
     *
     * @param array to be sorted.
     * @return a sorted array.
     */
    public int[] sort(int[] array) {
        for (int barrier = array.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (array[index] > array[index + 1]) {
                    int tmp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = tmp;
                }
            }
        }
        return array;
    }
}
