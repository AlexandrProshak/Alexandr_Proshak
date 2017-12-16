package ru.job4j.simpleequals;

import java.util.Arrays;

/**
 * The class SimpleWordMatcher.
 */
public class SimpleWordMatcher {

    /**
     * A method is matching two sets of character. A case sensitive version.
     * @param first word.
     * @param second word.
     * @return result of matching two sets of character.
     */
    public boolean match(String first, String second) {
        boolean result;
        char[] a = toSortedArray(first);
        char[] b = toSortedArray(second);

        if (Arrays.hashCode(a) != Arrays.hashCode(b)) {
            result = false;
        } else {
            result = Arrays.equals(a, b);
        }

        return result;
    }

    /**
     * A method is matching two sets of character. An ignore case sensitive version.
     * @param first word.
     * @param second word.
     * @return result of matching two sets of character.
     */
    public boolean matchIgnoreCase(String first, String second) {
        String resultA = new String(toSortedArray(first));
        String resultB = new String(toSortedArray(second));

        return (resultA.equalsIgnoreCase(resultB));
    }

    /**
     * A method makes sorted character array from a given string.
     * @param string to be processed.
     * @return a sorted character array.
     */
    private char[] toSortedArray(String string) {
        char[] array = string.toCharArray();
        Arrays.sort(array);
        return array;
    }
}
