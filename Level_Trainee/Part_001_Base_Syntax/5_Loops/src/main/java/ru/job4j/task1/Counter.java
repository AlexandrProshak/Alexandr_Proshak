package ru.job4j.task1;

/**
 * Counter.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Counter {

    /**
     * Sum even numbers of loop.
     * @param start - begin of range.
     * @param finish - end of range.
     * @return returning sum.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
