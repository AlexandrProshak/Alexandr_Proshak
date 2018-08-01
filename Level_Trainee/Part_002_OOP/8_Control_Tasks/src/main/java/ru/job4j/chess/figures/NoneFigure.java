package ru.job4j.chess.figures;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;

/**
 * Class NoneFigure.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class NoneFigure extends  Figure {

    /**
     * A constructor for none figure.
     */
    public NoneFigure() {
        super(new Cell(-1, -1));
    }

    /**
     * A method way for NoneFigure.
     * @param dest is a cell of a final destination for a current figure.
     * @return an array which contents zero elements.
     * @throws ImpossibleMoveException if something went wrong.
     */
    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        return new Cell[0];
    }

    /**
     * A method clone for NoneFigure.
     * @param dist new cell.
     * @return NoneFigure object.
     */
    @Override
    public Figure clone(Cell dist) {
        return new NoneFigure();
    }
}