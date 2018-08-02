package ru.job4j.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertMatrix2List {

    /**
     * The method convert two dimensional array to the ArrayList.
     * @param array to be converted.
     * @return a list.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] elements : array) {
            for (int elem : elements) {
                result.add(elem);
            }
        }
        return result;
    }
}
