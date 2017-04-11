package ru.job4j.condition;

import static java.lang.Math.sqrt;

/**
 * Triangle.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    /**
     * Vertex of triangle.
     */
    private Point a;
    /**
     * Vertex of triangle.
     */
    private Point b;
    /**
     * Vertex of triangle.
     */
    private Point c;
    /**
     * Constructor of the class Triangle.
     * @param a set vertex.
     * @param b set vertex.
     * @param c set vertex.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Calculating area of the triangle using the Heron's formula.
     * @return area of a triangle.
     */
    public double area() {
        //calculate the triangle area
        double s;
        if (checkExisting()) {
            double aB = calculatingLength(this.a, this.b);
            double bC = calculatingLength(this.b, this.c);
            double cA = calculatingLength(this.c, this.a);
            double halfPerimetr = (aB + bC + cA) / 2;
            s = sqrt(halfPerimetr * (halfPerimetr - aB) * (halfPerimetr - bC) * (halfPerimetr - cA));
        } else {
            s = -1.0;
        }
        return s;
    }
    /**
     * Checking of existing triangle.
     * @return true if triangle exist or false if doesn't exist.
     */
    public boolean checkExisting() {
        double aB = calculatingLength(this.a, this.b);
        double bC = calculatingLength(this.b, this.c);
        double cA = calculatingLength(this.c, this.a);
        boolean result = false;
        if ((this.a.equals(this.b) || (this.b.equals(this.c) || (this.a.equals(this.c))))) {
            result = false;
        } else if ((aB + bC) > cA & (bC + cA) > aB & (aB + cA) > bC) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Calculating distance between two points.
	 * @param a - starting point of line.
	 * @param b - ending point of line.
     * @return length of the segment.
     */
    public double calculatingLength(Point a, Point b) {
        return sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }
}