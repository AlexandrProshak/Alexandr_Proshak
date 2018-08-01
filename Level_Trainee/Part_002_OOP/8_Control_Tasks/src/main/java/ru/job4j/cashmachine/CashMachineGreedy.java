package ru.job4j.cashmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CashMachineGreedy exchanges money without user choice.
 * It uses greedy algorithm.
 * It works with double format of input date.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CashMachineGreedy implements Exchangeable {

    /**
     * A set of coins for money exchange.
     */
    private final int[] money;

    /**
     * A constructor for greedy cash machine.
     * @param money a set of coins.
     */
    public CashMachineGreedy(int[] money) {
        this.money = money;
    }

    /**
     * A method is implemented from the interface.
     * @param amount is amount of money to exchange.
     * @return a list of result.
     */
    @Override
    public List<List<Integer>> exchange(int amount) throws UnsupportedOperationException {
        int length = money.length;
        double rest = amount;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (rest != 0 && rest > 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (rest >= money[i]) {
                    rest -= money[i];
                    list.add(money[i]);
                    rest = Math.rint(rest * 100) / 100;
                }
                if (!list.isEmpty()) {
                    result.add(list);
                }
            }
        }

        if (rest != 0.0 && rest > 0.001) {
            throw new UnsupportedOperationException("Sorry we can not exchange money. Please take your money back");
        } else {
            return result;
        }
    }
}