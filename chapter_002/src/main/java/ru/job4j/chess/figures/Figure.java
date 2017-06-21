package ru.job4j.chess.figures;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.board.Color;
import ru.job4j.chess.chessEcxeptions.ImpossibleMoveException;

/**
 * Class Figure.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public abstract class Figure {
    /**
     * a cell of figures position.
     */
    public final Cell position;

    /**
     * A constructor for a position of a figure.
     * @param position is a current cell.
     */
    protected Figure(Cell position) {
        this.position = position;
        this.position.setOccupiedByFigure(true);
    }

    /**
     * A method witch is returned an array of a figure must go.
     * @param dest is a cell of a final destination for a current figure.
     * @return an array of the cells witch a figure must go.
     * @throws ImpossibleMoveException is an exception throws if a current way is impossible.
     */
    public abstract Cell[] way(Cell dest) throws ImpossibleMoveException;

    protected void impMoveEx() throws ImpossibleMoveException {
        throw new ImpossibleMoveException();
    }
}
