package ru.job4j.checking;

/**
* Task for chapter 001 tests.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class CheckingTask {
	/**
	*@param origin original string.
	*@param sub second string.
	*@return turned true if original string equals sub.
	*/
    public boolean contains(String origin, String sub) {
        boolean result = false;
        if (sub.length() > origin.length()) {
            result = false;
        } else {
            char[] origArray = origin.toCharArray();
            char[] subArray = sub.toCharArray();
            for (int i = 0; i <= (origArray.length - subArray.length); i++) {
                for (int j = 0; j < subArray.length; j++) {
                    if (origArray[i + j] != subArray[j]) {
					break;
					}
                    if (j == subArray.length - 1) {
					result = true;
					}
                }
            }
        }
        return result;
    }
}