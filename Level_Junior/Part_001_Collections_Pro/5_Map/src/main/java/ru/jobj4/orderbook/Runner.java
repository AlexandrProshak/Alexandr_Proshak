package ru.jobj4.orderbook;

/**
 * The class runs parsing process.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Runner {
    /**
     * Main.
     * @param args args.
     */
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.start("D:/Java/orders.xml");
        engine.printBook();
    }
}
