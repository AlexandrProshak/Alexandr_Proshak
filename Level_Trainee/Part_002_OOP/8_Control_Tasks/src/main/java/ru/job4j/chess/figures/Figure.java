package ru.job4j.chess.figures;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;

/**
 * Class Figure.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public abstract class Figure {

    /**
     * a cell of figures position.
     */
    private final Cell position;

    /**
     * A constructor for a position of a figure.
     * @param position is a current cell.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * A getter for position field.
     * @return sells position.
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * An overridden equals method for figure.
     * @param o parameter.
     * @return result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Figure figure = (Figure) o;

        return position != null ? position.equals(figure.position) : figure.position == null;
    }

    /**
     * An overridden hashCode method for figure.
     * @return result.
     */
    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }

    /**
     * A method witch is returned an array of a figure must go.
     * @param dest is a cell of a final destination for a current figure.
     * @return an array of the cells witch a figure must go.
     * @throws ImpossibleMoveException is an exception throws if a current way is impossible.
     */
    public abstract Cell[] way(Cell dest) throws ImpossibleMoveException;

    /**
     * A method clones figure into new position.
     * @param dist new cell.
     * @return new figures.
     */
    public abstract Figure clone(Cell dist);
}
