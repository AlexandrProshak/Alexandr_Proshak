package ru.job4j.task1;


import java.util.Objects;

/**
 * User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class User implements Comparable<User> {

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's age.
     */
    private int age;

    /**
     * The getter.
     *
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * The getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The Constructor.
     *
     * @param name parameter.
     * @param age   parameter.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * A method compareTo of a class User.
     * @param that to compare.
     * @return result:
     *                 1 when this  > that;
     *                 0 when this == that;
     *                -1 when this  < that;
     */
    @Override
    public int compareTo(User that) {
        try {
            if (this.age == that.age) {
                return 0;
            } else {
                return this.age > that.age ? 1 : -1;
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}