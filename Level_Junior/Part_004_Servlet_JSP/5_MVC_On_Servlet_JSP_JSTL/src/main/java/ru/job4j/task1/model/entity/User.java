package ru.job4j.task1.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * The class user describes a user entity.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class User {

    /**
     * The id of user.
     */
    private int id;

    /**
     * The name of user.
     */
    private String name;

    /**
     * The login of user.
     */
    private String login;

    /**
     * The email of user.
     */
    private String email;

    /**
     * The date of user creating.
     */
    private Timestamp crateDate = new Timestamp(System.currentTimeMillis());

    /**
     *  The getter for id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * The setter for id.
     * @param id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter for name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for name.
     * @param name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter for login.
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * The setter for login.
     * @param login to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * The getter for email.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * The setter for email.
     * @param email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The getter for date.
     * @return crateDate.
     */
    public Timestamp getCrateDate() {
        return crateDate;
    }

    /**
     * The setter for date.
     * @param crateDate to set.
     */
    public void setCrateDate(Timestamp crateDate) {
        this.crateDate = crateDate;
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
                && Objects.equals(login, user.login)
                && Objects.equals(email, user.email)
                && Objects.equals(crateDate, user.crateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, crateDate);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", crateDate=" + crateDate
                + '}'
                + System.lineSeparator();
    }
}