package ru.job4j.task1;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SortUser {

    /**
     * A method sort sorts users in a given list by age.
     * @param list of users to directSort.
     * @return TreeSet.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
