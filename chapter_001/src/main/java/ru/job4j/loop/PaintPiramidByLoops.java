package ru.job4j.loop;

/**
* Paint piramid use only loops.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class PaintPiramidByLoops {
	/**
	* Paint of the piramid by loops.
	* @param h - height.
	* @return returning string of piramid.
	*/
    public String piramid(int h) {
    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= h; i++) {
        for (int j = 1; j <= h - i; j++) {
            result.append(" ");
        }
        for (int k = 1; k <= 2 * i - 1; k++) {
            result.append("^");
        }
        result.append("\n");
    }
    return result.toString();
	}
}