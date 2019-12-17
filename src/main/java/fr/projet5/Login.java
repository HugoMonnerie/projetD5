package fr.projet5;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Login {
    public static void login(String id, String mdp, JPanel pan, JFrame fen){
        try {
            DriverManager.getConnection("jdbc:mysql://192.168.43.223:3306/projet5", id, mdp);
            System.out.println("Connected !");
            pan.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.buildContentPane2(fen));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
