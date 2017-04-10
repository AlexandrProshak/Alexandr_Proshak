package ru.job4j.max;

/**
* Max.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Max {
	/**
	* Maximum of two numbers.
	* @param first - first param.
	* @param second - second param.
	* @return returning max value.
	*/
	public int max(int first, int second) {
		int max = 0;
		max = first > second ? first : second;
		return max;
	}
}