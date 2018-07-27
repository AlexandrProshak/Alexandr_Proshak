package ru.job4j.task4;

import java.util.function.BiPredicate;

/**
 * Paint.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Paint {

    /**
     * The method returns right side rightTrl in a pseudo-graphic.
     * @param height height.
     * @return left side rightTrl in a pseudo-graphic.
     */
    public String rightTrl(int height) {
//        StringBuilder builder = new StringBuilder();
//        String separator = System.lineSeparator();
//        int weight = height;
//        for (int row = 0; row != height; row++) {
//            for (int column = 0; column != weight; column++) {
//                if (row >= column) {
//                    builder.append("^");
//                } else {
//                    builder.append(" ");
//                }
//            }
//            builder.append(separator);
//        }
//        return builder.toString();
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column);
    }

    /**
     * The method returns left side rightTrl in a pseudo-graphic.
     * @param height height.
     * @return left side rightTrl in a pseudo-graphic.
     */
    public String leftTrl(int height) {
//        StringBuilder screen = new StringBuilder();
//        int weight = height;
//        for (int row = 0; row != height; row++) {
//            for (int column = 0; column != weight; column++) {
//                if (row >= weight - column - 1) {
//                    screen.append("^");
//                } else {
//                    screen.append(" ");
//                }
//            }
//            screen.append(System.lineSeparator());
//        }
//        return screen.toString();
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1);
    }

    /**
     * The method returns pyramid in a pseudo-graphic.
     * @param height height.
     * @return left side rightTrl in a pseudo-graphic.
     */
    public String pyramid(int height) {
//        StringBuilder screen = new StringBuilder();
//        int weight = 2 * height - 1;
//        for (int row = 0; row != height; row++) {
//            for (int column = 0; column != weight; column++) {
//                if (row >= height - column - 1 && row + height - 1 >= column) {
//                    screen.append("^");
//                } else {
//                    screen.append(" ");
//                }
//            }
//            screen.append(System.lineSeparator());
//        }
//        return screen.toString();
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    /**
     * The method returns String according to predicate.
     * @param height height.
     * @param weight weight.
     * @param predicate predicate.
     * @return string line.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predicate) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predicate.test(row, column)) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
