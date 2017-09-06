package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * CircledListCheckingTest class.
 */
public class CircledListCheckingTest {

    /**
     * Tests method hasCircle().
     */
    @Test
    public void whenListHasCircleThanReturnsTrue() {
        CircledListChecking<Integer> list = new CircledListChecking<>();

        CircledListChecking.Node first = new CircledListChecking.Node(1);
        CircledListChecking.Node second = new CircledListChecking.Node(2);
        CircledListChecking.Node third = new CircledListChecking.Node(3);
        CircledListChecking.Node fourth = new CircledListChecking.Node(4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(first);

        assertTrue(list.hasCircle(first));
    }

    /**
     * Tests method hasCircle() in the case none circled list.
     */
    @Test
    public void whenListHasNotCircleThanReturnsFalse() {
        CircledListChecking<Integer> list = new CircledListChecking<>();

        CircledListChecking.Node first = new CircledListChecking.Node(1);
        CircledListChecking.Node second = new CircledListChecking.Node(2);
        CircledListChecking.Node third = new CircledListChecking.Node(3);
        CircledListChecking.Node fourth = new CircledListChecking.Node(4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        assertFalse(list.hasCircle(first));
    }
}