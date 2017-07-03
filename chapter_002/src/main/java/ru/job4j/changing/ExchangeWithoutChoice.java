package ru.job4j.changing;

/**
 * Class ExchangeWithoutChoice exchanges MONEY without user choice how.
 * It works with double format of input date.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ExchangeWithoutChoice implements Exchangeable {

    /**
     * A method is implemented from the interface.
     * @param amount is amount of MONEY to exchange.
     * @return a string of result.
     */
    @Override
    public String exchange(double amount) {

        String result = "Your MONEY we exchanged by: \n";
        int length = MONEY.length;
        int[] count = new int[length];

        for (int i = 0; i < length; i++) {
            if (amount != 0) {
                while (amount >= MONEY[i]) {
                    count[i]++;
                    amount -= MONEY[i];
                    amount = Math.rint(amount * 100) / 100;
                }
            }
        }
                if (amount != 0.0 && amount > 0.001) {
            result = "Sorry we can not exchange MONEY. Please take your MONEY back";
        } else {
            for (int i = 0; i < length; i++) {
                if (count[i] != 0) {
                    result = String.format("%s - %s pcs. of %s coins %s", result, count[i], (int) (MONEY[i] * DECIMAL_PLACE), "\n");
                }
            }
        }
        return result;
    }
}

