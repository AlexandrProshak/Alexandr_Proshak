package ru.job4j.strategy;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PaintTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * An instance of a class Paint.
     */
    private static Paint paint;

    /**
     * An initialisation date for test.
     */
    @BeforeClass
    public static void init() {
        PaintTest.paint = new Paint();

    }
    /**
     * A test for a triangle.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenShapeIsTriangleThanDrawTriangle() throws Exception {
        assertThat(PaintTest.paint.draw(new Triangle()), is(String.format(" ^ %s^^^", "\n")));
    }

    /**
     * A test for a square.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenShapeIsSquareThanDrawSquare() throws Exception {
        assertThat(PaintTest.paint.draw(new Square()), is(String.format("^^^%s^^^%s^^^", "\n", "\n")));
    }

}