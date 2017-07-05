package ru.job4j.chess.board;

import org.junit.Before;
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
    private Board board;

    /**
     * Figure is a bishop.
     */
    private Figure bishop;

    /**
     * A current position for bishop.
     */
    private Cell currentPosition;

    /**
     * Set up initialisation date.
     * @throws Exception if something goes wrong.
     */
    @Before
    public void setUp() throws Exception {
        this.board = new Board();
        this.currentPosition = new Cell(5, 5);
        this.bishop = new Bishop(this.currentPosition);
        this.board.addFigure(this.bishop);
    }

    /**
     * Testing a case when figure is not found.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureIsAbsentThenThrowFigureNotFoundException() throws Exception {
        Cell falseStart = new Cell(1, 1);
        Cell dest = new Cell(4, 1);
        this.board.move(falseStart, dest);
    }

    /**
     * Testing an impossible move of figure bishop.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsImpossibleThenThrowImpossibleMoveException() throws Exception {
        Cell dest = new Cell(4, 1);
        this.board.move(this.currentPosition, dest);
    }

    /**
     * Testing an occupied way by other figure.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWayIsOccupiedThenThrowOccupiedWayException() throws Exception {
        Cell dest = new Cell(7, 7);
        this.board.addFigure(new Bishop(new Cell(6, 6)));
        this.board.move(this.currentPosition, dest);
    }

    /**
     * Testing a case when bishop can move and moves.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenBishopCanMoveThanBoardMoveReturnsTrue() throws Exception {
        Cell dest = new Cell(7, 7);
        boolean result = this.board.move(this.currentPosition, dest);
        assertTrue(result);
    }

    /**
     * Testing an ability of correction clone.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenBishopCanMoveThanCurrentBishopIsInDestinationCell() throws Exception {
        boolean result = false;
        Cell dest = new Cell(7, 7);
        this.board.move(this.currentPosition, dest);
        Figure[] figures = this.board.getFigures();
        for (Figure fig : figures) {
            if (fig != null && fig.equals(this.board.getFigureOnPosition(dest))) {
                result = true;
            }
        }
        assertTrue(result);
    }
}