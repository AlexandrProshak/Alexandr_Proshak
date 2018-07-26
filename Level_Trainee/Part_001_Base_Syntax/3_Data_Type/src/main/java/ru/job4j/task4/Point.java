package ru.job4j.task4;

/**
 * Point. The class describes a point in two dimensional .
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Point {

    /**
     * The coordinate x.
     */
    private int x;

    /**
     * The coordinate y.
     */
    private int y;

    /**
     * The constructor.
     * @param x coordinate.
     * @param y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The method calculate distance between two points.
     * @param that destination point.
     * @return distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
}
