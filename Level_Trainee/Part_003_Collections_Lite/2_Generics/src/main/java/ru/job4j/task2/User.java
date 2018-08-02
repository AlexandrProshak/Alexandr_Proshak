package ru.job4j.task2;

import java.util.Objects;

/**
 * User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class User {

    /**
     * The user's id.
     */
    private int id;

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's city.
     */
    private String city;

    /**
     * The getter.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * The Constructor.
     * @param id parameter.
     * @param name parameter.
     * @param city parameter.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
