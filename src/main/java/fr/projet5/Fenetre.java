package fr.projet5;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("MySQL");
        this.setSize(1100, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panneau panneau = new Panneau();
        Fenetre fen = this;
        this.setContentPane(panneau.buildContentPane(fen));
        /*while (Login.co == true){
            this.setContentPane(panneau.buildContentPane2());
            System.out.println("fgchvj");
        }
         */

        this.setVisible(true);
    }



}