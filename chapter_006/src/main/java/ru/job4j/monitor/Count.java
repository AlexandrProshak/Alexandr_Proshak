package ru.job4j.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * The class Count describes a synchronized incrementation.
 */
@ThreadSafe
public class Count {

    /**
     * The accumulator of increasing.
     */
    private int counter;

    /**
     * A method increments the counter field.
     */
    @GuardedBy("this")
    public void increment() {
        synchronized (this) {
            this.counter++;
        }
    }

    /**
     * A getter for the counter field.
     * @return counter.
     */
    @GuardedBy("this")
    public synchronized int getCounter() {
        return counter;
    }
}
