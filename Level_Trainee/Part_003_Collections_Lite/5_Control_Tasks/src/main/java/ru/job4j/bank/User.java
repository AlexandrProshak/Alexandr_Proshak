package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class User.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
     * An empty list of account, creates by default.
     */
    private List<Account> userAccountList = new ArrayList<>();

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
     * A getter for the list of user's accounts.
     * @return a list of user's accounts.
     */
    public List<Account> getUserAccountList() {
        return userAccountList;
    }

    /**
     * A method adds account to the user's list of accounts.
     * @param account to add.
     */
    public void addUserAccounts(Account account) {
        this.userAccountList.add(account);
    }

    /**
     * A method removes an account from the user's list of accounts.
     * @param account to remove.
     * @return true if an operation was done.
     */
    public boolean removeAccountFromList(Account account) {
        boolean result = false;
        if (account != null) {
            if (this.userAccountList.contains(account)) {
                this.userAccountList.remove(account);
                result = true;
            }
        }
        return result;
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
