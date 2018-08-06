package ru.job4j.task2;

import java.util.Objects;

/**
 * The class User describes a specific user for the current task.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class User {

    /**
     * User's id.
     */
    private int id;

    /**
     * User's money.
     */
    private int amount;

    /**
     * A constructor.
     * @param id user's id.
     * @param amount users' amount of money.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * The getter for the user's id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the user's id.
     * @param id user's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for the user's money.
     * @return amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * A setter for the users money.
     * @param amount amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
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
        return id == user.id && amount == user.amount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount);
    }
}
