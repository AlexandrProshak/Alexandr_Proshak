package ru.job4j.chess;

import ru.job4j.chess.board.Cell;
import ru.job4j.chess.chessEcxeptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Bishop;

/**
 * Class Start.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Start {

    public static void main(String[] args) throws ImpossibleMoveException {
        Cell a35 = new Cell(3, 4);
        Cell destCell = new Cell(6,7);
        Bishop bishop = new Bishop(a35);
        Cell[] result = bishop.way(destCell);
        Cell[] expected = new Cell[] {
                new Cell(4,5),
                new Cell(5,6),
                new Cell(6,7),
        };

        for (Cell cell : result) {
            System.out.print(cell.getX());
            System.out.print(cell.getY());
            System.out.println();
        }
    }
}
