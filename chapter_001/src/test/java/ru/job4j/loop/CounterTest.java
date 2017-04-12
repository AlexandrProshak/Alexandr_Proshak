package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for loop task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class CounterTest {
	/**
	* Test for sum even numbers of range.
	*/
	@Test
	public void whenStartZeroFinishTenThenReturnThiry() {
		Counter counter = new Counter();
		int result = counter.add(0, 10);
		int expected = 30;
		assertThat(result, is(expected));
	}
}
