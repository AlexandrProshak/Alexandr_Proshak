package ru.job4j.task3;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * The SimpleLockTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@ThreadSafe
public class SimpleLockTest {

    /**
     * A SimpleLock.
     */
    private SimpleLock lock;

    /**
     * A variable for storing results.
     */
    @GuardedBy("lock")
    private int lockedResult;

    /**
     * A variable for storing results.
     */
    @GuardedBy("lock")
    private int unLockedResult;

    /**
     * The checked method of multithreading works.
     */
    @GuardedBy("lock")
    private void lockedIncrement() {
        lock.lock();
        lockedResult += 1;
    }

    /**
     * The checked method of multithreading works.
     */
    @GuardedBy("lock")
    private void unLockedIncrement() {
        lock.lock();
        unLockedResult += 1;
        lock.unlock();
    }

    /**
     * Setting initial dates.
     */
    @Before
    public void setUp() {
        this.lock = new SimpleLock();
        this.lockedResult = 0;
        this.unLockedResult = 0;
    }

    /**
     * Test.
     */
    @Test
    public void whenFirstThreadWasNotReleasesLockThanSecondThreadIsNotIncrement() {

        Thread first = new Thread(this::lockedIncrement);
        Thread second = new Thread(this::lockedIncrement);

        first.start();
        second.setDaemon(true);
        second.start();

        try {
           Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(lockedResult, is(1));
    }

    /**
     * Test.
     */
    @Test
    public void whenFirstThreadWasReleasesLockThanSecondThreadIncrements() {

        Thread first = new Thread(this::unLockedIncrement);
        Thread second = new Thread(this::unLockedIncrement);

        first.start();
        second.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(unLockedResult, is(2));
    }

}