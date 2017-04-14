package ru.job4j.loop;

/**
* Paint.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Paint {
	/**
	* Paint of the piramid.
	* @param h - height.
	* @return returning string of piramid.
	*/
    public String piramid(int h) {
        int width = 2 * h - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= width; j++) {
               if (j <= h - i || (j >= h + i)) {
                result.append(" ");
                } else {
                result.append("^");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}