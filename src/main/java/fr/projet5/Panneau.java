package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panneau extends JPanel {

    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();

    public String getUtilisateur() {

        return utilisateur.getText();
    }

    public String getMdp() {

        return mdp.getText();
    }

    JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");

        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        JTextField utilisateur = new JTextField();
        utilisateur.setColumns(10);

        this.mdp = new JPasswordField();
        mdp.setColumns(10);

        JButton bouton = new JButton("Connection");
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
        quitter.doClick(JFrame.EXIT_ON_CLOSE);

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

    public JPanel buildContentPane2(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Type de parie :</body></html>");

        JButton bouton1 = new JButton("Football");
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Login.login(getUtilisateur(), getMdp());
            }
        });

        JButton bouton2 = new JButton("Tennis");
        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Login.login(getUtilisateur(), getMdp());
            }
        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Login.login(getUtilisateur(), getMdp());
            }
        });

        //affichage

        panel.add(text1);

        panel.add(bouton1);

        panel.add(bouton2);

        panel.add(bouton3);

        return panel;
    }

}