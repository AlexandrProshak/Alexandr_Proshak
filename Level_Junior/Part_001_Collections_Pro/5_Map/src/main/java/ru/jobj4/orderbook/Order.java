package ru.jobj4.orderbook;

/**
 * The class order describes an order.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Order {

    /**
     * A name of the current order book.
     */
    private String book;

    /**
     * A type of the order operation.
     */
    private Operation type;

    /**
     * A price of the operation unit.
     */
    private float price;

    /**
     * There is an amount of the order operation.
     */
    private int volume;

    /**
     * There is an order id.
     */
    private int id;

    /**
     * Getter of the book name field.
     * @return book name.
     */
    public String getBook() {
        return book;
    }

    /**
     * Getter of the order operation field.
     * @return operation type.
     */
    public Operation getType() {
        return type;
    }

    /**
     * Getter of the order volume field.
     * @return volume of the order.
     */
    public int getVolume() {
        return volume;
    }

    /**
    /* Getter of the order price field.
     * @return price of the order.
     */
    public float getPrice() {
        return price;
    }

    /**
     /* Getter of the order id field.
     * @return id of the order.
     */
    public int getId() {
        return id;
    }

    /**
     * A constructor.
     * @param book name of the current order book.
     * @param type of the order operation.
     * @param price of the operation unit.
     * @param volume is an amount of the order operation.
     * @param id is order id.
     */
    public Order(String book, Operation type, float price, int volume, int id) {
        this.book = book;
        this.type = type;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     * Increase volume of a order.
     * @param newVolume volume to be added to the current order.
     */
    public void increaseVolume(int newVolume) {
        this.volume += newVolume;
    }
    @Override
    public String toString() {
        return String.format("%d%s%s", this.volume, "@", this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;

        if (Float.compare(order.price, price) != 0) {
            return false;
        }
        if (volume != order.volume) {
            return false;
        }
        if (id != order.id) {
            return false;
        }
        if (book != null ? !book.equals(order.book) : order.book != null) {
            return false;
        }
        return type == order.type;
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + volume;
        result = 31 * result + id;
        return result;
    }
}
