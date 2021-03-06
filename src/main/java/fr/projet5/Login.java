package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.awt.Color.black;

public abstract class Login {

    public static void login(String id, String mdp, JPanel pan, JFrame fen){
        try {


            Connection db = DriverManager.getConnection("jdbc:mysql://192.168.43.223:3306/projet5", id, mdp);
            System.out.println("Connected !");

            class AfficheImage extends JPanel
            {

                Image eau;

                AfficheImage(String s)
                {
                    eau = getToolkit().getImage(s);
                }

                public void paintComponent(Graphics g)
                {

                    super.paintComponent(g);
                    g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
                }

            }
            fen.setContentPane(pan);
            fen.setBackground(new Color(32, 32, 32));

            new AfficheImage("/Users/souksou/Desktop/projet 5/projetD5/src/main/resources/giphy.gif");
            pan.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panelChoice(fen,db));




        } catch (SQLException e) {
            e.printStackTrace();
            fen.setBackground(new Color(255, 0, 4));
            System.out.println("error");
        }
    }
}
