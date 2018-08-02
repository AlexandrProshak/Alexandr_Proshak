package ru.job4j.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertList {

    /**
     * The method converts list of arrays to the one list.
     * @param list of arrays to be converted.
     * @return result.
     */
    public List<Integer> convert(List<int[]> list) {
        int length = 0;
        for (int[] each : list) {
            length += each.length;
        }
        List<Integer> result = new ArrayList<>(length);
        for (int[] each : list) {
            for (int elem : each) {
                result.add(elem);
            }
        }
        return result;
    }
}
