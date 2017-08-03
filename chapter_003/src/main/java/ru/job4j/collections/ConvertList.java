package ru.job4j.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class ConvertList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList {

    /**
     * This method is converting a two dimensions array into List.
     * @param array with has to be converted.
     * @return a List of result.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * A method is converting a list into an array.
     * @param list to convert.
     * @param rows dimension of a result array.
     * @return an array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();

        float temp = (float) list.size() / rows;
        int columns = (int) temp;

        if (temp > columns) {
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
