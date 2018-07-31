package ru.job4j.task2;

/**
 * Turn.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Turn {

    /**
     * The method turn use a loop.
     * @param array to be flipped.
     * @return a flipped array.
     */
    public int[] turn(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    /**
     * The method turn uses a recursion.
     * @param array to be flipped.
     * @param k is an iteration index.
     * @return a flipped array.
     */
    public int[] turnRec(int[] array, int k) {
        if (k < array.length / 2) {
            int tmp = array[k];
            array[k] = array[array.length - k - 1];
            array[array.length - k - 1] = tmp;
            turnRec(array, k + 1);
        }
        return array;
    }
}
