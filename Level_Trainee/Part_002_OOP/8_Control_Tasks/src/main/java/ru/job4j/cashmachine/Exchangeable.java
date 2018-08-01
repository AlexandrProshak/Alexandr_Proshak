package ru.job4j.cashmachine;

import java.util.List;

/**
 * Interface Exchangeable provides exchange an amount of money.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public interface Exchangeable {

     /**
     * A method exchange money.
     * @param amount is an amount of money to exchange.
     * @return a result.
     */
    List<List<Integer>> exchange(int amount);
}
