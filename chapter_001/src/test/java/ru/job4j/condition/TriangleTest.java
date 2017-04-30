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
		Point a = new Point(1, 1);
		Point b = new Point(2, 6);
		Point c = new Point(6, 1);
		Triangle tr = new Triangle(a, b, c);
		double aB = tr.calculatingLength(a, b);
        double bC = tr.calculatingLength(b, c);
        double cA = tr.calculatingLength(c, a);
		boolean result = tr.checkExisting(aB, bC, cA);
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	* Test checkExisting method when triangle is not exist.
	*/
	@Test
	public void whenTwoPointAreTheSameThenReturnFalse() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 1);
		Point c = new Point(6, 1);
		Triangle tr = new Triangle(a, b, c);
		double aB = tr.calculatingLength(a, b);
        double bC = tr.calculatingLength(b, c);
        double cA = tr.calculatingLength(c, a);
        boolean result = tr.checkExisting(aB, bC, cA);
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
