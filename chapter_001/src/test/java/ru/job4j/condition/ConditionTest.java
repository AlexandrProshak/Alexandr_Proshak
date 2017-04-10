package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for condition task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class ConditionTest {
	/**
	* Test for condition task.
	*/
	@Test
	public void whenPointIsOnFunctionThenReturnTrue() {
		Point point = new Point(1, 2);
		boolean result = point.is(1, 1);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}
