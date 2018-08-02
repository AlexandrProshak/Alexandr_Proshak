package ru.job4j.task2;

import ru.job4j.task1.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortUser.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SortUser {

    /**
     * A method sort sorts users in a given list by names length.
     * @param list of users to directSort.
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
                Integer o1Len = o1.getName().length();
                Integer o2Len = o2.getName().length();
                return o1Len.compareTo(o2Len);
            }
        });
        return list;
    }

    /**
     * A method sort sorts users in a given list by all fields.
     * @param list of users to directSort.
     * @return sorted list.
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            /**
             * A Comparator for class User by name length.
             * @param o1 user to compare.
             * @param o2 user to compare.
             * @return list of result.
             */
            @Override
            public int compare(User o1, User o2) {
                String o1Name = o1.getName();
                String o2Name = o2.getName();
                int compare = o1Name.compareTo(o2Name);
                if (compare == 0) {
                    Integer o1Age = o1.getAge();
                    Integer o2Age = o2.getAge();
                    return o1Age.compareTo(o2Age);
                } else {
                    return compare;
                }
            }
        });
        return list;
    }
}