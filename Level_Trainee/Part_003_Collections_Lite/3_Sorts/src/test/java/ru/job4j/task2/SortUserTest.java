package ru.job4j.task2;

import org.junit.Test;
import ru.job4j.task1.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortUserTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SortUserTest {

    /**
     * Testing a method sortNameLength.
     */
    @Test
    public void whenGiveListOfUserThanReturnListOfUsersSortedByNameLength() {
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
     */
    @Test
    public void whenGiveListOfUserThanReturnListOfUsersSortedByAllFields() {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 25));
        list.add(new User("Andrey", 10));
        list.add(new User("Ivan", 10));
        list.add(new User("Andrey", 9));

        SortUser sortUser = new SortUser();

        List<User> result = sortUser.sortByAllFields(list);

        List<User> expected = new ArrayList<>();
        expected.add(new User("Andrey", 9));
        expected.add(new User("Andrey", 10));
        expected.add(new User("Ivan", 10));
        expected.add(new User("Ivan", 25));

        assertThat(result, is(expected));
    }
}