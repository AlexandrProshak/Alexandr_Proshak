package ru.job4j.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Training.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SQLStorage {
    /**
     * Main.
     * @param args args.
     */
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String user = "postgres";
        String password = "password";

        String sql1 = "SELECT "
                + "cr.name AS \"car\", "
                + "en.name AS \"engine\", "
                + "tr.name AS \"transmission\", "
                + "gr.name AS \"gearbox\" "
                + "FROM cars AS cr\n"
                + "INNER JOIN engines AS en ON cr.engine_id = en.id\n"
                + "INNER JOIN transmissions AS tr ON cr.transmission_id = tr.id\n"
                + "INNER JOIN gearboxes AS gr ON cr.gearbox_id = gr.id";

        String sql = "SELECT en.name AS \"Unused parts\" FROM engines AS en\n"
                + "LEFT OUTER JOIN cars AS cr ON en.id = cr.engine_id\n"
                + "WHERE cr.id IS NULL\n"
                + "UNION\n"
                + "SELECT tr.name FROM transmissions AS tr\n"
                + "LEFT OUTER JOIN cars AS cr ON tr.id = cr.transmission_id\n"
                + "WHERE cr.id IS NULL\n"
                + "UNION\n"
                + "SELECT gr.name FROM gearboxes AS gr\n"
                + "LEFT OUTER JOIN cars AS cr ON gr.id = cr.gearbox_id\n"
                + "WHERE cr.id IS NULL";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql1);

            while (resultSet.next()) {
//                System.out.println(String.format("%s ", resultSet.getString("Unused parts")));
                System.out.println(String.format("%s | %s | %s | %s ",
                        resultSet.getString("car"),
                        resultSet.getString("engine"),
                        resultSet.getString("transmission"),
                        resultSet.getString("gearbox")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
