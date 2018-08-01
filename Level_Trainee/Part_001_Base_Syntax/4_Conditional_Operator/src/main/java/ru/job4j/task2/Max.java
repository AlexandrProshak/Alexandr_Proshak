package ru.job4j.task2;

/**
 *  Maximum.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Max {

    /**
     * Maximum of two numbers.
     * @param first - first param.
     * @param second - second param.
     * @return returning max value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Maximum of three numbers.
     * @param first - first number.
     * @param second - second number.
     * @param third - third number.
     * @return returning max value.
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
}
