package ru.job4j.changing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class CashMachine saggeste .
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class CashMachine implements Exchangeable {
    /**
     * An array for coins set.
     */
    private final int[] values;

    /**
     * A constructor for CashMachine.
     * @param values setting a set of coins.
     */
    public CashMachine(final int[] values) {
        this.values = values;
    }

    @Override
    public List<List<Integer>> exchange(int amount) {
        return this.exchange(amount, 0);
    }

    /**
     * A recursion method calculating variants of exchanging ways.
     * @param note amount of money to exchange.
     * @param step iteration for coin.
     * @return list of result.
     */
    public List<List<Integer>> exchange(int note, int step) {
        List<List<Integer>> data = new ArrayList<>();
        for (int index = step; index != this.values.length; index++) {
            final int value = this.values[index];
            int rest = note - this.values[index];
            if (rest == 0) {
                data.add(new ArrayList<>(Collections.singleton(value)));
            } else if (rest > 0) {
                for (List<Integer> sub: this.exchange(rest, index)) {
                    sub.add(value);
                    data.add(sub);
                }
            } else {
                break;
            }
        }
        return data;
    }
}
