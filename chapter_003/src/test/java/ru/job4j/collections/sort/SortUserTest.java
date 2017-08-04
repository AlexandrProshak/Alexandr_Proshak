package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

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

    /**
     * Testing a method sortNameLength.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveListOfUserThanReturnListOfUsersSortedByNameLength() throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 25));
        list.add(new User("Andrey", 10));
        list.add(new User("Nikolai", 11));
        list.add(new User("Bob", 10));

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(list);

        List<User> expected = new ArrayList<>();
        expected.add(new User("Bob", 10));
        expected.add(new User("Ivan", 25));
        expected.add(new User("Andrey", 10));
        expected.add(new User("Nikolai", 11));

        assertThat(result, is(expected));
    }

    /**
     * Testing a method sortByAllFields.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveListOfUserThanReturnListOfUsersSortedByAllFields() throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 25));
        list.add(new User("Andrey", 10));
        list.add(new User("Ivan", 10));
        list.add(new User("Andrey", 9));

        SortUser sortUser = new SortUser();

        List<User> result = sortUser.sortByAllFields(list);

        List<User> expected = new ArrayList<>();
        expected.add(new User("Ivan", 10));
        expected.add(new User("Ivan", 25));
        expected.add(new User("Andrey", 9));
        expected.add(new User("Andrey", 10));

        assertThat(result, is(expected));
    }
}