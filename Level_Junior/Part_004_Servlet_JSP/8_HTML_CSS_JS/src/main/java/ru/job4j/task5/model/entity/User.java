package ru.job4j.task5.model.entity;

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
     * The password of user.
     */
    private String password;

    /**
     * The email of user.
     */
    private String email;

    /**
     * The user role.
     */
    private Role role;

    /**
     * The date of user creating.
     */
    private Timestamp crateDate = new Timestamp(System.currentTimeMillis());

    /**
     * The user's country.
     */
    private String country;

    /**
     * The user's city.
     */
    private String city;

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

    /**
     * The password for role.
     * @return role.
     */
    public String getPassword() {
        return password;
    }

    /**
     * The setter for role.
     * @param password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The getter for role.
     * @return role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * The setter for role.
     * @param role to set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * The getter for country.
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * The setter for country.
     * @param country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * The getter for city.
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * The setter for city.
     * @param city to set.
     */
    public void setCity(String city) {
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
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email)
                && role == user.role
                && Objects.equals(country, user.country)
                && Objects.equals(city, user.city)
                && Objects.equals(crateDate, user.crateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, login, password, email, role, country, city, crateDate);
    }

    @Override
    public String toString() {
        return "user{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", role='" + role.toString() + '\''
                + ", crateDate=" + crateDate + '\''
                + ", country=" + country + '\''
                + ", city=" + city
                + '}'
                + System.lineSeparator();
    }
}
