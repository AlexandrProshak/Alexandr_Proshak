package ru.job4j.task3;

/**
 * Check.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Check {

    /**
     * The method mono.
     * @param data an array to be checked.
     * @return true if all elements are similar.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        if (data.length == 0) {
            return true;
        }
        boolean index = data[0];
        for (int i = 1; i < data.length; i++) {
            if (index != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
