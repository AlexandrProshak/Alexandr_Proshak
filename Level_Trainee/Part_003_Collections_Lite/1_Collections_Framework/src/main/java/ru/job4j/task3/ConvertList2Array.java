package ru.job4j.task3;

import java.util.Iterator;
import java.util.List;

/**
 * ConvertList2Array.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertList2Array {

    /**
     * A method converts a list into an array.
     * @param list to convert.
     * @param rows dimension of a result array.
     * @return an array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();
        int columns = list.size() / rows;
        if (list.size() % rows != 0) {
            columns++;
        }
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (iterator.hasNext()) {
                    result[i][j] = iterator.next();
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}
