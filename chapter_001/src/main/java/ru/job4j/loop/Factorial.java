package ru.job4j.loop;

/**
* Max.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Factorial {
	/**
	* Calculete factorial.
	* @param n number for calculete.
	* @return returning factorial.
	*/
	public int calc(int n) {
		int factorial = 1;
		if (n == 0) {
			factorial = 1;
		} else {
			for (int i = n; i > 0; i--) {
				factorial = factorial * i;
			}
		}
		return factorial;
	}
}