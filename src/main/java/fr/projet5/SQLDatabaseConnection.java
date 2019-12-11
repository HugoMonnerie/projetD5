package fr.projet5;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class SQLDatabaseConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws SQLException {
        String connectionUrl =
                "jdbc:sqlserver://http://192.168.43.223/:3306;projet5=AdventureWorks;" +
                        "user=houssam" +
                        "password=coding";

        String selectSql = "SELECT * FROM `football_player` ";

        ResultSet resultSet = null;

        Connection connection = getConnection(connectionUrl);
        try {
             PreparedStatement prepsInsertProduct;
            prepsInsertProduct = connection.prepareStatement(selectSql, Statement.RETURN_GENERATED_KEYS); {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
    }
}
}
