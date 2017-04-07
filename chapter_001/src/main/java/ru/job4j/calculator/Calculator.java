package ru.job4j.calculator;

/**
* Calculator.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Calculator {
	/**
	*@param - result of operatin.
	*/
	private double result;
	/**
	* Add.
	* @param first - first parametr.
	* @param second - second parametr.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	* Subtruct.
	* @param first - first parametr.
	* @param second - second parametr.
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	/**
	* Div.
	* @param first - first parametr.
	* @param second - second parametr.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	* Multiply.
	* @param first - first parametr.
	* @param second - second parametr.
	*/
	public void multiply(double first, double second) {
		this.result = first * second;
	}
	/**
	* getResult.
	* @return - result of operatin.
	*/
	public double getResult() {
		return this.result;
	}
}