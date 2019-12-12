package fr.projet5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel {

    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();

    public String getUtilisateur() {
        return utilisateur.getText();
    }

    public String getMdp() {
        return mdp.getText();
    }
    
    public void paintComponent(Graphics g) {
        try {
            ImageIO.read(new File("src/main/resources/image.jpg"));
            ImageIO.read(new File("src/main/resources/image2.jpg"));
            //g.drawImage(img2, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.buildContentPane();
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");

        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        this.utilisateur = new JTextField();
        utilisateur.setColumns(10);

        this.mdp = new JTextField();
        mdp.setColumns(10);
        Login.login(getUtilisateur(), getMdp());
        JButton bouton = new JButton();

        bouton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
               Login.login(getUtilisateur(), getMdp());
            }
        });
        JMenuBar menuBar = new JMenuBar();

        JMenu option1 = new JMenu("Paramètre");

        JMenuItem quitter = new JMenuItem("quitter");

        JMenu option2 = new JMenu("?");

        JMenuItem aide = new JMenuItem("aide");

        JMenuItem question = new JMenuItem("question");

        //ajout des commandes

        //fenetre
        panel.add(text1);

        panel.add(utilisateur);

        panel.add(text2);

        panel.add(mdp);

        panel.add(bouton);
        
        //menu
        setJMenuBar(menuBar);

        menuBar.add(option1);

        option1.add(quitter);

        menuBar.add(option2);

        option2.add(aide);

        option2.add(question);

        return panel;
    }

    private void setJMenuBar(JMenuBar menuBar) {
    }

}