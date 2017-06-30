package ru.job4j.chess.board;

import ru.job4j.chess.ecxeptions.FigureNotFoundException;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;
import ru.job4j.chess.ecxeptions.OccupiedWayException;
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
     * The amount of figures on the board.
     */
    private static final int AMOUNT_OF_FIGURES = 32;

    /**
     * An index for iteration by an array of figures.
     */
    private int index = 0;

    /**
     * An array of the chess figures.
     */
    private Figure[] figures = new Figure[AMOUNT_OF_FIGURES];

    /**
     * A method of putting a figure on the board.
     *
     * @param figure for put.
     */
    public void addFigure(Figure figure) {
        this.figures[index++] = figure;
    }

    /**
     * A method determines an ability of a figure moving.
     *
     * @param source a current index.
     * @param dist   a destination index.
     * @return true if the figure can move, false if not.
     * @throws ImpossibleMoveException an exception of impossible moving.
     * @throws OccupiedWayException    an exception of an occupied index.
     * @throws FigureNotFoundException an exception if the figure is not found.
     */
    public boolean move(Cell source, Cell dist)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result = false;
        Cell[] pass = null;

        for (Figure figure : this.figures) {
            if (figure != null && source != null && source.equals(figure.getPosition())) {
                result = true;
                pass = figure.way(dist);
                break;
            } else {
                throw new FigureNotFoundException();
            }
        }

        if (result) {
            for (Figure figure : this.figures) {
                for (Cell cell : pass) {
                    if (figure != null && cell.equals(figure.getPosition())) {
                        throw new OccupiedWayException();
                    }
                }
            }
        }

        for (Figure figure : this.figures) {
            if (figure != null && figure.getPosition().equals(source)) {
                figure = figure.clone(dist);
                break;
            }
        }

        return result;
    }
}
