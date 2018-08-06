package ru.job4j.task3;

/**
 * The class demonstrates XML->XSLT use JDBC.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
