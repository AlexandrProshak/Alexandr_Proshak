package ru.job4j.task4;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PaintTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PaintTest {

    /**
     * An instance of a class Paint.
     */
    private static Paint paint;

    /**
     * An initialisation date for Test.
     */
    @BeforeClass
    public static void init() {
        PaintTest.paint = new Paint();

    }

    /**
     * A Test for a triangle.
     */
    @Test
    public void whenShapeIsTriangleThanDrawTriangle() {
        assertThat(PaintTest.paint.draw(new Triangle()), is(String.format(" ^ %s^^^", "\n")));
    }

    /**
     * A Test for a square.
     */
    @Test
    public void whenShapeIsSquareThanDrawSquare() {
        assertThat(PaintTest.paint.draw(new Square()), is(String.format("^^^%s^^^%s^^^", "\n", "\n")));
    }

}