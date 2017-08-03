package ru.job4j.collections.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserConvertTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {

    /**
     * Testing a method convert list of users to HashMap.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenGiveListOfUsersThanGiveBackHashMap() throws Exception {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        UserConvert convert = new UserConvert();
        Map<Integer, User> result = convert.process(list);
        Map<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        expected.put(3, user3);
        assertThat(expected, is(result));
    }
}