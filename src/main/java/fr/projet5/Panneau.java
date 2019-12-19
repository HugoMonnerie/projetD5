package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Panneau extends JPanel {
    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();
    Properties properties = new Properties();
    private boolean rme = false;

    JPanel panel = new JPanel();


    public String getUser() {
        panel.setBackground(Color.gray);


        return utilisateur.getText();
    }

    public String getPsw() {
        panel.setBackground(Color.gray);


        return mdp.getText();
    }

    JPanel menu(JFrame fen, Connection db){
        JMenuBar menuBar = new JMenuBar();
        panel.setBackground(Color.darkGray);


        JMenu option1 = new JMenu("Setting");

        JMenuItem quitter = new JMenuItem("logout");
        quitter.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            try {
                db.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            fen.setContentPane(panneau.panelConnection(fen));
            System.out.println("logout");
        });

        JMenuItem retour = new JMenuItem("back");
        retour.addActionListener(e -> {
            //your actions
            panel.setBackground(Color.gray);

            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panelChoice(fen, db));
            System.out.println("back");
        });
        panel.setBackground(Color.darkGray);

        JMenu option3 = new JMenu("?");

        JMenuItem aide = new JMenuItem("help");

        JMenuItem question = new JMenuItem("question");

        //affichage

        fen.setJMenuBar(menuBar);

        menuBar.add(option1);

        option1.add(retour);

        option1.add(quitter);

        menuBar.add(option3);

        option3.add(aide);

        option3.add(question);

        return panel;
    }

    JPanel panelConnection(JFrame fen){
        panel.setLayout(new FlowLayout());
        properties.createFile();
        ArrayList data;
        data = properties.readFile();
        rme = false;
        JLabel text1 = new JLabel("<html><body>user :</body></html>");
        JLabel text2 = new JLabel("<html><body>password :</body></html>");

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
                properties.writeFile(getUser() + "\n" + getPsw());

            }
            Login.login(getUser(), getPsw(),panel,fen);
        });

        //ajout des commandes

        //fenetre
        panel.add(text1);

        panel.add(utilisateur);

        panel.add(text2);

        panel.add(mdp);

        panel.add(check);

        panel.add(bouton);

        return panel;
    }

    public JPanel panelChoice(JFrame fen, Connection db){
        //JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Type de parie :</body></html>");

        JButton bouton1 = new JButton("Football");
        bouton1.addActionListener(e -> {
            panel.setBackground(Color.gray);

            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panneFoot(fen,db));
        });

        JButton bouton2 = new JButton("Tennis");
        bouton2.addActionListener(e -> {
            panel.setBackground(Color.gray);

            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.tennis(fen,db));
        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.addActionListener(e -> {
            panel.setBackground(Color.gray);

            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.hippique(fen,db));
        });

        menu(fen, db);

        //affichage

        panel.add(text1);

        panel.add(bouton1);

        panel.add(bouton2);

        panel.add(bouton3);

        panel.setVisible(true);

        return panel;
    }

    public JPanel panneFoot(JFrame fen, Connection db) {
        panel.setLayout(new FlowLayout());

        JLabel textf = new JLabel("<html><body>Nom de l'équipe :</body></html>");

        JTextField nameOfTeam = new JTextField();

        JButton buttonValid = new JButton("Valider");
        buttonValid.addActionListener(e -> {
            panel.setBackground(Color.gray);

            panel.setVisible(false);
            Panneau panneau = new Panneau();
            String teamName = nameOfTeam.getText();
            int index = 1;
            fen.setContentPane(panneau.result(db,teamName,index));
        });
        nameOfTeam.setColumns(30);

        menu(fen, db);

        //affichage

        panel.add(textf);

        panel.add(nameOfTeam);

        panel.add(buttonValid);

        panel.setVisible(true);

        return panel;

        }


    public JPanel tennis(JFrame fen, Connection db) {
        //JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Nom du joueur de tennis :</body></html>");

        JTextField jtennis = new JTextField();
        jtennis.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.addActionListener(e -> {
            //your actions
            panel.setBackground(Color.gray);

        });

        menu(fen, db);

        //affichage

        panel.add(text1);

        panel.add(jtennis);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }

    public JPanel hippique(JFrame fen, Connection db) {
        panel.setLayout(new FlowLayout());

        JLabel texth = new JLabel("<html><body>Nom du cheval hippique :</body></html>");

        JTextField jhippique = new JTextField();
        jhippique.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.addActionListener(e -> {
            panel.setBackground(Color.gray);

            //your actions

        });

        menu(fen, db);

        //affichage

        panel.add(texth);

        panel.add(jhippique);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }

    public JPanel result(Connection db, String name, int index)
    {
        panel.setLayout(new FlowLayout());
        SQLRequete sql = new SQLRequete();
        String res = sql.dispatch(db,name,index);
        System.out.println(res);
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