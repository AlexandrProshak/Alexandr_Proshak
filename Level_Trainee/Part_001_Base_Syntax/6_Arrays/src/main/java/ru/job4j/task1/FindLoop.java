package ru.job4j.task1;

/**
 * FindLoop.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class FindLoop {

    /**
     * The method indexOf.
     * @param data an array.
     * @param e1 element.
     * @return index of element, if there isn't it - return -1.
     */
    public int indexOf(int[] data, int e1) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
