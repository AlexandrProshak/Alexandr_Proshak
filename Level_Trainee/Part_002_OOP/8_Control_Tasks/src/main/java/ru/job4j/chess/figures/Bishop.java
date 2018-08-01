package ru.job4j.chess.figures;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;

/**
 * Class Bishop.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Bishop extends Figure {

    /**
     * A constructor of a class Bishop.
     * @param position is a position witch is occupied by a Bishop.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * The method is inherited from the abstract class.
     * @param dest is a cell of a final destination for a current figure.
     * @return an array of Cells.
     * @throws ImpossibleMoveException an exception if the destination sell is not valid.
     */
    public Cell[] way(Cell dest) throws ImpossibleMoveException {

        Cell[] result;

        //a destination coordinate X.
        int destX = dest.getX();

        //a destination coordinate Y.
        int destY = dest.getY();

        //a bishops current coordinate X.
        int bishopX = this.getPosition().getX();

        //a bishops current coordinate Y.
        int bishopY = this.getPosition().getY();

        int distanceByX = Math.abs(destX - bishopX);
        int distanceByY = Math.abs(destY - bishopY);

        /**
         * A checking valid way for a Bishop.
         */
        if (distanceByX != distanceByY) {
            throw new ImpossibleMoveException();
        } else {
            result = new Cell[distanceByX];
            //a way when bishop moves up-right.
            if (destX > bishopX && destY > bishopY) {
                for (int i = 0; i < distanceByX; i++) {
                    Cell cell = new Cell(bishopX + i + 1, bishopY + i + 1);
                    result[i] = cell;
                }
            }
            //a way when bishop moves up-left.
            if (destX < bishopX && destY > bishopY) {
                for (int i = 0; i < distanceByX; i++) {
                    Cell cell = new Cell(bishopX - i - 1, bishopY + i + 1);
                    result[i] = cell;
                }
            }
            //a way when bishop moves down-left.
            if (destX < bishopX && destY < bishopY) {
                for (int i = 0; i < distanceByX; i++) {
                    Cell cell = new Cell(bishopX - i - 1, bishopY - i - 1);
                    result[i] = cell;
                }
            }
            //a way when bishop moves down-right.
            if (destX > bishopX && destY < bishopY) {
                for (int i = 0; i < distanceByX; i++) {
                    Cell cell = new Cell(bishopX + i + 1, bishopY - i - 1);
                    result[i] = cell;
                }
            }

        }
        return result;
    }

    /**
     * A method returns new bishop in a destination cell.
     * @param destination a destination cell.
     * @return new Bishop.
     */
    public Figure clone(Cell destination) {
        return new Bishop(destination);
    }
}
