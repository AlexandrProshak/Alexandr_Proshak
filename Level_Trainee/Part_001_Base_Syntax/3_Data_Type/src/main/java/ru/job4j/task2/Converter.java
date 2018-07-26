package ru.job4j.task2;

/**
 * Converter.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Converter {

    /**
     * The exchange usd rate.
     */
    private static final double RUB_USD = 60.0;

    /**
     * The exchange euro rate.
     */
    private static final double RUB_EUR = 70.0;

    /**
     * Convert rub to euro.
     * @param value rub.
     * @return euro.
     */
    public double rubleToEuro(double value) {
        return value / RUB_EUR;
    }

    /**
     * Convert rub to usd.
     * @param value rub.
     * @return usd.
     */
    public double rubleToDollar(double value) {
        return value / RUB_USD;
    }

    /**
     * Convert euro to rub.
     * @param value euro.
     * @return rub.
     */
    public double euroToRuble(double value) {
        return value * RUB_EUR;
    }

    /**
     * Convert usd to rub.
     * @param value usd.
     * @return rub.
     */
    public double dollarToRuble(double value) {
        return value * RUB_USD;
    }
}
