package ru.job4j.task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BoardTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class BoardTest {

    /**
     * Test.
     */
    @Test
    public void whenGiveWeightAndHeightThanReturnChessboardAsString() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        String expRes = String.format(" X %sX X%s X %s", ln, ln, ln);
        assertEquals(expRes, result);
    }
}