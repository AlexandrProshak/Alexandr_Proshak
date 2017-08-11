package ru.job4j.collections.test;

/**
 * Class Account.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Account {

    /**
     * A type of money.
     */
    private String currency;

    /**
     * An amount of money.
     */
    private double value;

    /**
     * Account's requisites.
     */
    private String requisites;

    /**
     * A constructor.
     * @param currency type of money.
     * @param value amount of money.
     * @param requisites newAccount's requisites.
     */
    public Account(String currency, double value, String requisites) {
        this.currency = currency;
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * A getter for the currency.
     * @return currency.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * A getter for the newAccount's value.
     * @return an amount of money.
     */
    public double getValue() {
        return value;
    }

    /**
     * A setter for the value.
     * @param value to set.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * A getter for the newAccount's requisites.
     * @return newAccount's requisites.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * A setter for the field of requisites of an newAccount.
     * @param requisites requisites.
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * A method increases the field value.
     * @param value to increase.
     */
    public void increaseValue(double value) {
        this.value += value;
    }

    /**
     * Equals for the class Account.
     * @param o to compare.
     * @return true if instances are equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (!currency.equals(account.currency)) {
            return false;
        }
        return requisites.equals(account.requisites);
    }

    /**
     * HashCode for the class Account.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + requisites.hashCode();
        return result;
    }
}
