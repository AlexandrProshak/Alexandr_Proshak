package ru.job4j.waitnotifynotifyall;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * A SimpleThreadPoolTest class.
 */
@ThreadSafe
public class SimpleThreadPoolTest {

    /**
     * A private mutex.
     */
    private final Object lock = new Object();

    /**
     * A variable for storing results.
     */
    @GuardedBy("lock")
    private int result;

    /**
     * The checked method of multithreading works.
     */
    @GuardedBy("lock")
    private void increment() {
        synchronized (lock) {
            result += 1;
        }
    }

    /**
     * Test.
     */
    @Test
    public void whenAddsBillionWorksThanHaveCalculatedResult() {

        SimpleThreadPool pool = new SimpleThreadPool();
        Runnable work = (()-> increment());

        for (int i = 0; i < 1000; i++) {
            pool.add(work);
        }
        System.out.println(result);
        assertTrue(result == 1000);
    }
}