package fr.projet5;

import java.sql.*;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;

public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
        SQLDatabaseConnection sqlDatabaseConnection = new SQLDatabaseConnection();

        System.out.println("vv");
        String request = "SELECT * FROM players_tennis";
        println(request);
        System.out.println(request);
    }
}