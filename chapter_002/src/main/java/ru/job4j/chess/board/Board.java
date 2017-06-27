package ru.job4j.chess.board;

import ru.job4j.chess.chessEcxeptions.FigureNotFoundException;
import ru.job4j.chess.chessEcxeptions.ImpossibleMoveException;
import ru.job4j.chess.chessEcxeptions.OccupiedWayException;
import ru.job4j.chess.figures.Figure;

/**
 * Class Board.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     *The amount of figures on the board.
     */
    private static final int AMOUNT_OF_FIGURES = 32;

    private int index = 0;
    /**
     * An array of the chess figures.
     */
    private Figure[] figures = new Figure[AMOUNT_OF_FIGURES];

    /**
     * A method of putting a figure on the board.
     * @param figure for put.
     */
    public void setFigure(Figure figure) {
        this.figures[index++] = figure;
    }

    /**
     * A method determines an ability of a figure moving.
     * @param source a current index.
     * @param dist a destination index.
     * @return true if the figure can move, false if not.
     * @throws ImpossibleMoveException an exception of impossible moving.
     * @throws OccupiedWayException an exception of an occupied index.
     * @throws FigureNotFoundException an exception if the figure is not found.
     */
    public boolean move(Cell source, Cell dist)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        return false;
    }

//    public boolean freePass(Cell[] pass) throws ImpossibleMoveException {
//        boolean result = false;
//        for (Figure figure : this.figures) {
//            for (Cell cell : pass) {
//                if (figure != null && figure.position.equals(cell)) {
//                    throw new ImpossibleMoveException();
//                } else {
//                    continue;
//                }
//            }
//        }
//        return result = true;
//    }
}
