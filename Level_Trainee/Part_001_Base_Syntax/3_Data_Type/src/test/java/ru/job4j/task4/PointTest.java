package ru.job4j.task4;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;


/**
 * PointTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 *
 */
public class PointTest {

    /**
     * Test.
     */
    @Test
    public void whenOnePointIs1And1ThatPointIs1and2Than1() {
    Point point = new Point(1, 1);
        double distance = point.distanceTo(new Point(1, 2));
        assertThat(distance, closeTo(1, 0.1));
    }
}