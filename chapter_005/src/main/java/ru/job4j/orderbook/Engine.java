package ru.job4j.orderbook;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class describes processing of xml file.
 */
public class Engine {

    /**
     * The storage for the unsorted by operation order.
     */
    private Map<Integer, Order> storage = new TreeMap<>();

    /**
     * The map of books.
     */
    private Map<String, Book> books = new TreeMap<>();

    /**
     * Starts process.
     * @param fileName of XML file.
     */
    public void start(String fileName) {
        parsingFile(fileName);
        decomposeByBook();
        matchingOrdersByBook();
    }

    /**
     * Parsing a XML file use stream.
     * @param fileName to be parse.
     */
    private void parsingFile(String fileName) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader;
        try (InputStream inputStream = new FileInputStream(fileName)) {
            streamReader = inputFactory.createXMLStreamReader(inputStream);
            while (streamReader.hasNext()) {
                streamReader.next();
                if (streamReader.isStartElement()) {
                    process(streamReader);
                }
                streamReader.close();
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Processing file by tags.
     * @param streamReader the next parse event in XML file.
     */
    private void process(XMLStreamReader streamReader) {
        if ("AddOrder".equalsIgnoreCase(streamReader.getLocalName())) {
            addOrderToStorage(streamReader);
        }
        if ("DeleteOrder".equalsIgnoreCase(streamReader.getLocalName())) {
            deleteOrderFromStorage(streamReader);
        }
    }

    /**
     * Adds order to the unsorted map.
     * @param streamReader the next parse event in XML file.
     */
    private void addOrderToStorage(XMLStreamReader streamReader) {
        String book = streamReader.getAttributeValue(0);
        Operation operation = Operation.valueOf(streamReader.getAttributeValue(1));
        float price = Float.valueOf(streamReader.getAttributeValue(2));
        int value = Integer.valueOf(streamReader.getAttributeValue(3));
        int id = Integer.valueOf(streamReader.getAttributeValue(4));
        Order order = new Order(book, operation, price, value, id);
        this.storage.put(id, order);
    }

    /**
     * Removes the order from the unsorted map by id.
     * @param streamReader the next parse event in XML file.
     */
    private void deleteOrderFromStorage(XMLStreamReader streamReader) {
        this.storage.remove(Integer.valueOf(streamReader.getAttributeValue(1)));
    }

    /**
     * Decomposing order into books.
     */
    public void decomposeByBook() {
        for (Map.Entry<Integer, Order> entry: this.storage.entrySet()) {
            Order currentOrder = entry.getValue();
            Operation currentOrderType = currentOrder.getType();
            String bookName = currentOrder.getBook();
            if (this.books.containsKey(bookName)) {
                if (currentOrderType.equals(Operation.BUY)) {
                    this.books.get(bookName).addBidOrder(currentOrder);
                } else {
                    this.books.get(bookName).addAskOrder(currentOrder);
                }
            } else {
                Book newBook = new Book(bookName);
                if (currentOrderType.equals(Operation.BUY)) {
                    newBook.addBidOrder(currentOrder);
                } else {
                    newBook.addAskOrder(currentOrder);
                }
                this.books.put(bookName, newBook);
            }
        }
        this.storage = null;
    }

    /**
     * Matching all orders from the all books from the collection.
     */
    public void matchingOrdersByBook() {
        for (Map.Entry<String, Book> entry : this.books.entrySet()) {
            entry.getValue().matchOrders();
        }
    }

    /**
     * Prints all books from the collection.
     */
    public void printBook() {
        for (Map.Entry<String, Book> entry : this.books.entrySet()) {
            entry.getValue().printBook();
        }
    }
}