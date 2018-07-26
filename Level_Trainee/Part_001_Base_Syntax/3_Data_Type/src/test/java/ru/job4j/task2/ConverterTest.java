package ru.job4j.task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ConverterTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ConverterTest {

    /**
     * Test for convert rub to euro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70.0);
        double expRes = 1.0;
        assertEquals(expRes, result, 0.1);
    }

    /**
     * Test for convert rub to usd.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(60.0);
        double expRes = 1.0;
        assertEquals(expRes, result, 0.1);
    }

    /**
     * Test for convert euro to rub.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1.0);
        double expRes = 70.0;
        assertEquals(expRes, result, 0.1);
    }

    /**
     * Test for convert usd to rub.
     */
    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(1.0);
        double expRes = 60.0;
        assertEquals(expRes, result, 0.1);
    }
}