package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * UserMap class.
 */
public class UserMap {

    /**
     * User class.
     */
    private static class User {

        /**
         * Name of user.
         */
        String name;

        /**
         * Amount of children.
         */
        int children;

        /**
         * Date of born.
         */
        Calendar birthday;

        /**
         * Constructor.
         *
         * @param name     name of user.
         * @param children amount of children.
         * @param birthday date of born.
         */
        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }

    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {
        User firstUser = new User("John", 2,  new GregorianCalendar(1896, Calendar.JULY, 14));
        User secondUser = new User("John", 2,  new GregorianCalendar(1896, Calendar.JULY, 14));

        Map<User, Object> map = new HashMap<>();

        map.put(firstUser, "first user value");
        map.put(secondUser, "second user value");

        System.out.println(map);
    }
}
