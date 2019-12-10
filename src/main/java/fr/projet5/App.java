package fr.projet5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
        try {
            Connection connection = DriverManager.getConnection("http://192.168.43.223/phpmyadmin/sql.php?server=1&db=projet5&table=football_team&pos=0&token=dd8e19cceb4659e5ced59a2caebbc38c", "hugo", "coding");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String request = "SELECT * FROM players_tennis";
        DriverManager.println(request);
        System.out.println(request);
    }
}