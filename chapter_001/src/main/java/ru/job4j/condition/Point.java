package ru.job4j.condition;

/**
* Class Point.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Point {
	/**
	* coordinate x.
	*/
	private int x;
	/**
	* coordinate y.
	*/
	private int y;
	/**
	* Constructor of the class Point.
	* @param x set x.
	* @param y set y.
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	* getX.
	* @return returning X.
	*/
	public int getX() {
		return this.x;
	}
	/**
	* getY.
	* @return returning Y.
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Checking of the existing point on the function.
	* @param a first parametr.
	* @param b second parametr.
	* @return returning condition.
	*/
    public boolean is(int a, int b) {
        return getY() == (a * getX() + b) ? true : false;
    }
}
