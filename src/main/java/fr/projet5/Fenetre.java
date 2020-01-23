package fr.projet5;

import javax.swing.*;
import java.awt.*;


public class Fenetre extends JFrame {

    public Fenetre(){
        {
            this.setTitle("MySQL");
            this.setSize(1100, 600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanneauRequet panneauRequet = new PanneauRequet();
            setContentPane(new AfficheImage("../projetD5/src/main/resources/giphy.gif"));
            getContentPane().setLayout(new BorderLayout());
            this.setVisible(true);
            Fenetre fen = this;
            this.setContentPane(panneauRequet.panelConnection(fen));
        }
        //Le conteneur principal
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(300, 120));
        //On définit le layout manager
        content.setLayout(new GridBagLayout());
        content.setForeground(new Color(0, 0, 0));
        //L'objet servant à positionner les composants
        new GridBagConstraints();

        this.setVisible(true);
        }

        static class AfficheImage extends JPanel
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

        static class affichage
        {
            public static void main(String[] args)
            {
                 Fenetre test = new Fenetre();
            }
        }
}
