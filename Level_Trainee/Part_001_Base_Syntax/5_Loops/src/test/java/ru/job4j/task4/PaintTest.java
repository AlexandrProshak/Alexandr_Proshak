package ru.job4j.task4;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PaintTest {

    /**
     * Test.
     */
    @Test
    public void whenTriangle4Right() {
        Paint paint = new Paint();
        String pyramid = paint.rightTrl(4);
        //System.out.println(pyramid);
        assertThat(pyramid, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^").toString()));
    }

    /**
     * Test.
     */
    @Test
    public void whenTriangle4Left() {
        Paint paint = new Paint();
        String pyramid = paint.leftTrl(4);
        //System.out.println(pyramid);
        assertThat(pyramid, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   ^")
                        .add("  ^^")
                        .add(" ^^^")
                        .add("^^^^").toString()));
    }

    /**
     * Test.
     */
    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String pyramid = paint.pyramid(4);
        //System.out.println(pyramid);
        assertThat(pyramid, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   ^   ")
                        .add("  ^^^  ")
                        .add(" ^^^^^ ")
                        .add("^^^^^^^").toString()));
    }
}