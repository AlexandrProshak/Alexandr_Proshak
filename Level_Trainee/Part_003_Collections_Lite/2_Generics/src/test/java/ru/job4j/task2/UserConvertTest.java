package ru.job4j.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserConvertTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserConvertTest {

    /**
     * Test.
     */
    @Test
    public void whenListOfUsersThenHashMapOfUsers() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        User first = new User(1, "Bob", "Omaha");
        User second = new User(2, "Mike", "LA");
        User three = new User(3, "Kate", "NY");
        list.add(first);
        list.add(second);
        list.add(three);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(first.getId(), first);
        expected.put(second.getId(), second);
        expected.put(three.getId(), three);
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result, is(expected));
    }
}