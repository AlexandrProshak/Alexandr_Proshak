package ru.job4j.task3;

/**
 * Fit. The program to calculate ideal weight for man and woman.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Fit {

    /**
     * Ideal weight for man.
     * @param height height in sm.
     * @return weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for woman.
     * @param height height in sm.
     * @return weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
