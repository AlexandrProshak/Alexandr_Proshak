package ru.job4j.collections.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    /**
     * A method sort sorts users in a given list by age.
     * @param list of users to sort.
     * @return TreeSet.
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }
}
