package ru.job4j.task7;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MatrixCheckTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class MatrixCheckTest {

    /**
     * Test.
     */
    @Test
    public void whenDataThreeDimMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataThreeDimNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataThreeDimByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenTwoDimensionalDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true},
                {false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataTwoDimMonoByFalseRightThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false},
                {false, false},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test.
     */
    @Test
    public void whenDataTwoDimMonoByTrueLeftThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false},
                {false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}