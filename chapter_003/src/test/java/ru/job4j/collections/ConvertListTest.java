package ru.job4j.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertListTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ConvertListTest {

    /**
     * A link for instance of a class ConvertList.
     */
    private ConvertList convert;
    /**
     * A link for an array.
     */
    private int[][] array;
    /**
     * A link for a list.
     */
    private List<Integer> list;

    /**
     * A preparation initial date.
     */
    @Before
    public void setUp() {
        convert = new ConvertList();
        array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
    }

    /**
     * Testing of a convert an array to list.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveArrayTakeBackList() throws Exception {
        List<Integer> result = convert.toList(array);
        List<Integer> expected = list;
        assertThat(expected, is(result));
    }

    /**
     * Testing of a convert a list to an array.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveListTakeBackArray() throws Exception {
        int[][] result = convert.toArray(list, 3);
        int[][] expected = array;
        assertThat(expected, is(result));
    }

    /**
     * Testing of a convert a list to an array with adding zero elements to the end.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveOddListTakeBackArrayWithZero() throws Exception {
        int[][] result = convert.toArray(list, 2);
        int[][] expected = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0}
        };
        assertThat(expected, is(result));
    }
}