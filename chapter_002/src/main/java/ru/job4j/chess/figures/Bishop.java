package ru.job4j.chess.figures;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.board.Color;
import ru.job4j.chess.chessEcxeptions.ImpossibleMoveException;

/**
 * Class Bishop.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Bishop extends Figure {

    /**
     * A constructor of a class Bishop.
     * @param position is a position witch is occupied by a Bishop.
     */
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {

        //a destination coordinate X.
        int destX = dest.getX();

        //a destination coordinate Y.
        int destY = dest.getY();

        //a bishops current coordinate X.
        int bishopX = this.position.getX();

        //a bishops current coordinate Y.
        int bishopY = this.position.getY();

        //a calculation of a result's array length.
        int lengthOfArray = Math.abs(bishopX - destX);
        Cell[] result = new Cell[lengthOfArray];

        //a way when bishop moves up-right.
        if (destX > bishopX && destY > bishopY) {
            for (int i = 0; i < lengthOfArray; i++) {
                Cell cell = new Cell(bishopX + i + 1, bishopY + i + 1);
                //checking of a current cell for free.
                if (cell.getOccupiedByFigure() == true) {
                    this.impMoveEx();
                } else {
                    result[i] = cell;
                }
            }
        }
        //a way when bishop moves down-left.
        if (destX < bishopX && destY < bishopY) {
            for (int i = 1; i <= lengthOfArray; i++) {
                Cell cell = new Cell(bishopX - i, bishopY - i);
                if (cell.getOccupiedByFigure() == true) {
                    this.impMoveEx();
                } else {
                    result[i - 1] = cell;
                }
            }
        }
        //a way when bishop moves down-right.
        if (destX > bishopX && destY < bishopY) {
            for (int i = 1; i <= lengthOfArray; i++) {
                Cell cell = new Cell(bishopX + i, bishopY - i);
                if (cell.getOccupiedByFigure() == true) {
                    this.impMoveEx();
                } else {
                    result[i - 1] = cell;
                }
            }
        }
        //a way when bishop moves up-left.
        if (destX < bishopX && destY > bishopY) {
            for (int i = 1; i <= lengthOfArray; i++) {
                Cell cell = new Cell(bishopX - i, bishopY + i);
                if (cell.getOccupiedByFigure() == true) {
                    this.impMoveEx();
                } else {
                    result[i - 1] = cell;
                }
            }
        }
        //a checking of the final destination.
            if (dest.getX() != result[lengthOfArray - 1].getX() && dest.getY() != result[lengthOfArray - 1].getY()) {
            this.impMoveEx();
        }
        return result;
    }
}
