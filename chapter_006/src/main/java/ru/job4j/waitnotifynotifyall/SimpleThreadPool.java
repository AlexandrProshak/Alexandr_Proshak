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
     * A thread group for the shutDown() method.
     */
    private final ThreadGroup group;

    /**
     * A constructor.
     */
    public SimpleThreadPool() {
        this.pool = new Thread[CORES];
        this.queue = new SimpleBlockingQueue<>(new LinkedList<>(), QUEUE_LIMIT);
        this.group = new ThreadGroup("group");
        execute();
    }

    /**
     * The method executes a work given to the pool.
     */
    private void execute() {
        for (Thread thread : this.pool) {
            thread = new Thread(group, () -> {
                while (true) {
                    Runnable work = this.queue.peek();
                    work.run();
                }
            });
            thread.setDaemon(true);
            thread.start();
            if (thread.isInterrupted()) {
                System.exit(0);
            }
        }
    }

    /**
     * The method adds work to the queue in the pool.
     *
     * @param work is a task  be executed, an implementation of the interface Runnable.
     */
    public void add(Runnable work) {
        queue.offer(work);
    }

    /**
     * The method interrupts all threads.
     */
    public void shutDown() {
        this.group.interrupt();
    }

    /**
     * The method sends the poisoned pill to the thread pool.
     */
    public void shutDownWithSystemExit() {
        Runnable death = (()-> System.exit(0));
        this.add(death);
    }
}

