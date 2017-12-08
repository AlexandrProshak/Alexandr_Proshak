package ru.job4j.threads.interruptthreads;

/**
 * The class CountChar describes a way of counting chars.
 */
public class CountChar implements Runnable {

    /**
     * The field for saving a string to be counted chars.
     */
    private String string;

    /**
     * The counter for chars.
     */
    private int counter = 0;

    /**
     * The constructor.
     * @param string to be counted chars.
     */
    public CountChar(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        char[] chars = this.string.toCharArray();
        for (char element : chars) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.format("Thread %s is interrupted!%s", Thread.currentThread().getName(), System.lineSeparator());
                break;
            } else if (element == ' ') {
                continue;
            } else {
                this.counter++;
            }
        }
        System.out.format("Amount of chars are %s.%s", this.counter, System.lineSeparator());
    }
}
