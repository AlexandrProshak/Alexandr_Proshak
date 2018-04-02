package ru.job4j.jdbc;

/**
 * The class demonstrates XML->XSLT use JDBC.
 */
public class Runner {

    /**
     * The method main.
     * @param args args.
     */
    public static void main(String[] args) {
        XmlXsltJdbcOptimization optimizator = new XmlXsltJdbcOptimization(1000_000, "postgres", "password");
        optimizator.work();
    }
}
