package ru.job4j.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Funk.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Funk {

    /**
     * The diapason method calculate value in a range according to given function.
     * @param start diapason, inclusive.
     * @param end diapason, inclusive.
     * @param funk function to apply.
     * @return list of function values in a range.
     */
    public List<Double> diapason(int start, int end, Function<Integer, Double> funk) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(funk.apply(i));
        }
        return list;
    }

    /**
     * The linear function.
     * @param start diapason, inclusive.
     * @param end diapason, inclusive.
     * @param k an angle coefficient.
     * @param b a displacement
     * @return list of a linear function values in a range.
     */
    public List<Double> linear(int start, int end, double k, double b) {
        return this.diapason(start, end, x -> k * x + b);
    }

    /**
     * The quadratic function.
     * @param start diapason, inclusive.
     * @param end diapason, inclusive.
     * @param a quadratic coefficient
     * @param b linear coefficient
     * @param c displacement
     * @return values in the range of the quadratic function.
     */
    public List<Double> quadratic(int start, int end, double a, double b, double c) {
        return this.diapason(start, end, x -> a * x * x + b * x + c);
    }

    /**
     * The logarithms function.
     * @param start diapason, inclusive.
     * @param end diapason, inclusive.
     * @return values in the range of the logarithms function.
     */
    public List<Double> logarithms(int start, int end) {
        return this.diapason(start, end, Math::log);
    }

}
