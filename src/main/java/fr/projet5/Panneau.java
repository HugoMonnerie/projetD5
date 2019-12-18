package fr.projet5;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();

    public String getUtilisateur() {

        return utilisateur.getText();
    }

    public String getMdp() {

        return mdp.getText();
    }

    JPanel buildContentPane(JFrame fen){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");

        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        this.utilisateur = new JTextField();
        utilisateur.setColumns(10);

        this.mdp = new JPasswordField();
        mdp.setColumns(10);

        JButton bouton = new JButton("Connection");
        bouton.addActionListener(e -> {
            //your actions
            Login.login(getUtilisateur(), getMdp(),panel,fen);
        });

        JMenuBar menuBar = new JMenuBar();

        JMenu option1 = new JMenu("Paramètre");

        JMenuItem quitter = new JMenuItem("quitter");
        quitter.addActionListener(e -> {
            //your actions
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        JMenu option2 = new JMenu("Retour");
        option2.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            fen.setContentPane(buildContentPane2(fen));
        });

        JMenu option3 = new JMenu("?");

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
        fen.setJMenuBar(menuBar);

        menuBar.add(option1);

        option1.add(quitter);

        menuBar.add(option2);

        menuBar.add(option3);

        option3.add(aide);

        option3.add(question);

        return panel;
    }

    public JPanel buildContentPane2(JFrame fen){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Type de parie :</body></html>");

        JButton bouton1 = new JButton("Football");
        bouton1.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panneFoot(fen));
        });

        JButton bouton2 = new JButton("Tennis");
        bouton2.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.tennis(fen));
        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.hippique(fen));
        });

        //affichage

        panel.add(text1);

        panel.add(bouton1);

        panel.add(bouton2);

        panel.add(bouton3);

        panel.setVisible(true);

        return panel;
    }

    public JPanel panneFoot(JFrame fen)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Nom de l'équipe :</body></html>");

        JTextField nameOfTeam = new JTextField();
        nameOfTeam.setColumns(10);

        JButton buttonValid = new JButton("Valider");
        buttonValid.addActionListener(e -> {
            //your actions

        });

        //affichage

        panel.add(text1);

        panel.add(nameOfTeam);

        panel.add(buttonValid);

        panel.setVisible(true);

        return panel;
    }

    public JPanel tennis(JFrame fen) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Nom du joueur de tennis :</body></html>");

        JTextField jtennis = new JTextField();
        jtennis.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.addActionListener(e -> {
            //your actions

        });

        //affichage

        panel.add(text1);

        panel.add(jtennis);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }

    public JPanel hippique(JFrame fen) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Nom du cheval :</body></html>");

        JTextField cheval = new JTextField();
        cheval.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.addActionListener(e -> {
            //your actions

        });

        //affichage

        panel.add(text1);

        panel.add(cheval);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }
}