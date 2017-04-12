package ru.job4j.loop;

/**
* Max.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Counter {
	/**
	* Sum even numbers of loop.
	* @param start - begin of range.
	* @param finish - end of range.
	* @return returning sum.
	*/
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			} else {
				sum = sum + i;
			}
		}
		return sum;
	}
}