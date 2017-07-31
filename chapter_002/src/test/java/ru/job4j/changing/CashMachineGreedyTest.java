package ru.job4j.changing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CashMachineGreedyTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class CashMachineGreedyTest {

    /**
     * A link for cash machine.
     */

    private Exchangeable exchangeable;

    /**
     * A coins set for an exchanging operation.
     */
    private int[] coins = new int[]{25, 10, 5};

    /**
     * Set up a machine.
     */
    @Before
    public void setUp() {
        exchangeable = new CashMachineGreedy(coins);
    }

    /**
     * A test for exchanging 50 using greedy algorithm.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenExchangeFiftyThanGetTwoTwentyFive() throws Exception {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(25);
        array.add(25);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(array);
        List<List<Integer>> result = exchangeable.exchange(50);
        assertThat(expectedResult, is(result));
    }

    /**
     * A test for exchanging 65 using greedy algorithm.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenExchangeSixtyFiveThanGetTwoTwentyFiveOneTenOneFive() throws Exception {
        List<List<Integer>> expectedResult = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        array.add(25);
        array.add(25);
        array1.add(10);
        array2.add(5);
        expectedResult.add(array);
        expectedResult.add(array1);
        expectedResult.add(array2);
        List<List<Integer>> result = exchangeable.exchange(65);
        assertThat(expectedResult, is(result));
    }

    /**
     * A test for exchanging 74 using greedy algorithm.
     * @throws Exception if something goes wrong.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenExchangeFourThanUnsupportedOperationException() throws Exception {
        exchangeable.exchange(74);
    }
}