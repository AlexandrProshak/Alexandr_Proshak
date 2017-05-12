package ru.job4j;

/**
* Task for chapter 001 tests.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class TaskForTest {
	/**
	*@param origin original string.
	*@param sub second string.
	*@return turned true if original string equals sub.
	*/
    public boolean contains(String origin, String sub) {
        boolean result = false;
        char[] originalStringArray = origin.toCharArray();
        char[] subStringArray = sub.toCharArray();
        if (origin.length() != sub.length()) {
            result = false;
        } else {
            for (int i = 0; i < origin.length(); i++) {
                if (originalStringArray[i] == subStringArray[i]) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}