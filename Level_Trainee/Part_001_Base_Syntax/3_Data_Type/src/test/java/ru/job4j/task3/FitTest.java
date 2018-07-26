package ru.job4j.task3;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * FitTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class FitTest {

    /**
     * Test.
     */
    @Test
    public void whenManHeight180ThanWeight92() {
        Fit fit = new Fit();
        double result = fit.manWeight(180);
        assertThat(result, closeTo(92.0, 0.1));
    }

    /**
     * Test.
     */
    @Test
    public void whenWomanHeight170ThanWeight69() {
        Fit fit = new Fit();
        double result = fit.womanWeight(170);
        assertThat(result, closeTo(69, 0.1));
    }
}