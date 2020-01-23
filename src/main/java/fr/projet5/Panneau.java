package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Panneau extends JPanel {
    JTextField utilisateur = new JTextField();
    JTextField mdp = new JTextField();
    Properties properties = new Properties();
    private boolean rme = false;

    JPanel panel = new JPanel();


    public String getUser() {

        return utilisateur.getText();
    }

    public String getPsw() {


        return mdp.getText();
    }

    JPanel menu(JFrame fen, Connection db){
        JMenuBar menuBar = new JMenuBar();


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

            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.panelChoice(fen, db));
            System.out.println("back");
        });


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

        panel.setForeground(new Color(255, 213, 0));

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

        JButton bouton = new JButton("connection");
        bouton.setForeground(Color.green);
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
        bouton1.setForeground(Color.green);
        bouton1.addActionListener(e -> {

            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.foot(fen,db));
        });

        JButton bouton2 = new JButton("Tennis");
        bouton2.setForeground(new Color(255, 213, 0));
        bouton2.addActionListener(e -> {

            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.tennis(fen,db));
        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.setForeground(new Color(97, 40, 0));
        bouton3.addActionListener(e -> {

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

    public JPanel foot(JFrame fen, Connection db) {

        fen.setSize(1100, 600);
        JLabel textf = new JLabel("<html><body>Nom de l'équipe :</body></html>");
        textf.setForeground(new Color(69, 255, 0));

        panel.setLayout(new FlowLayout());
        JTextField nameOfTeam = new JTextField();
        nameOfTeam.setColumns(10);

        JButton buttonValid = new JButton("Valider");
        buttonValid.setForeground(new Color(69, 255, 0));
        buttonValid.addActionListener(e -> {
            panel.setForeground(new Color(8, 145, 0));

            panel.setVisible(false);
            Panneau panneau = new Panneau();

            String teamName = nameOfTeam.getText();
            fen.setContentPane(panneau.resultFoot(db,teamName));
        });

        menu(fen, db);

        //affichage

        panel.add(textf);

        panel.add(nameOfTeam);

        panel.add(buttonValid);

        panel.setVisible(true);

        return panel;

        }


    public JPanel tennis(JFrame fen, Connection db) {
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Nom du joueur de tennis :</body></html>");
        text1.setForeground(new Color(184, 175, 0));

        JTextField jtennis = new JTextField();
        jtennis.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.setForeground(new Color(184, 175, 0));
        bouton.addActionListener(e -> {
            //your actions

            panel.setVisible(false);
            Panneau panneau = new Panneau();

            String tennisName = jtennis.getText();
            fen.setContentPane(panneau.resultTennis(db,tennisName));

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
        texth.setForeground(new Color(125, 42, 0));


        JTextField jhippique = new JTextField();
        jhippique.setColumns(10);

        JButton bouton = new JButton("Valider");
        bouton.setForeground(new Color(97, 40, 0));

        bouton.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();

            String nameHorse = jhippique.getText();
            fen.setContentPane(panneau.resultHippique(db,nameHorse));

        });

        menu(fen, db);

        //affichage

        panel.add(texth);

        panel.add(jhippique);

        panel.add(bouton);

        panel.setVisible(true);

        return panel;
    }

    public JPanel resultFoot(Connection db, String teamName)
    {
        String[] headerTF = {"nom de l'equipe", "date creation", "site", "nb titulaire", "nb players"};
        ModeleStatic modelTF = new ModeleStatic(headerTF);
        TableTeamFoot TF;
        ArrayList<String> team = new ArrayList<String>();

        SQLRequete requestsSQLTF = new SQLRequete();
        JPanel panelTabTF = new JPanel();

        panel.setLayout(new FlowLayout());
        
        List<String> valuesTF;
        try {
            valuesTF = requestsSQLTF.requeteTeamFoot(db, teamName);
            System.out.println(valuesTF);
            if (!valuesTF.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesTF) {
                    team.add(infoArrive);
                    i++;
                    if (i == headerTF.length) {
                        modelTF.addInformation(new TableTeamFoot(team.get(0), team.get(1), team.get(2), team.get(3), team.get(4)));
                        team.clear();
                        i = 0;
                    }
                }

            }
            else { TF = new TableTeamFoot("", "", "", "", "");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabTF.setLayout(new BorderLayout());
        JTable tableauTF = new JTable(modelTF);
        panelTabTF.add(new JScrollPane(tableauTF), BorderLayout.CENTER);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] headerPF = {"nom du joueur", "age du joueur", "titulaire"};
        ModeleStatic modelPF = new ModeleStatic(headerPF);
        TablePlayerFoot PF;
        ArrayList<String> teamPlayers = new ArrayList<String>();

        SQLRequete requestsSQLPF = new SQLRequete();
        JPanel panelTabPF = new JPanel();

        panel.setLayout(new FlowLayout());

        List<String> valuesPF;
        try {
            valuesPF = requestsSQLPF.requetePlayerFoot(db, teamName);
            if (!valuesPF.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesPF) {
                    teamPlayers.add(infoArrive);
                    i++;
                    if (i == headerPF.length) {
                        modelPF.addInformation(new TablePlayerFoot(teamPlayers.get(0), teamPlayers.get(1), teamPlayers.get(2)));
                        teamPlayers.clear();
                        i = 0;
                    }
                }

            }
            else { PF = new TablePlayerFoot(" ", " ", "");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabPF.setLayout(new BorderLayout());
        JTable tableauPF = new JTable(modelPF);
        panelTabPF.add(new JScrollPane(tableauPF), BorderLayout.CENTER);
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] headerMF = {"nb_win_inside", "nb_win_outside", "nb_team_fight", "team_max_but_win", "team_max_but_loose"};
        ModeleStatic modelMF = new ModeleStatic(headerMF);
        TableMatchFoot MF;
        ArrayList<String> matchTeam = new ArrayList<String>();

        JPanel panelTabMF = new JPanel();
        panel.setLayout(new FlowLayout());

        List<String> valuesMF=new ArrayList<>();
        try {
            valuesMF = new SQLRequete().requeteMatchFoot(db, teamName);
            System.out.println(valuesMF);
            if (!valuesMF.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesMF) {
                    matchTeam.add(infoArrive);
                    i++;
                    if (i == headerMF.length) {
                        modelMF.addInformation(new TableMatchFoot(matchTeam.get(0), matchTeam.get(1), matchTeam.get(2), matchTeam.get(3), matchTeam.get(4)));
                        teamPlayers.clear();
                        i = 0;
                    }
                }

            }
            else { MF = new TableMatchFoot(" ", " ", " ", " "," ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabMF.setLayout(new BorderLayout());
        JTable tableauMF = new JTable(modelMF);
        panelTabMF.add(new JScrollPane(tableauMF), BorderLayout.CENTER);

        panel.add(panelTabTF);
        panel.add(panelTabPF);
        panel.add(panelTabMF);
        return panel;
    }

    public JPanel resultTennis(Connection db, String TennisName)
    {

        String[] headerPT = {"nom du joueur", "prenom du joueur" , "age du joueur", "nb de medailles du joueur"};
        ModeleStatic modelPT = new ModeleStatic(headerPT);
        TablePlayerTennis PT;
        ArrayList<String> PlayerTennis = new ArrayList<String>();

        SQLRequete requestsSQLPT = new SQLRequete();
        JPanel panelTabPT = new JPanel();

        panel.setLayout(new FlowLayout());

        List<String> valuesPT;
        try {
            valuesPT = requestsSQLPT.requetePlayerTennis(db, TennisName);
            if (!valuesPT.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesPT) {
                    PlayerTennis.add(infoArrive);
                    i++;
                    if (i == headerPT.length) {
                        modelPT.addInformation(new TablePlayerTennis(PlayerTennis.get(0), PlayerTennis.get(1), PlayerTennis.get(2), PlayerTennis.get(3)));
                        PlayerTennis.clear();
                        i = 0;
                    }
                }

            }
            else { PT = new TablePlayerTennis(" ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabPT.setLayout(new BorderLayout());
        JTable tableauPT = new JTable(modelPT);
        panelTabPT.add(new JScrollPane(tableauPT), BorderLayout.CENTER);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] headerMT = {"nb win", "nb loose", "vitesse max de frappe", "vitesse max de course"};
        ModeleStatic modelMT = new ModeleStatic(headerMT);
        TableMatchTennis MT;
        ArrayList<String> MatchTennis = new ArrayList<String>();

        SQLRequete requestsSQLMT = new SQLRequete();
        JPanel panelTabMT = new JPanel();

        panel.setLayout(new FlowLayout());

        List<String> valuesMT;
        try {
            valuesMT = requestsSQLMT.requeteMatchTennis(db, TennisName);
            if (!valuesMT.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesMT) {
                    MatchTennis.add(infoArrive);
                    i++;
                    if (i == headerMT.length) {
                        modelMT.addInformation(new TableMatchTennis(MatchTennis.get(0), MatchTennis.get(1), MatchTennis.get(2), MatchTennis.get(3)));
                        MatchTennis.clear();
                        i = 0;
                    }
                }

            }
            else { MT = new TableMatchTennis(" ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabMT.setLayout(new BorderLayout());
        JTable tableauMT = new JTable(modelMT);
        panelTabMT.add(new JScrollPane(tableauMT), BorderLayout.CENTER);

        panel.add(panelTabPT);
        panel.add(panelTabMT);
        return panel;
    }



    public JPanel resultHippique(Connection db, String HorseName)
    {
        String[] headerHJ = {"nom du cheval", "age du cheval", "image du cheval", "date du dernier passage au veterinaire", "nom de son jockey", "prenom de son jockey", "age de son jockey", "poids de son jockey"};
        ModeleStatic modelHJ = new ModeleStatic(headerHJ);
        TableHorseJockey HJ;
        ArrayList<String> HorseJockey = new ArrayList<String>();

        SQLRequete requestsSQLHJ = new SQLRequete();
        JPanel panelTabHJ = new JPanel();

        panel.setLayout(new FlowLayout());

        List<String> valuesHJ;
        try {
            valuesHJ = requestsSQLHJ.requeteHorseJockey(db, HorseName);
            if (!valuesHJ.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesHJ) {
                    HorseJockey.add(infoArrive);
                    i++;
                    if (i == headerHJ.length) {
                        modelHJ.addInformation(new TableHorseJockey(HorseJockey.get(0), HorseJockey.get(1), HorseJockey.get(2), HorseJockey.get(3), HorseJockey.get(4), HorseJockey.get(5), HorseJockey.get(6), HorseJockey.get(7)));
                        HorseJockey.clear();
                        i = 0;
                    }
                }

            }
            else { HJ = new TableHorseJockey(" ", " ", " ", " ", " ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabHJ.setLayout(new BorderLayout());
        JTable tableauHJ = new JTable(modelHJ);
        panelTabHJ.add(new JScrollPane(tableauHJ), BorderLayout.CENTER);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] headerRH = {"vitesse max du cheval", "nb de fois premier", "nb de fois sur le podium", "nb de fois perdu"};
        ModeleStatic modelRH = new ModeleStatic(headerRH);
        TableRaceHippique RH;
        ArrayList<String> RaceHippique = new ArrayList<String>();

        SQLRequete requestsSQLRH = new SQLRequete();
        JPanel panelTabRH = new JPanel();

        panel.setLayout(new FlowLayout());

        List<String> valuesRH;
        try {
            valuesRH = requestsSQLRH.requeteRaceHippique(db, HorseName);
            if (!valuesRH.isEmpty()) {
                int i = 0;

                for (String infoArrive : valuesRH) {
                    RaceHippique.add(infoArrive);
                    i++;
                    if (i == headerRH.length) {
                        modelRH.addInformation(new TableRaceHippique(RaceHippique.get(0), RaceHippique.get(1), RaceHippique.get(2), RaceHippique.get(3)));
                        RaceHippique.clear();
                        i = 0;
                    }
                }

            }
            else { RH = new TableRaceHippique(" ", " ", " ", " ");}
        } catch (Exception i) {
            System.out.println(i);
        }

        panelTabRH.setLayout(new BorderLayout());
        JTable tableauRH = new JTable(modelRH);
        panelTabRH.add(new JScrollPane(tableauRH), BorderLayout.CENTER);

        panel.add(panelTabHJ);
        panel.add(panelTabRH);
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
