package ru.job4j.task1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConvertList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConvertListTest {

    /**
     * Test.
     */
    @Test
    public void whenGiveListOfArraysThanReturnListContainsAllElementsFromArrays() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{4, 5, 6, 7});
        list.add(new int[]{8, 9});
        List<Integer> result = new ConvertList().convert(list);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        assertThat(expected, is(result));
    }
}