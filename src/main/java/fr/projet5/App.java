package fr.projet5;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
        ResultSet resultSet = null;

        try {
            String connectionUrl =
                    "jdbc:mysql://192.168.43.223:3306/projet5";
            Connection connection = DriverManager.getConnection(connectionUrl, "hugo", "coding");
            String co = "Connected !";
            String insertSql = "SELECT * FROM `matchs_tennis`";
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS); {

                prepsInsertProduct.execute();
                // Retrieve the generated key from the insert.
                resultSet = prepsInsertProduct.getGeneratedKeys();

                // Print the ID of the inserted row.
                while (resultSet.next()) {
                    System.out.println("Generated: " + resultSet.getString(1));
                }
            System.out.println(co);
        }
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}