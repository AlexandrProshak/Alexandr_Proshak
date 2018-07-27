package ru.job4j.task2;

/**
 * Factorial.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Factorial {

    /**
     * The method calculate factorial using loop method.
     * @param n for calculate.
     * @return factorial for n, for negative number returns -1.
     */
    public int calc(int n) {
        int result = -1;
        if (n == 0) {
            result = 1;
            return result;
        } else if (n > 0) {
            result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }

    /**
     * The method calculate factorial using recursion method.
     * @param n for calculate.
     * @return factorial for n, for negative number returns -1.
     */
    public int recursionFac(int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return n * (recursionFac(n - 1));
        } else {
            return -1;
        }
    }
}

