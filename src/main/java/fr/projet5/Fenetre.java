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

        //Le conteneur principal
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(300, 120));
        //On définit le layout manager
        content.setLayout(new GridBagLayout());
        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        this.setVisible(true);
    }



}