package ru.job4j.chess.figures;

import org.junit.BeforeClass;
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

    private static Cell bishopsPosition;
    private static Bishop bishop;

    @BeforeClass
    public static void setUp() {
        BishopTest.bishopsPosition = new Cell(3, 4);
        BishopTest.bishop = new Bishop(BishopTest.bishopsPosition);
    }

    /**
     * A testing when the destination cell is not valid.
     * @throws Exception
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestinationCellIsNotRightThanThrowsImpossibleMoveException() throws ImpossibleMoveException {
        Cell destCell = new Cell(5,8);
        BishopTest.bishop.way(destCell);
    }

    /**
     * A testing when the destination cell is valid and moves up-right.
     * @throws Exception
     */
    @Test
    public void whenDestinationCellIsRightThanReturnAnArrayOfCells() throws ImpossibleMoveException {
        Cell destCell = new Cell(6,7);
        Cell[] result = BishopTest.bishop.way(destCell);
        Cell[] expected = new Cell[]{
                new Cell(4, 5),
                new Cell(5, 6),
                new Cell(6, 7),
        };
        assertArrayEquals(expected, result);
    }

    /**
     * A testing when a bishop moves up-left.
     * @throws Exception
     */
    @Test
    public void whenMovesUpLeftThanReturnAnArrayOfCells() throws ImpossibleMoveException {
        Cell destCell = new Cell(0,7);
        Cell[] result = BishopTest.bishop.way(destCell);
        Cell[] expected = new Cell[]{
                new Cell(2, 5),
                new Cell(1, 6),
                new Cell(0, 7),
        };
        assertArrayEquals(expected, result);
    }

    /**
     * A testing when a bishop moves down-left.
     * @throws Exception
     */
    @Test
    public void whenMovesDownLeftThanReturnAnArrayOfCells() throws ImpossibleMoveException {
        Cell destCell = new Cell(0,1);
        Cell[] result = BishopTest.bishop.way(destCell);
        Cell[] expected = new Cell[]{
                new Cell(2, 3),
                new Cell(1, 2),
                new Cell(0, 1),
        };
        assertArrayEquals(expected, result);
    }

    /**
     * A testing when a bishop moves down-right.
     * @throws Exception
     */
    @Test
    public void whenMovesDownRightThanReturnAnArrayOfCells() throws ImpossibleMoveException {
        Cell destCell = new Cell(7,0);
        Cell[] result = BishopTest.bishop.way(destCell);
        Cell[] expected = new Cell[]{
                new Cell(4, 3),
                new Cell(5, 2),
                new Cell(6, 1),
                new Cell(7, 0),
        };
        assertArrayEquals(expected, result);
    }
}