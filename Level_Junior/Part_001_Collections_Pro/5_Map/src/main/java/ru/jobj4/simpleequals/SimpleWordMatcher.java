package ru.jobj4.simpleequals;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * The class SimpleWordMatcher.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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

    /**
     * A method is matching two strings use hashMap. A case sensitive version.
     * @param first word.
     * @param second word.
     * @return result of matching two sets of character.
     */
    public boolean hasMapWordMatcher(String first, String second) {
        char[] a = toSortedArray(first);
        char[] b = toSortedArray(second);

        String firstKey = new String(a);
        String secondKey = new String(b);

        Map<String, String> map = new HashMap<>();

        map.put(firstKey, first);
        map.put(secondKey, second);

        return map.size() == 1 ? true : false;
    }

    /**
     * A method is matching two strings use hashSet. A case sensitive version.
     * @param first word.
     * @param second word.
     * @return result of matching two sets of character.
     */
    public boolean hasSetWordMatcher(String first, String second) {
        char[] a = toSortedArray(first);
        char[] b = toSortedArray(second);

        String firstSequence = new String(a);
        String secondSequence = new String(b);

        Set<String> set = new HashSet<>();

        set.add(firstSequence);
        set.add(secondSequence);

        return set.size() == 1 ? true : false;
    }
}
