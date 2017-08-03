package ru.job4j.collections.generics;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {

    /**
     * A method converts a list of users to HashMap.
     * @param list of users.
     * @return a HashMap.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
