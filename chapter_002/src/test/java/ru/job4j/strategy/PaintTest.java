package ru.job4j.strategy;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class PaintTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {

    private static Paint paint;

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
        assertEquals(PaintTest.paint.draw(new Triangle()), "I am a triangle");
    }

    /**
     * A test for a square.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenShapeIsSquareThanDrawSquare() throws Exception {
        assertEquals(PaintTest.paint.draw(new Square()), "I am a square");
    }

}