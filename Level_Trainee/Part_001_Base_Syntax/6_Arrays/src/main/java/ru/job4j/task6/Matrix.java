package ru.job4j.task6;

/**
 * Matrix.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Matrix {

    /**
     * The method creates multiply table.
     * @param size of table.
     * @return table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
