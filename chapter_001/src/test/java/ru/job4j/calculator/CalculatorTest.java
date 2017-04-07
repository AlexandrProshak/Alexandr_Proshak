package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for calculator task.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class CalculatorTest {
	/**
	* Test for method add.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	* Test for method subtruct.
	*/
	public void whenTwoMinusOneThenOne() {
		Calculator calc = new Calculator();
		calc.subtract(2D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
	/**
	* Test for method div.
	*/
	public void whenTwoDivideTwoThenOne() {
		Calculator calc = new Calculator();
		calc.div(2D, 2D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
	/**
	* Test for method multiply.
	*/
	public void whenTwoMultiplyTwoThenFour() {
		Calculator calc = new Calculator();
		calc.div(2D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
}
