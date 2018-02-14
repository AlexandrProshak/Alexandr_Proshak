package ru.job4j.waitnotifynotifyall;

import java.util.LinkedList;

/**
 * The class describes a simple thread pool
 * with amount of thread equals to the current processor cores.
 */
public class SimpleThreadPool {

    /**
     * An amount of available cores on current processor.
     */
    private static final int CORES = Runtime.getRuntime().availableProcessors();

    /**
     * A thread pools queue size.
     */
    private static final int QUEUE_LIMIT = 16;

    /**
     * An array of the threads.
     */
    private final Thread[] pool;

    /**
     * A bounded blocking queue.
     */
    private final SimpleBlockingQueue<Runnable> queue;

    /**
     * A constructor.
     */
    public SimpleThreadPool() {
        this.pool = new Thread[CORES];
        this.queue = new SimpleBlockingQueue<>(new LinkedList<>(), QUEUE_LIMIT);
    }

    /**
     * The method starts pool.
     */
    public void start() {
        execute();

    }

    /**
     * The method executes a work given to the pool.
     */
    private void execute() {
        for (Thread thread : this.pool) {
            thread = new Thread(() -> {
                Thread me = Thread.currentThread();
                while (true) {
                    Runnable work = this.queue.peek();
                    work.run();
                    if (me.isInterrupted()) {
                        break;
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * The method adds work to the queue in the pool.
     * @param work is a task  be executed, an implementation of the interface Runnable.
     */
    public void add(Runnable work) {
        queue.offer(work);
    }

    /**
     * The method adds specific work to the pool which force each thread finish.
     */
    public void stop() {
        Runnable stopper = () -> Thread.currentThread().interrupt();
        for (int i = 0; i < pool.length; i++) {
            this.add(stopper);
        }
    }
}

