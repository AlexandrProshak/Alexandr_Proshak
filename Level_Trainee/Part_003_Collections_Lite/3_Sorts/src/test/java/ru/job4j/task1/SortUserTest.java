package ru.job4j.task1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortUserTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SortUserTest {

    /**
     * Testing a method sort.
     */
    @Test
    public void whenGiveListOfUserThanReturnTreeSetOfUserSortedByAge() {
        List<User> list = Arrays.asList(
                new User("Ivan", 20),
                new User("Anton", 35),
                new User("Yakov", 10));

        SortUser sort = new SortUser();

        List<User> sortedList = Arrays.asList(
                new User("Yakov", 10),
                new User("Ivan", 20),
                new User("Anton", 35));

        Set<User> expected = new TreeSet<>(sortedList);
        Set<User> result = sort.sort(list);

        assertThat(expected, is(result));
    }
}