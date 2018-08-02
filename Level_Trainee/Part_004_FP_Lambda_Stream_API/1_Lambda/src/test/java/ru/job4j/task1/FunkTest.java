package ru.job4j.task1;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * FunkTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class FunkTest {

    /**
     * Tests.
     */
    @Test
    public void shouldReturnListOfGivenLinearFunctionValuesInGivenRange() {
        Funk ranges = new Funk();
        List<Double> values = ranges.diapason(1, 5, x -> 2.0 * x);
        assertThat(values, contains(2.0, 4.0, 6.0, 8.0, 10.0));
    }

    /**
     * Tests.
     */
    @Test
    public void shouldReturnListOfGivenQuadraticFunctionValuesInGivenRange() {
        Funk ranges = new Funk();
        List<Double> values = ranges.diapason(1, 5, x -> 3.0 * x * x * 2.0 * x + 1.0);
        assertThat(values, contains(7.0, 49.0, 163.0, 385.0, 751.0));
    }

    /**
     * Tests.
     */
    @Test
    public void shouldReturnListOfGivenLogarithmFunctionValuesInGivenRange() {
        Funk ranges = new Funk();
        List<Double> values = ranges.diapason(1, 5, x -> Math.log(x));
        assertThat(values, contains(0.0, 0.6931471805599453, 1.0986122886681098, 1.3862943611198906, 1.6094379124341003));
    }
}