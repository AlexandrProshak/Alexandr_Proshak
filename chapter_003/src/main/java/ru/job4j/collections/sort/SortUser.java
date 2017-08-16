package ru.job4j.collections.sort;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;

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
     * @param list of users to directSort.
     * @return TreeSet.
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }

    /**
     * A method sorts user from the list by the user name length.
     * @param list to sort.
     * @return sorted list.
     */
    public List<User> sortNameLength(List<User> list) {

        Collections.sort(list, new Comparator<User>() {
            /**
             * A Comparator for class User by name length.
             * @param o1 user to compare.
             * @param o2 user to compare.
             * @return list of result.
             */
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                if (o1.getName().length() > o2.getName().length()) {
                    result = 1;
                }
                if (o1.getName().length() < o2.getName().length()) {
                    result = -1;
                }
                return result;
            }
        });
        return list;
    }

    /**
     * A method sorts user from the list by all fields.
     * @param list to sort.
     * @return sorted list.
     */
    public List<User> sortByAllFields(List<User> list) {

        SortUser sortUser = new SortUser();
        Collections.sort(sortUser.sortNameLength(list), new Comparator<User>() {
            /**
             * A comparator for class User by all fields.
             * @param o1 user to compare.
             * @param o2 user to compare.
             * @return list of result.
             */
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                if (o1.getName().length() == o2.getName().length()) {
                    if (o1.getAge() > o2.getAge()) {
                        result = 1;
                    }
                    if (o1.getAge() < o2.getAge()) {
                        result = -1;
                    }
                }
                return result;
            }
        });
        return list;
    }
}
