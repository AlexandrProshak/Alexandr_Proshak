package ru.job4j.chess.board;

/**
 * Class Cell.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Cell {
    /**
     * a coordinate of a horizontal position.
     */
    private int x;

    /**
     * a coordinate of a vertical position.
     */
    private int y;

    /**
     * A constructor for a current cell.
     * @param x is a current coordinate of a horizontal position.
     * @param y is a current coordinate of a vertical position.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A getter for x.
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * A getter for y.
     * @return y.
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
