package ru.job4j.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * The tests for NonBlockingCache class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class NonBlockingCacheTest {

    /**
     * The link to a cache instance.
     */
    private NonBlockingCache<Model> cache;

    /**
     * The thread pool.
     */
    private ExecutorService pool;

    /**
     * Atomic generator id.
     */
    private AtomicLong id;


    /**
     * Set upping date.
     */
    @Before
    public void setUp() {
        this.cache = new NonBlockingCache<>();
        this.pool = Executors.newFixedThreadPool(1000);
        this.id = new AtomicLong(0);
        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> cache.add(new Model(id.getAndIncrement(), "name is " + id)));
        }
    }

    /**
     * Shutdown pool.
     */
    @After
    public void setDown() {
        this.pool.shutdown();
    }

    /**
     * Test.
     * @throws InterruptedException exception.
     */
    @Test
    public void whenAddModelsThanCacheSizeIndicateIt() throws InterruptedException {
        Thread.sleep(300);
        assertThat(cache.size(), is(1000));
    }

    /**
     * Test.
     * @throws InterruptedException exception.
     */
    @Test
    public void whenUpdateThanVersionIsIncremented() throws InterruptedException {
        Thread.sleep(300);

        AtomicLong newId = new AtomicLong(0);
        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> {
                try {
                    cache.update(new Model(newId.getAndIncrement(), "name is " + newId + 1));
                } catch (OptimisticException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(300);

        StringBuilder result = new StringBuilder();
        for (long i = 0; i < 10; i++) {
            result.append(cache.read(i).getVersion());
        }

        assertFalse(result.toString().contains("0"));
    }

    /**
     * Test.
     * @throws InterruptedException exception.
     */
    @Test
    public void whenDeleteThanCacheSizeIsDecrease() throws InterruptedException {
        AtomicLong id = new AtomicLong(0);
        for (int i = 0; i < 500; i++) {
            pool.execute(() -> cache.delete(new Model(id.getAndIncrement(), "name is " + id)));
        }
        Thread.sleep(300);

        assertThat(cache.size(), is(500));
    }

}