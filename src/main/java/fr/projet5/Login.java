package fr.projet5;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Login {
    public static void login(String id, String mdp, JPanel pan, JFrame fen){
        try {
            Connection db = DriverManager.getConnection("jdbc:mysql://localhost:8080/projet5", id, mdp);
            //Connection db = DriverManager.getConnection("BDD", id, mdp);
            System.out.println("Connected !");
            pan.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panelChoice(fen,db));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
