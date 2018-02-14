package ru.job4j.waitnotifynotifyall;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * The class SimpleLock.
 */
@ThreadSafe
public class SimpleLock {

    /**
     * The field to store the thread which caught the lock.
     */
    @GuardedBy("this")
    private Thread owner;

    /**
     * The flag to indicate the lock state.
     */
    @GuardedBy("this")
    private boolean free = true;

    /**
     * The method caches the lock.
     */
    public synchronized void lock() {
        while (!free) {
            if (this.owner == Thread.currentThread()) {
                break;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.owner = Thread.currentThread();
        this.free = false;
    }

    /**
     * The method releases the lock.
     */
    public synchronized void unlock() {
        while (!free & this.owner == Thread.currentThread()) {
            this.free = true;
            this.owner = null;
            notifyAll();
        }
    }

}