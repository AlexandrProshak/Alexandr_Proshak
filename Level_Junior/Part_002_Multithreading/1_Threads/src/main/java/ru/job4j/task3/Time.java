package ru.job4j.task3;

/**
 * The class Time checks an allowable time of program working.
 */
public class Time implements Runnable {

    /**
     * A field stores a time of threads starting.
     */
    private long startTime;

    /**
     * Allowed time of thread's life.
     */
    private static final long ALLOWED_WORK_TIME = 100;

    /**
     * The thread under control.
     */
    private Thread controlledThread;

    /**
     * A constructor.
     * @param controlledThread is a thread under control.
     */
    public Time(Thread controlledThread) {
        this.controlledThread = controlledThread;
    }

    @Override
    public void run() {
        this.startTime = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - this.startTime) < ALLOWED_WORK_TIME) {
                continue;
            } else {
                this.controlledThread.interrupt();
                break;
            }
        }
    }
}
