package ru.job4j.task1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * The class Count describes a synchronized incrementation.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@ThreadSafe
public class Count {

    /**
     * The accumulator of increasing.
     */
    @GuardedBy("this")
    private int counter;

    /**
     * A method increments the counter field.
     */
    public void increment() {
        synchronized (this) {
            this.counter++;
        }
    }

    /**
     * A getter for the counter field.
     * @return counter.
     */
    public synchronized int getCounter() {
        return counter;
    }
}
