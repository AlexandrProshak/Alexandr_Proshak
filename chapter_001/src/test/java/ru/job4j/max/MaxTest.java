package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for max task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class MaxTest {
	/**
	* Test for max task.
	*/
	@Test
	public void whenOneEquelsTwoThenReturnTwo() {
		Max max = new Max();
		int result = max.max(1, 2);
		int expected = 2;
		assertThat(result, is(expected));
	}
}
