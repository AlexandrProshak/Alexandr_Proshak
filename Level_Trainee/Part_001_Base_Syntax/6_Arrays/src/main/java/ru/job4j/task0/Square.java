package ru.job4j.task0;

/**
 * Square.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Square {

    /**
     * The method calculate.
     * @param bound array's size.
     * @return the array with degrees of numbers.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}
