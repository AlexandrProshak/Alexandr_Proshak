package ru.job4j.changing;

/**
 * Interface Exchangeable provides exchange an amount of MONEY.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public interface Exchangeable {

    /**
     * A nominal of coin - 1.
     */
    double ONE = 0.01;

    /**
     * A nominal of coin - 5.
     */
    double FIVE = 0.05;

    /**
     * A nominal of coin - 10.
     */
    double TEN = 0.10;

    /**
     * A nominal of coin - 25.
     */
    double TWENTY_FIVE = 0.25;

    /**
     * A nominal of coin - 50.
     */
    double FIFTY = 0.50;

    /**
     * A coefficient for correct displaying a nominal of coins.
     */
    int DECIMAL_PLACE = 100;

    /**
     * An array of coins for exchange.
     */
    double[] MONEY = new double[] {TWENTY_FIVE, TEN, FIVE};

    /**
     * A method exchange MONEY.
     * @param amount is an amount of MONEY to exchange.
     * @return a result.
     */
    String exchange(double amount);
}
