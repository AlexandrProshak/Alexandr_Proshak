package ru.job4j.chess.board;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.chess.ecxeptions.FigureNotFoundException;
import ru.job4j.chess.ecxeptions.ImpossibleMoveException;
import ru.job4j.chess.ecxeptions.OccupiedWayException;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Figure;
import static org.junit.Assert.assertTrue;

/**
 * Class BoardTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {

    /**
     * Our board for figures.
     */
    private  static Board board;

    /**
     * Figure is a bishop.
     */
    private static Figure bishop;

    /**
     * A current position for bishop.
     */
    private static Cell currentPosition;

    /**
     * Set up initialisation date.
     * @throws Exception if something goes wrong.
     */
    @BeforeClass
    public static void setUp() throws Exception {
        BoardTest.board = new Board();
        BoardTest.currentPosition = new Cell(5, 5);
        BoardTest.bishop = new Bishop(BoardTest.currentPosition);
        BoardTest.board.addFigure(BoardTest.bishop);
    }

    /**
     * Testing a case when figure is not found.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureIsAbsentThenThrowFigureNotFoundException() throws Exception {
        Cell falseStart = new Cell(1, 1);
        Cell dest = new Cell(4, 1);
        BoardTest.board.move(falseStart, dest);
    }

    /**
     * Testing an impossible move of figure bishop.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsImpossibleThenThrowImpossibleMoveException() throws Exception {
        Cell dest = new Cell(4, 1);
        BoardTest.board.move(BoardTest.currentPosition, dest);
    }

    /**
     * Testing an occupied way by other figure.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWayIsOccupiedThenThrowOccupiedWayException() throws Exception {
        Cell dest = new Cell(7, 7);
        BoardTest.board.addFigure(new Bishop(new Cell(6, 6)));
        BoardTest.board.move(BoardTest.currentPosition, dest);
    }

    /**
     * Testing a case when bishop can move and moves.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenBishopCanMoveThanHasBishopInDestinationCell() throws Exception {
        Cell dest = new Cell(7, 7);
        boolean result = BoardTest.board.move(BoardTest.currentPosition, dest);
        assertTrue(result);
    }

}