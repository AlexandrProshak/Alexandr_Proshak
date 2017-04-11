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
		int maximum = 0;
		maximum = first > second ? first : second;
		return maximum;
	}
	/**
	* Maximum of three numbers.
	* @param first - first number.
	* @param second - second number.
	* @param third - third number.
	* @return returning max value.
	*/
	public int max(int first, int second, int third) {
		int maximum = 0;
		maximum = max(first, max(second, third));
		return maximum;
	}
}