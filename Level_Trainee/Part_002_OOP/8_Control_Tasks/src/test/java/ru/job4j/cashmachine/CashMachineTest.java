package ru.job4j.cashmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CashMachineTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CashMachineTest {

    /**
     * A link for cash machine.
     */

    private Exchangeable exchangeable;

    /**
     * A coins set for an exchanging operation.
     */
    private int[] coins = new int[]{5, 10, 25};

    /**
     * Set up a machine.
     */
    @Before
    public void setUp() {
        exchangeable = new CashMachine(coins);
    }

    /**
     * A test for suggesting exchanging ways for 25.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTwentyFiveThanSuggestsFourWaysToExchange() {
        List<List<Integer>> expectedResult = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> array3 = new ArrayList<>();
        ArrayList<Integer> array4 = new ArrayList<>();
        array1.add(5);
        array1.add(5);
        array1.add(5);
        array1.add(5);
        array1.add(5);
        expectedResult.add(array1);
        array2.add(10);
        array2.add(5);
        array2.add(5);
        array2.add(5);
        expectedResult.add(array2);
        array3.add(10);
        array3.add(10);
        array3.add(5);
        expectedResult.add(array3);
        array4.add(25);
        expectedResult.add(array4);
        List<List<Integer>> result = exchangeable.exchange(25);
        assertThat(expectedResult, is(result));
    }
}