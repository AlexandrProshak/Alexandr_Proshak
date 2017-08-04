package ru.job4j.collections.sort;

/**
 * Class User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {

    /**
     * A name of user.
     */
    private String name;
    /**
     * An age of uer.
     */
    private Integer age;

    /**
     * A constructor with parameters.
     * @param name of new user.
     * @param age of a new user.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * A getter for name's field.
     * @return a current user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter for age's field.
     * @return a current user's age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Equals for the class user.
     * @param o to equals.
     * @return result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        return age.equals(user.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    /**
     * A method compareTo of a class User.
     * @param o to compare.
     * @return result:
     *                 1 when this  > o;
     *                 0 when this == o;
     *                -1 when this  < o;
     */
    @Override
    public int compareTo(User o) {
        int result;
        if (this.age != null && o.age != null) {
            result = this.age.compareTo(o.age);
        } else {
            throw new UnsupportedOperationException("one field of age = null");
        }
        return result;
    }
}
