package ru.job4j.task4;

/**
 * ArrayChar.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ArrayChar {

    /**
     * The private field stores char array from the given string line.
     */
    private char[] data;

    /**
     * The constructor.
     * @param line parameter.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * The method startWith checks given in a constructor line begins it from a prefix or not.
     * @param prefix for check.
     * @return true if start, false if not.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        int length = 0;
        length = data.length >= value.length ? value.length : data.length;
        if (length == 0) {
            result = false;
        }
        for (int i = 0; i < length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
