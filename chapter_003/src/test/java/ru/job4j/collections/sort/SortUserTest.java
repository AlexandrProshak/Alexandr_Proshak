package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {

    /**
     * Testing a method sort.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveListOfUserThanReturnTreeSetOfUserSortedByAge() throws Exception {
        List<User> list = Arrays.asList(
                new User("Ivan", 20),
                new User("Anton", 35),
                new User("Jakov", 10));

        SortUser sort = new SortUser();

        List<User> sortedList = Arrays.asList(
                new User("Jakov", 10),
                new User("Ivan", 20),
                new User("Anton", 35));

        Set<User> expected = new TreeSet<>(sortedList);
        Set<User> result = sort.sort(list);

        assertThat(expected, is(result));
    }
}