package ru.job4j.chess.board;

import ru.job4j.chess.ecxeptions.FigureNotFoundException;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;
import ru.job4j.chess.ecxeptions.OccupiedWayException;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.NoneFigure;

/**
 * Class Board.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Board {

    /**
     * The amount of figures on the board.
     */
    private static final int AMOUNT_OF_FIGURES = 32;

    /**
     * The object when figure is none.
     */
    private static final NoneFigure NONE_FIGURE = new NoneFigure();

    /**
     * An index for iteration by an array of figures.
     */
    private int index = 0;

    /**
     * An array of the chess figures.
     */
    private Figure[] figures = new Figure[AMOUNT_OF_FIGURES];

    /**
     * A getter for an array of the figures.
     * @return an array of figures.
     */
    public Figure[] getFigures() {
        return this.figures;
    }

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

        Figure figureOnSource = this.getFigureOnPosition(source);

        if (figureOnSource.equals(NONE_FIGURE)) {
            throw new FigureNotFoundException();
        } else {
            pass = figureOnSource.way(dist);
            result = true;
        }

        if (result) {
            for (Cell cell : pass) {
                if (this.getFigureOnPosition(cell) != NONE_FIGURE) {
                    throw new OccupiedWayException();
                }
            }
        }

        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i].equals(figureOnSource)) {
                this.figures[i] = this.figures[i].clone(dist);
                break;
            }
        }
        return result;
    }

    /**
     * The method return an existing figure on the given position.
     * The method returns NoneFigure object if a figure is not exist.
     * @param source a position for checking.
     * @return figure on the given position or NoneFigure object if a figure is not exist.
     */
    public Figure getFigureOnPosition(Cell source) {
        Figure result = null;
        for (Figure figure : this.figures) {
            if (figure != null && figure.getPosition().equals(source)) {
                result = figure;
                break;
            } else {
                result = NONE_FIGURE;
            }
        }
        return result;
    }
}
