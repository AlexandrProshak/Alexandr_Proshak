package ru.job4j.orderbook;

/**
 * The class runs parsing process.
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
