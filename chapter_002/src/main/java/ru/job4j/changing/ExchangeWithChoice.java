package ru.job4j.changing;

/**
 * Class ExchangeWithChoice gives variants of coin's sets which can be exchanged.
 * It works for 1, 2.
 * Denominations have to be given in double form.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ExchangeWithChoice implements Exchangeable {

    /**
     * The method is implemented from Exchangeable interface.
     *
     * @param amount a denomination for exchanging (double format).
     * @return a string of possible variants to exchange.
     */
    @Override
    public String exchange(double amount) {
        return null;
    }
}