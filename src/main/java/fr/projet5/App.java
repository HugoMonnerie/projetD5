package fr.projet5;

import java.sql.*;

public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.43.223:3306/projet5", "hugo", "coding");
            String co = "Connected !";
            System.out.println(co);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}