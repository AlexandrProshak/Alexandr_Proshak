package ru.job4j.task1;

/**
 * The class Runner demonstrates a synchronize Count work.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Runner {

    /**
     * This method calls the method increment() from the class Count 1000_000 times.
     * @param count an instance of the class Counter.
     */
    private static void incrementCount(final Count count) {
        for (int i = 0; i < 1000_000; i++) {
            count.increment();
        }
    }

    /**
     * The method main.
     * @param args console input arguments.
     */
    public static void main(String[] args) {
        final Count count = new Count();

        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " is started. Initial value of counter is " + count.getCounter());
            Runner.incrementCount(count);
            System.out.println(Thread.currentThread().getName()
                    + " is finished with value of counter " + count.getCounter());
        });
        threadA.setName("Thread A");

        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " is started. Initial value of counter is " + count.getCounter());
            Runner.incrementCount(count);
            System.out.println(Thread.currentThread().getName()
                    + " is finished with value of counter " + count.getCounter());
        });
        threadB.setName("Thread B");

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("    All threads are finished" + System.lineSeparator());
        }

        System.out.println("Expected result is 2000000");
        System.out.println("    Real result is " + count.getCounter());
    }
}
