package ru.job4j.waitnotifynotifyall;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * The test class for the SimpleBlockingQueue class.
 */
public class SimpleBlockingQueueTest {

    /**
     * The result.
     */
    private volatile int result = 0;

    /**
     * An amount of threads.
     */
    private static final int THREADS_NUMBER = 3;

    /**
     * Test.
     */
    @Test
    public void whenProducerOffersValueAndConsumerPeeksValueThanResultHasValue() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(2);

        int expectedResult = THREADS_NUMBER;

        Thread[] producers = new Thread[THREADS_NUMBER];
        Thread[] consumers = new Thread[THREADS_NUMBER];

        for (int i = 0; i < THREADS_NUMBER; i++) {
            producers[i] = new Thread(() -> queue.offer(1));
        }

        for (int i = 0; i < THREADS_NUMBER; i++) {
            consumers[i] = new Thread(() -> result += queue.peek());
        }

        for (Thread producer: producers) {
            producer.start();
        }

        for (Thread consumer: consumers) {
            consumer.start();
        }

        for (Thread producer: producers) {
            try {
                producer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread consumer: consumers) {
            try {
                consumer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertTrue(expectedResult == result);
    }

    /**
     * Test.
     */
    @Test
    public void whenProducerOffersValueAndConsumerPeeksValueThanQueueIsEmpty() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread[] producers = new Thread[THREADS_NUMBER];
        Thread[] consumers = new Thread[THREADS_NUMBER];

        for (int i = 0; i < THREADS_NUMBER; i++) {
            producers[i] = new Thread(() -> queue.offer(1));
        }

        for (int i = 0; i < THREADS_NUMBER; i++) {
            consumers[i] = new Thread(() -> result += queue.peek());
        }

        for (Thread producer: producers) {
            producer.start();
        }

        for (Thread consumer: consumers) {
            consumer.start();
        }

        for (Thread producer: producers) {
            try {
                producer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread consumer: consumers) {
            try {
                consumer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertTrue(queue.amountElementsInQueue() == 0);
    }
}

