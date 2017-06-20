package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.board.Cell;
import ru.job4j.chess.chessEcxeptions.ImpossibleMoveException;
import static org.junit.Assert.*;

/**
 * Class BishopTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {

    /**
     * A testing when the destination cell is not valid.
     * @throws Exception
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestinationCellIsNotRightThanThrowsImpossibleMoveException() throws ImpossibleMoveException {
        Cell a35 = new Cell(3, 4);
        Cell destCell = new Cell(5,8);
        Bishop bishop = new Bishop(a35);
        bishop.way(destCell);
    }

    /**
     * A testing when the destination cell is valid.
     * @throws Exception
     */
    @Test
    public void whenDestinationCellIsRightThanReturnAnArrayOfCells() throws ImpossibleMoveException {
        Cell a35 = new Cell(3, 4);
        Cell destCell = new Cell(6,7);
        Bishop bishop = new Bishop(a35);
        Cell[] result = bishop.way(destCell);
        Cell[] expected = new Cell[]{
                new Cell(4, 5),
                new Cell(5, 6),
                new Cell(6, 7),
        };
        assertArrayEquals(expected, result);
    }

}