package fr.projet5;

import java.sql.*;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;

public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
<<<<<<< Updated upstream
        SQLDatabaseConnection sqlDatabaseConnection = new SQLDatabaseConnection();

        System.out.println("vv");
        String request = "SELECT * FROM players_tennis";
        println(request);
        System.out.println(request);
=======
        try {
            //Connection connection = DriverManager.getConnection("http://192.168.43.223/phpmyadmin/db_sql.php?db=projet5&token=d8749404669901bdeef42e668374d285", "hugo", "coding");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.43.223:3306/projet5", "hugo", "coding");
            String co = "Connected !";
            System.out.println(co);
        } catch (SQLException e) {
            e.printStackTrace();
        }
>>>>>>> Stashed changes
    }
}