package ru.job4j.orderbook;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

/**
 * The class Book describes a book of the orders.
 */
public class Book {

    /**
     * The name of the book.
     */
    private String name;

    /**
     * The Map of BID orders.
     */
    private Map<Float, Order> bidOrders = new TreeMap<>(new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o2.compareTo(o1);
        }
    });

    /**
     * The Map of ASK orders.
     */
    private Map<Float, Order> askOrders = new TreeMap<>();

    /**
     * Getter for the name field.
     * @return name of the book.
     */
    public String getName() {
        return name;
    }

    /**
     * A constructor.
     * @param name of the book.
     */
    public Book(String name) {
        this.name = name;
    }

    /**
     * Adds a BID order to the map.
     * @param order to be added.
     */
    public void addBidOrder(Order order) {
        aggregateOrder(this.bidOrders, order);
    }

    /**
     * Adds a ASK order to the map.
     * @param order to be added.
     */
    public void addAskOrder(Order order) {
        aggregateOrder(this.askOrders, order);
    }

    /**
     * Aggregates map's orders to the given one.
     * @param map to be processed.
     * @param order to be aggregated.
     */
    private void aggregateOrder(Map<Float, Order> map, Order order) {
        map.computeIfPresent(order.getPrice(), (key, value) -> {
            value.increaseVolume(order.getVolume());
            return value;
        });
        map.putIfAbsent(order.getPrice(), order);
    }

    /**
     * Matches bid to ask orders.
     */
    public void matchOrders() {
        for (Map.Entry<Float, Order> bidEntry : this.bidOrders.entrySet()) {
            for (Map.Entry<Float, Order> askEntry : this.askOrders.entrySet()) {
                if (bidEntry.getKey() < askEntry.getKey()) {
                    continue;
                } else if (bidEntry.getKey() > askEntry.getKey()) {
                    if (bidEntry.getValue().getVolume() > askEntry.getValue().getVolume()) {
                        bidEntry.getValue().increaseVolume(-askEntry.getValue().getVolume());
                        askEntry.getValue().increaseVolume(-askEntry.getValue().getVolume());
                        continue;
                    } else if (bidEntry.getValue().getVolume() < askEntry.getValue().getVolume()) {
                        askEntry.getValue().increaseVolume(-bidEntry.getValue().getVolume());
                        bidEntry.getValue().increaseVolume(-bidEntry.getValue().getVolume());
                        continue;
                    } else if (bidEntry.getValue().getVolume() == askEntry.getValue().getVolume()) {
                        bidEntry.getValue().increaseVolume(-askEntry.getValue().getVolume());
                        askEntry.getValue().increaseVolume(-bidEntry.getValue().getVolume());
                    }
                }
            }
        }
    }

    /**
     * Prints a book.
     */
    public void printBook() {
        Iterator<Order> askIterator = this.askOrders.values().iterator();
        Iterator<Order> bidIterator = this.bidOrders.values().iterator();
        System.out.printf("%s%s", "Order book: ", this.name);
        System.out.println();
        System.out.printf("%s%s%s", "  BID", "            ", "  ASK");
        System.out.println();
        System.out.printf("%s%s%s", "Volume@Price", " - ", "Volume@Price");
        System.out.println();
        while (askIterator.hasNext() && bidIterator.hasNext()) {
            StringBuilder string = new StringBuilder();
            string.append(bidIterator.next()).append(" - ").append(askIterator.next());
            System.out.println(string.toString());
        }
    }
}