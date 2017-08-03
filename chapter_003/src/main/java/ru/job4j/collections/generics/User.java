package ru.job4j.collections.generics;

/**
 * Class User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class User {

    /**
     * User's id.
     */
    private int id;
    /**
     * User's name.
     */
    private String name;
    /**
     * User's city.
     */
    private String city;
    /**
     * Id generator.
     */
    private static int generateId = 1;

    /**
     * A constructor without parameters.
     */
    public User() {
        this.id = generateId++;
    }

    /**
     * A constructor with parameters.
     * @param name name of user.
     * @param city city of user.
     */
    public User(String name, String city) {
        this.id = generateId++;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter for id.
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Equals for User.
     * @param o user to compare.
     * @return true if users is same.
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

        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return city != null ? city.equals(user.city) : user.city == null;
    }

    /**
     * HashCode for User.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
