package ru.job4j.task2;

import java.util.HashMap;
import java.util.List;

/**
 * UserConvert.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserConvert {

    /**
     * The method converts list of users to the HashMap.
     * @param list to be converted.
     * @return result.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
