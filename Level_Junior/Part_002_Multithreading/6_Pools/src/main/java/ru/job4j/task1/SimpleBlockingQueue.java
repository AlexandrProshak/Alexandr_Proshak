package ru.job4j.task1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The class SimpleBlockingQueue is a simple implementation blockingQueue.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <T> generic parameter.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    /**
     * A privet mutex.
     */
    private final Object lock = new Object();

    /**
     * A max size of buffer.
     */
    private final int size;

    /**
     * A container for a blocking queue.
     */
    @GuardedBy("lock")
    private Queue<T> queue;

    /**
     * A constructor without parameters. Constructing SimpleBlockingQueue with default parameters.
     * LinkedList for the container and max size is 1;
     */
    public SimpleBlockingQueue() {
        this(new LinkedList<>(), 1);
    }

    /**
     * A constructor with one parameter. Default container is LinkedList.
     * LinkedList for the container and max size is 1;
     * @param size max size of a queue.
     */
    public SimpleBlockingQueue(int size) {
        this(new LinkedList<>(), size);
    }

    /**
     * A constructor with one parameter. Default size is 1.
     * @param queue a container for the queue.
     */
    public SimpleBlockingQueue(Queue<T> queue) {
        this(queue, 1);
    }

    /**
     * A constructor.
     * @param queue container which implements Queue interface for a blocking queue.
     * @param size max size of a queue.
     */
    public SimpleBlockingQueue(Queue<T> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    /**
     * Methods amountElementsInQueue returns an amount of the elements in the queue.
     * @return an amount of the elements in the queue.
     */
    @GuardedBy("lock")
    public int amountElementsInQueue() {
        synchronized (lock) {
            return queue.size();
        }
    }

    /**
     * The method inserts the specified element into this queue,
     * in case if queue.size is less then maximum capacity of a container.
     * If queue is not free the method waits until queue will be available.
     * @param value to be inserted.
     */
    @GuardedBy("lock")
    public void offer(T value) {
        synchronized (lock) {
            while (this.size == this.queue.size()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.exit(0);
                }
            }
            this.queue.offer(value);
            lock.notifyAll();
        }

    }

    /**
     * The method returns and removes the first element of this queue.
     * If queue is empty method waits until element will be present.
     * @return the first element.
     */
    @GuardedBy("lock")
    public T peek() {
        synchronized (lock) {
            while (this.queue.size() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.exit(0);
                }
            }
            T result = this.queue.poll();
            lock.notifyAll();
            return result;
        }
    }
}
