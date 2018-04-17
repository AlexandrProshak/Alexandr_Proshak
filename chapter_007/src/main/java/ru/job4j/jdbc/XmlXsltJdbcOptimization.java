package ru.job4j.jdbc;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The class describes XML XSLT JDBC optimisation.
 */
public class XmlXsltJdbcOptimization {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(XmlXsltJdbcOptimization.class);

    /**
     * An amount of entries.
     */
    private final int n;

    /**
     * A user of the DB.
     */
    private final String user;

    /**
     * A password of user to the DB.
     */
    private final String password;

    /**
     * The ClassLoader for load resources.
     */
    private final ClassLoader classLoader;

    /**
     * A constructor.
     * @param n an amount of entries.
     * @param user of the DB.
     * @param password of user to the DB.
     */
    public XmlXsltJdbcOptimization(int n, String user, String password) {
        this.n = n;
        this.user = user;
        this.password = password;
        this.classLoader = getClass().getClassLoader();
    }

    /**
     * The method executes a sequence of steps according to the algorithm.
     */
    public void work() {
        long startTime = System.currentTimeMillis();
        try (Connection connection = this.getConnection()) {
            this.prepareTable(connection);
            this.fillTable(connection);
            this.marshalToXml(this.makeIntermediateCollection(connection));
            this.xsltTransform();
            //Out to System.err to order output
            System.err.printf("%s %s %s", "Sum of all elements =",
                    this.getSumUseParallelStream(), System.lineSeparator());
            // this.getSum(), System.lineSeparator());
            //Out to System.err to order output
            System.err.printf("%s %s millisecond %s", "Operating time =",
                    System.currentTimeMillis() - startTime, System.lineSeparator());
            LOG.info("work() -> has finished correctly");
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
        }
    }

    /**
     * The method sum of all elements from xml-file.
     * @return result.
     */
    private long getSum() {
        long result = 0L;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try (InputStream inputStream = this.classLoader.getResourceAsStream("2.xml")) {
            reader = factory.createXMLStreamReader(inputStream);
            int event;
            while (reader.hasNext()) {
                event = reader.getEventType();
                if (event == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals("entry")) {
                    result += Long.valueOf((reader.getAttributeValue(0)));
                }
                reader.next();
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        LOG.info("getSum() -> has finished correctly");
        return result;
    }

    /**
     * The method sum of all elements from xml-file use parallel stream.
     * @return result.
     */
    private long getSumUseParallelStream() {
        long result = 0L;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try (InputStream inputStream = this.classLoader.getResourceAsStream("2.xml")) {
            reader = factory.createXMLStreamReader(inputStream);
            int event;
            long[] array = new long[n];
            int index = 0;
            while (reader.hasNext()) {
                event = reader.getEventType();
                if (event == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals("entry")) {
                    array[index++] = Long.valueOf((reader.getAttributeValue(0)));
                }
                reader.next();
            }
            result = Arrays.stream(array).parallel().sum();
        } catch (XMLStreamException | IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        LOG.info("getSumUseParallelStream() -> has finished correctly");
        return result;
    }

    /**
     * The method transforms xml file to a needed representation.
     */
    private void xsltTransform() {
        String xmlFile = this.classLoader.getResource("1.xml").getFile();
        String xslPattern = this.classLoader.getResource("xslPattern.xml").getFile();
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Source xslt = new StreamSource(new File(xslPattern));
            Transformer transformer = factory.newTransformer(xslt);
            Source text = new StreamSource(new File(xmlFile));
            transformer.transform(text, new StreamResult(new File(
                    this.classLoader.getResource("2.xml").getFile())));
            LOG.info("xsltTransform() -> has finished correctly");
        } catch (TransformerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The method creates a connection to the DB.
     * @return connection.
     */
    private Connection getConnection() {
        Connection result = null;
        String connectionUrl = "jdbc:postgresql://localhost:5432/test";
        try {
            result = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
        }
        LOG.info("getConnection() -> has finished correctly");
        return result;
    }

    /**
     * The method prepares the table in DB to a correct state.
     * @param connection toDB.
     * @throws SQLException when connection is wrong.
     */
    private void prepareTable(Connection connection) throws SQLException {
        if (connection == null) {
            LOG.error("connection == null");
            throw new SQLException();
        }
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS test;");
            statement.execute("CREATE TABLE test (id SERIAL PRIMARY KEY, field INTEGER);");
            LOG.info("prepareTable() -> has finished correctly");
        } catch (SQLException e) {
            LOG.error(e.getSQLState(), e);
        }
    }

    /**
     * The method fills DB's table.
     * @param connection to DB.
     */
    private void fillTable(Connection connection) {
        String insertSQL = "INSERT INTO test(field) VALUES(?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= this.n; i++) {
                statement.setInt(1, i);
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();
            LOG.info("fillTable() -> has finished correctly");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    LOG.error(e1.getSQLState(), e1);
                }
            }
            LOG.error(e.getSQLState(), e);
        }
    }

    /**
     * The method puts entries from DB to a special collection.
     * @param connection ti DB.
     * @return collection of entries.
     */
    private Entries makeIntermediateCollection(Connection connection) {
        String selectSQL = "SELECT field FROM test";
        Entries result = new Entries();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            result.setEntries(new ArrayList<>(n));
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                int field = resultSet.getInt("field");
                Entry entry = new Entry();
                entry.setField(field);
                result.getEntries().add(entry);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                    LOG.info("connection.rollback()");

                }
            } catch (SQLException e1) {
                LOG.error(e1.getSQLState(), e1);
            }
            LOG.error(e.getSQLState(), e);
        }
        LOG.info("makeIntermediateCollection() -> has finished correctly");
        return result;
    }

    /**
     * The method marshals entries from the collection to a xml file.
     * @param entries collection to be marshaled.
     */
    private void marshalToXml(Entries entries) {
        try (FileWriter file = new FileWriter(this.classLoader.getResource("1.xml").getFile())) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, file);
            LOG.info("marshalToXml() -> has finished correctly");
        } catch (JAXBException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The inner nested class describes a simple entity.
     */
    @XmlRootElement
    static class Entry {

        /**
         * value.
         */
        private int field;

        /**
         * The setter for field.
         * @param field parameter.
         */
        @XmlElement
        public void setField(int field) {
            this.field = field;
        }

        /**
         * The getter for the field.
         * @return value.
         */
        public int getField() {
            return field;
        }
    }

    /**
     * The inner nested class describes storage for the entries,
     * uses the collection list as storage.
     */
    @XmlRootElement
    static class Entries {

        /**
         * The entries collection.
         */
        private List<Entry> entries = null;

        /**
         * The setter for the entries.
         * @param entries parameter.
         */
        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        /**
         * The getter for the entries.
         * @return value.
         */
        @XmlElement(name = "entry")
        public List<Entry> getEntries() {
            return entries;
        }
    }

}
