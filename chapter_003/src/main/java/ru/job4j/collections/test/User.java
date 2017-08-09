package ru.job4j.collections.test;

/**
 * Class User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class User {

    /**
     * User name.
     */
    private String name;

    /**
     * User passport.
     */
    private String passport;

    /**
     * A constructor with parameters.
     * @param name of user.
     * @param passport is a serial and number of user's passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * A getter for the user name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter for the user's passport data.
     * @return a String line with serial and number.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Equals for the class User.
     * @param o instance of User to compare.
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
        return passport.equals(user.passport);
    }

    /**
     * HashCode for the class User.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }
}
