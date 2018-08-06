package ru.job4j.task1;

/**
 * The class ConcurrentCounter describes a race condition situation
 * of shared and not synchronized data.
 */
public class ConcurrentCounter {

    /**
     * An amount of a loop iteration.
     */
    private static final int N = 1000_000;

    /**
     * An accumulator.
     */
    private static int counter = 0;

    /**
     * A method calling from different threads to demonstrates a cashed value.
     */
    public static void increaseCounter() {
        for (int i = 0; i < N; i++) {
            counter++;
        }
    }

    /**
     * The main method.
     * @param args args.
     * @throws InterruptedException in case of interrupt.
     */
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            increaseCounter();
            System.out.println("Thread A is finished");
        });

        Thread threadB = new Thread(() -> {
            increaseCounter();
            System.out.println("Thread B is finished");
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("Expected result is 2000000");
        System.out.println("    Real result is " + counter);
    }
}
