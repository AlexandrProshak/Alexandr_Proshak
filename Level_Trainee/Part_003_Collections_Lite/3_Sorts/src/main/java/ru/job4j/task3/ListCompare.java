package ru.job4j.task3;

import java.util.Comparator;

/**
 * ListCompare.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int leftLength = left.length();
        int rightLength = right.length();
        int len;
        if (leftLength > rightLength) {
            len = rightLength;
        } else {
            len = leftLength;
        }
        int compare;
        for (int i = 0; i < len; i++) {
            compare = Character.compare(leftChar[i], rightChar[i]);
            if (compare != 0) {
                return compare;
            }
        }
        if (leftLength == rightLength) {
            return 0;
        }
        return leftLength > rightLength ? 1 : -1;
    }
}
