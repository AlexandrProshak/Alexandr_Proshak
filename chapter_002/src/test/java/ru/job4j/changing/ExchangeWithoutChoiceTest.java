package ru.job4j.changing;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ExchangeWithoutChoiceTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ExchangeWithoutChoiceTest {

    /**
     * An instance of ExchangeWithoutChoice class.
     */
    private static Exchangeable exchange;

    /**
     * Set up date.
     */
    @BeforeClass
    public static void setUp() {
        ExchangeWithoutChoiceTest.exchange = new ExchangeWithoutChoice();
    }

    /**
     * A Test for an exchanging an amount of MONEY without user choice.
     * 1.00 = 4x25.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenExchangeOneThenReturnFourTwentyFive() throws Exception {
        String expectedResult = "Your MONEY we exchanged by: \n - 4 pcs. of 25 coins \n";
        String result = ExchangeWithoutChoiceTest.exchange.exchange(1.00);
        assertThat(result, is(expectedResult));
    }

    /**
     * A Test for an exchanging an amount of MONEY without user choice.
     * 1.40 = 5x25 and 1x10 and 1x5.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenExchangeOnePointFourThenReturnFiveTwentyFiveOneTenOneFive() throws Exception {
        String expectedResult = "Your MONEY we exchanged by: \n"
                + " - 5 pcs. of 25 coins \n"
                + " - 1 pcs. of 10 coins \n"
                + " - 1 pcs. of 5 coins \n";
        String result = ExchangeWithoutChoiceTest.exchange.exchange(1.40);
        assertThat(result, is(expectedResult));
    }

    /**
     * A Test for an exchanging an amount of MONEY without user choice
     * when we can not exchange.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenCanNotExchangeThenReturnCanNotExchange() throws Exception {
        String expectedResult = "Sorry we can not exchange MONEY. Please take your MONEY back";
        String result = ExchangeWithoutChoiceTest.exchange.exchange(1.14);
        assertThat(result, is(expectedResult));
    }
}