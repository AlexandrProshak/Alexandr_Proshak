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
     * An array of the chess figures.
     */
    private Figure[] figures;

    private Cell[][] boxes = new Cell[8][8];


    public Board(Figure[] figures) {
        this.figures = figures;
    }

    private void init() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[j][i] = new Cell(j, i);
            }

        }
    }

    public boolean move(Cell source, Cell dist)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        return false;
    }
}
