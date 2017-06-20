package ru.job4j.chess.board;

import ru.job4j.chess.figures.Figure;

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
     * a figure with cell has, if cell has not a figure - false.
     */
    private boolean occupiedByFigure = false;

    /**
     * A constructor for a current cell.
     * @param x is a current coordinate of a horizontal position.
     * @param y is a current coordinate of a vertical position.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setOccupiedByFigure(boolean occupiedByFigure) {
        this.occupiedByFigure = occupiedByFigure;
    }

    public boolean getOccupiedByFigure() {
        return occupiedByFigure;
    }
}
