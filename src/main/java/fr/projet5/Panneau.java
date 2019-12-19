package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Panneau extends JPanel {
    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();
    Properties properties = new Properties();
    private boolean rme = false;
    public String getUtilisateur() {

        return utilisateur.getText();
    }

    public String getMdp() {

        return mdp.getText();
    }

    JPanel buildContentPane(JFrame fen){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        properties.createFile();
        ArrayList data;
        data =  properties.readFile();
        rme = false;
        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");
        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        boolean empty = autoCo(data);

        JCheckBox check = new JCheckBox("remember me ?");
        check.addActionListener(e ->
                rme = true);

        JButton bouton = new JButton("Connection");
        bouton.addActionListener(e -> {
            //your actions
            if(rme)
            {
                if(empty)
                {
                    properties.removeAll();
                    properties.createFile();
                }
                properties.writeFile(getUtilisateur() + "\n" + getMdp());

            }
            Login.login(getUtilisateur(), getMdp(),panel,fen);
        });
        JMenuBar menuBar = new JMenuBar();

        JMenu option1 = new JMenu("Paramètre");

        JMenuItem quitter = new JMenuItem("quitter");
        quitter.addActionListener(e -> {
            //your actions
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        JButton option2 = new JButton("Retour");
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

        panel.add(check);

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
            fen.setContentPane(panneau.tennis());
        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.hippique());
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

        JLabel textf = new JLabel("<html><body>Nom de l'équipe :</body></html>");

        JTextField nameOfTeam = new JTextField();

        JButton buttonValid = new JButton("Valider");
        buttonValid.addActionListener(e -> {

            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.resultPanelFoot());
        });
        nameOfTeam.setColumns(30);
        //affichage

        panel.add(textf);

        panel.add(nameOfTeam);

        panel.add(buttonValid);

        panel.setVisible(true);

        return panel;

        }


    public JPanel tennis() {
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

    public JPanel hippique() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel texth = new JLabel("<html><body>Nom du cheval hippique :</body></html>");

        JTextField jhippique = new JTextField();
        jhippique.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.addActionListener(e -> {
            //your actions

        });

        //affichage

        panel.add(texth);

        panel.add(jhippique);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }

    public JPanel resultPanelFoot()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        return panel;
    }

    public boolean autoCo(ArrayList<String> data)
    {
        if(data.isEmpty())
        {
            this.utilisateur = new JTextField();
            utilisateur.setColumns(10);

            this.mdp = new JPasswordField();
            mdp.setColumns(10);
            return false;
        }
        else
        {
            this.utilisateur = new JTextField(data.get(0));
            utilisateur.setColumns(10);

            this.mdp = new JPasswordField(data.get(1));
            mdp.setColumns(10);
            return true;
        }
    }
}