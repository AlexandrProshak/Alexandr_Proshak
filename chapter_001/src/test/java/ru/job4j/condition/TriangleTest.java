package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
* Tests for Triangle's area .
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class TriangleTest {
	/**
	* Test checkExisting method when triangle exist.
	*/
	@Test
	public void whenTriangleExistThenReturnTrue() {
		Triangle tr = new Triangle(new Point(1, 1), new Point(2, 6), new Point(6, 1));
		boolean result = tr.checkExisting();
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	* Test checkExisting method when triangle is not exist.
	*/
	@Test
	public void whenTwoPointAreTheSameThenReturnFalse() {
		Triangle tr = new Triangle(new Point(1, 1), new Point(1, 1), new Point(6, 1));
		boolean result = tr.checkExisting();
		boolean expected = false;
		assertThat(result, is(expected));
	}
	/**
	* Test calculatingLength method.
	*/
	@Test
	public void whenLengthOneThenReturnOne() {
		Triangle tr = new Triangle(new Point(1, 1), new Point(2, 1), new Point(0, 0));
		double result = tr.calculatingLength(new Point(1, 1), new Point(1, 2));
		double expected = 1.0;
		assertThat(result, is(expected));
	}
	/**
	* Test area method.
	*/
	@Test
	public void whenAreaEqualsOneThenReturnOne() {
		Triangle tr = new Triangle(new Point(2, 2), new Point(1, 0), new Point(0, 0));
		double result = tr.area();
		double expected = 1.0;
		assertThat(result, closeTo(expected, 1.0));
	}
}