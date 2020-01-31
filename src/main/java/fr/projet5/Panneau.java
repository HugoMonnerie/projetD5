package fr.projet5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


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


    Container panelAdmin(JFrame fen, String type, Connection db) {
        panel.setLayout(new FlowLayout());
        properties.createFile();
        rme = false;
        if (type=="addPF"){
            JLabel nom = new JLabel("<html><body>nom du joueur :</body></html>");
            JLabel prenom = new JLabel("<html><body>prenon du joueur :</body></html>");
            JLabel age = new JLabel("<html><body>age:</body></html>");
            JLabel equipe = new JLabel("<html><body>equipe :</body></html>");
            //JLabel titulaire = new JLabel("<html><body>titulaire :</body></html>");

            JTextField nom2 = new JTextField();
            nom2.setColumns(10);
            JTextField prenom2 = new JTextField();
            prenom2.setColumns(10);
            JTextField age2 = new JTextField();
            age2.setColumns(10);
            JTextField equipe2 = new JTextField();
            equipe2.setColumns(10);
            //JTextField titulaire2 = new JTextField();
            //titulaire2.setColumns(9);

            JButton boutonValidePF = new JButton("valide");
            boutonValidePF.setForeground(new Color(97, 40, 0));
            boutonValidePF.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = nom2.getText();
                String prenomm = prenom2.getText();
                String agee = age2.getText();
                String equipee = equipe2.getText();
                String titulairee = "titulaire";
                SQLRequete.requeteAddPlayerFoot(db, nomm,prenomm,agee,equipee,titulairee);

            });


            panel.add(boutonValidePF);

            panel.add(nom);
            panel.add(nom2);
            panel.add(prenom);
            panel.add(prenom2);
            panel.add(age);
            panel.add(age2);
            panel.add(equipe);
            panel.add(equipe2);
            //panel.add(titulaire);
            //panel.add(titulaire2);
        } else if (type=="addPT"){
            JLabel nom = new JLabel("<html><body>nom du joueur :</body></html>");
            JLabel prenom = new JLabel("<html><body>prenon du joueur :</body></html>");
            JLabel age = new JLabel("<html><body>age:</body></html>");
            JLabel nbMed = new JLabel("<html><body>nombre de medaille:</body></html>");

            JTextField nom2= new JTextField();
            nom2.setColumns(10);
            JTextField prenom2 = new JTextField();
            prenom2.setColumns(10);
            JTextField age2 = new JTextField();
            age2.setColumns(10);
            JTextField nbMed2 = new JTextField();
            nbMed2.setColumns(10);

            JButton boutonValidePT = new JButton("valide");
            boutonValidePT.setForeground(new Color(97, 40, 0));
            boutonValidePT.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = nom2.getText();
                String prenomm = prenom2.getText();
                String agee = age2.getText();
                String equipeee = nbMed2.getText();
                SQLRequete.requeteAddPlayerTennis(db, nomm,prenomm,agee,equipeee);
                panel.add(boutonValidePT);});


            panel.add(nom);
            panel.add(nom2);
            panel.add(prenom);
            panel.add(prenom2);
            panel.add(age);
            panel.add(age2);
            panel.add(nbMed);
            panel.add(nbMed2);

        } else if (type=="addH"){
            JLabel nom = new JLabel("<html><body>nom du cheval :</body></html>");
            JLabel age= new JLabel("<html><body>age:</body></html>");
            JLabel photo = new JLabel("<html><body>photo:</body></html>");
            JLabel dateveto = new JLabel("<html><body>date veterinaire:</body></html>");
            JLabel id = new JLabel("<html><body>date veterinaire:</body></html>");


            JTextField nom2= new JTextField();
            nom2.setColumns(10);
            JTextField age2 = new JTextField();
            age2.setColumns(10);
            JTextField photo2 = new JTextField();
            photo2.setColumns(10);
            JTextField dateveto2 = new JTextField();
            dateveto2.setColumns(10);
            JTextField idd = new JTextField();
            idd.setColumns(10);

            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = nom2.getText();
                String prenomm = dateveto2.getText();
                String agee = age2.getText();
                String equipeee = photo2.getText();
                String iddd = photo2.getText();
                SQLRequete.requeteAddJockeyHippique(db, nomm,prenomm,agee,equipeee,iddd);
                panel.add(boutonValideHH);});

            panel.add(nom);
            panel.add(nom2);
            panel.add(age);
            panel.add(age2);
            panel.add(photo);
            panel.add(photo2);
            panel.add(dateveto);
            panel.add(dateveto2);
        } else if (type=="addMF"){
            JLabel dateMatchFoot = new JLabel("<html><body>Date match foot :</body></html>");
            JLabel equipeDom= new JLabel("<html><body>equipe domicile :</body></html>");
            JLabel equipeExt= new JLabel("<html><body>equipe exterieur :</body></html>");
            JLabel nbButDom= new JLabel("<html><body>nb but domicile :</body></html>");
            JLabel nbButExt= new JLabel("<html><body>nb but exterieur :</body></html>");


            JTextField dateMatchFoot2= new JTextField();
            dateMatchFoot2.setColumns(10);
            JTextField equipeDom2 = new JTextField();
            equipeDom2.setColumns(10);
            JTextField equipeExt2 = new JTextField();
            equipeExt2.setColumns(10);
            JTextField nbButDom2 = new JTextField();
            nbButDom2.setColumns(10);
            JTextField nbButExt2 = new JTextField();
            nbButExt2.setColumns(10);

            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                String dateMatchFoottt = dateMatchFoot2.getText();
                String nomm = equipeDom2.getText();
                String prenomm = equipeExt2.getText();
                String agee = nbButDom2.getText();
                String equipeee = nbButExt2.getText();

                SQLRequete.requeteAddMatchFoot(db, dateMatchFoottt,nomm,prenomm,agee,equipeee);
                panel.add(boutonValideHH);
                    });

            panel.add(dateMatchFoot);
            panel.add(dateMatchFoot2);
            panel.add(equipeDom);
            panel.add(equipeDom2);
            panel.add(equipeExt);
            panel.add(equipeExt2);
            panel.add(nbButDom);
            panel.add(nbButDom2);
            panel.add(nbButExt);
            panel.add(nbButExt2);
        } else if (type=="addMT"){
            JLabel dateMatchTennis = new JLabel("<html><body>Date match tennis :</body></html>");
            JLabel location = new JLabel("<html><body>location match :</body></html>");
            JLabel surface = new JLabel("<html><body>surface du terrain :</body></html>");
            JLabel premierTennisman = new JLabel("<html><body>premier joueur :</body></html>");
            JLabel deuxiemeTennisman = new JLabel("<html><body>deuxieme joueur :</body></html>");
            JLabel vitMaxTirPremier = new JLabel("<html><body>vitesse de tir max premier joueur :</body></html>");
            JLabel vitMaxTirDeuxieme = new JLabel("<html><body>vitesse de tir max deuxieme joueur :</body></html>");
            JLabel vitMaxCoursePremier = new JLabel("<html><body>vitesse de course max premier joueur :</body></html>");
            JLabel vitMaxCourseDeuxieme = new JLabel("<html><body>vitesse de course max deuxieme joueur :</body></html>");


            JTextField dateMatchTennis2= new JTextField();
            dateMatchTennis2.setColumns(10);
            JTextField location2 = new JTextField();
            location2.setColumns(10);
            JTextField surface2 = new JTextField();
            surface2.setColumns(10);
            JTextField premierTennisman2 = new JTextField();
            premierTennisman2.setColumns(10);
            JTextField deuxiemeTennisman2 = new JTextField();
            deuxiemeTennisman2.setColumns(10);
            JTextField vitMaxTirPremier2 = new JTextField();
            vitMaxTirPremier2.setColumns(10);
            JTextField vitMaxTirDeuxieme2 = new JTextField();
            vitMaxTirDeuxieme2.setColumns(10);
            JTextField vitMaxCoursePremier2 = new JTextField();
            vitMaxCoursePremier2.setColumns(10);
            JTextField vitMaxCourseDeuxieme2 = new JTextField();
            vitMaxCourseDeuxieme2.setColumns(10);
            JTextField Result_match_first_player_t = new JTextField();
            Result_match_first_player_t.setColumns(10);





            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = dateMatchTennis2.getText();
                String prenomm = location2.getText();
                String agee = surface2.getText();
                String equipeee = premierTennisman2.getText();
                String equipeeee = deuxiemeTennisman2.getText();
                String iddd = vitMaxTirPremier2.getText();
                String iddde = vitMaxCoursePremier2.getText();
                String idddd = vitMaxTirDeuxieme2.getText();
                String iddddd = vitMaxCourseDeuxieme2.getText();
                String Result_match_first_player = Result_match_first_player_t.getText();
                SQLRequete.requeteAddMatchTennis(db, nomm,prenomm,agee,equipeee,equipeeee,iddd,iddde,idddd,iddddd,Result_match_first_player);
                panel.add(boutonValideHH);});



            panel.add(dateMatchTennis);
            panel.add(dateMatchTennis2);
            panel.add(location);
            panel.add(location2);
            panel.add(surface);
            panel.add(surface2);
            panel.add(premierTennisman);
            panel.add(premierTennisman2);
            panel.add(deuxiemeTennisman);
            panel.add(deuxiemeTennisman2);
            panel.add(vitMaxTirPremier);
            panel.add(vitMaxTirPremier2);
            panel.add(vitMaxTirDeuxieme);
            panel.add(vitMaxTirDeuxieme2);
            panel.add(vitMaxCoursePremier);
            panel.add(vitMaxCoursePremier2);
            panel.add(vitMaxCourseDeuxieme);
            panel.add(vitMaxCourseDeuxieme2);
        } else if (type=="addTF"){
            JLabel nomTeam = new JLabel("<html><body>nom de l'equipe :</body></html>");
            JLabel dateCrea= new JLabel("<html><body>date de creation :</body></html>");
            JLabel site= new JLabel("<html><body>site de l'equipe:</body></html>");


            JTextField nomTeam2= new JTextField();
            nomTeam2.setColumns(10);
            JTextField dateCrea2 = new JTextField();
            dateCrea2.setColumns(10);
            JTextField site2 = new JTextField();
            site2.setColumns(10);

            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = nomTeam2.getText();
                String prenomm = dateCrea2.getText();
                String agee = site2.getText();

                SQLRequete.requeteAddTeamFoot(db, nomm,prenomm,agee);
                panel.add(boutonValideHH);});

            panel.add(nomTeam);
            panel.add(nomTeam2);
            panel.add(dateCrea);
            panel.add(dateCrea2);
            panel.add(site);
            panel.add(site2);
        } else if (type=="addCH"){
            JLabel date = new JLabel("<html><body>date et heure de la course :</body></html>");
            JLabel dateveto = new JLabel("<html><body>date et heure du veto :</body></html>");
            JLabel lieu= new JLabel("<html><body>lieu de la course :</body></html>");
            JLabel meteo= new JLabel("<html><body>meteo de la course :</body></html>");

            JTextField date2= new JTextField();
            date2.setColumns(10);
            JTextField dateveto2= new JTextField();
            date2.setColumns(10);
            JTextField lieu2 = new JTextField();
            lieu2.setColumns(10);
            JTextField meteo2 = new JTextField();
            meteo2.setColumns(10);

            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = date2.getText();
                String prenomm = lieu2.getText();
                String agee = meteo2.getText();
                String datevetoo= dateveto2.getText();

                SQLRequete.requeteAddChevauxHippique(db, nomm,prenomm,agee,datevetoo);
                panel.add(boutonValideHH);});

            panel.add(date);
            panel.add(date2);
            panel.add(lieu);
            panel.add(lieu2);
            panel.add(meteo);
            panel.add(meteo2);
        } else if (type=="addJH"){
            JLabel nom = new JLabel("<html><body>nom du jockey :</body></html>");
            JLabel prenom= new JLabel("<html><body>prenom du jockey :</body></html>");
            JLabel age= new JLabel("<html><body>age du jockey :</body></html>");
            JLabel poids= new JLabel("<html><body>poids du jockey:</body></html>");
            JLabel cheval= new JLabel("<html><body>nom de son cheval:</body></html>");

            JTextField nom2= new JTextField();
            nom2.setColumns(10);
            JTextField prenom2 = new JTextField();
            prenom2.setColumns(10);
            JTextField age2 = new JTextField();
            age2.setColumns(10);
            JTextField poids2 = new JTextField();
            poids2.setColumns(10);
            JTextField cheval2 = new JTextField();
            cheval2.setColumns(10);

            JButton boutonValideHH = new JButton("valide");
            boutonValideHH.setForeground(new Color(97, 40, 0));
            boutonValideHH.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                String nomm = nom2.getText();
                String prenomm = prenom2.getText();
                String agee = age2.getText();
                String datevetoo= poids2.getText();
                String chevall= cheval2.getText();

                SQLRequete.requeteAddJockeyHippique(db, nomm,prenomm,agee,datevetoo,chevall);
                panel.add(boutonValideHH);});

            panel.add(nom);
            panel.add(nom2);
            panel.add(prenom);
            panel.add(prenom2);
            panel.add(age);
            panel.add(age2);
            panel.add(poids);
            panel.add(poids2);
            panel.add(cheval);
            panel.add(cheval2);
        } else if (type=="delPF"){

            try {
                String request = "SELECT * FROM football_player";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Name_player_f") + " " + rs.getString("Firstname_player_f"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPF = new JComboBox<>(listPlayer);
                delPF.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent itemEvent) {
                        try{
                            String request = "SELECT * FROM football_player";
                            PreparedStatement ps = db.prepareStatement(request);
                            ResultSet rs = ps.executeQuery(request);
                            List<String> values = new ArrayList<>();
                            while (rs.next()) {
                                values.add(rs.getString("Name_player_f") + " " + rs.getString("Firstname_player_f"));
                                //JComboBox.add(rs.getString("Name_player_f"));
                                //JComboBox.add(rs.getString("Firstname_player_f"));
                            }
                            rs.close();
                            ps.close();
                        }catch (SQLException ex){

                        }
                    }
                });
                panel.add(delPF);
            }catch (SQLException e) {
                e.printStackTrace();
            }



            JButton football_player = new JButton("supprimer");
            football_player.setForeground(new Color(97, 40, 0));
            football_player.addActionListener(e -> {
                //your actions
                panel.setVisible(false);
                panel.add(football_player);});

        } else if (type=="delPT"){
            try {
                String request = "SELECT * FROM players_tennis";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Name_player_t") + " " + rs.getString("Firstname_player_t"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (type=="delH"){
            try {
                String request = "SELECT * FROM chevaux_hippique";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Name_horse")) ;
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (type=="delMF"){
            try {
                String request = "SELECT * FROM matchs_football";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("id_match_f") + " " + rs.getString("date_match_f"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (type=="delMT"){
            try {
                String request = "SELECT * FROM matchs_tennis";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("id_match_t") + " " + rs.getString("date_match_t"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (type=="delTF"){
            try {
                String request = "SELECT * FROM football_team";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Team_name"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (type=="delCH"){
            try {
                String request = "SELECT * FROM chevaux_hippique";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Name_horse") + " " + rs.getString("date_match_t"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (type=="delJH"){
            try {
                String request = "SELECT * FROM jockeys_hippique";
                PreparedStatement ps = db.prepareStatement(request);
                ResultSet rs = ps.executeQuery(request);
                List<String> values = new ArrayList<>();
                while (rs.next()) {
                    values.add(rs.getString("Name_jockeys"));
                    //JComboBox.add(rs.getString("Name_player_f"));
                    //JComboBox.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();
                String[] listPlayer = new String[values.size()];
                for(int i =0; i<values.size(); i++){
                    listPlayer[i] = values.get(i);
                }
                JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                panel.add(delPt);
            }catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (type=="modPF"){
            try {
                String request = "SELECT * FROM football_player";

                PreparedStatement ps = db.prepareStatement(request);

                ResultSet rs = ps.executeQuery(request);

                List<String> elements = new ArrayList<>();

                while (rs.next()) {
                    elements.add(rs.getString("Name_player_f"));
                    elements.add(rs.getString("Firstname_player_f"));
                }
                rs.close();
                ps.close();

                JComboBox modPF = new JComboBox((Vector) elements);
                panel.add(modPF);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (type=="modPT"){

        } else if (type=="modH"){

        } else if (type=="modMF"){

        } else if (type=="modMT"){

        } else if (type=="modTF"){

        } else if (type=="modCH"){

        } else if (type=="modJH"){

        }
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
        bouton.setForeground(new Color(27, 103, 0));
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

        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Type de parie :</body></html>");

        JButton bouton1 = new JButton("Football");
        bouton1.setForeground(new Color(1, 105, 0));
        bouton1.addActionListener(e -> {
            //your actions
            panel.setVisible(false);
            Panneau panneau = new Panneau();
            fen.setContentPane(panneau.foot(fen,db));
        });
        JButton bouton2 = new JButton("Tennis");
        bouton2.setForeground(new Color(173, 155, 0));
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
        JLabel textf = new JLabel("<html><body>Nom de l'équipe :</body></html>");
        textf.setForeground(new Color(32, 129, 0));

        panel.setLayout(new FlowLayout());
        JTextField nameOfTeam = new JTextField();
        nameOfTeam.setColumns(10);

        JButton buttonValid = new JButton("Valider");
        buttonValid.setForeground(new Color(0, 124, 10));
        buttonValid.addActionListener(ee -> {
            panel.setForeground(new Color(8, 108, 0));

            panel.setVisible(false);
            Panneau panneau = new Panneau();

            String teamName = nameOfTeam.getText();
            fen.setContentPane(panneau.resultFoot(db,teamName));

        });

        JButton boutonajouterPF = new JButton("ajouter un joueur");
        boutonajouterPF.addActionListener(e -> {
            //your actions
            new Admin("addPF", db);
        });
        JButton boutonajouterTF = new JButton("ajouter une equipe");
        boutonajouterTF.addActionListener(e -> {
            //your actions
            new Admin("addTF", db);
        });
        JButton boutonajouterMF = new JButton("ajouter un match");
        boutonajouterMF.addActionListener(e -> {
            //your actions
            new Admin("addMF", db);
        });
        JButton boutonsuppPF = new JButton("supprimer un joueur");
        boutonsuppPF.addActionListener(e -> {
            //your actions
            new Admin("delPF", db);
        });
        JButton boutonsuppTF = new JButton("supprimer une equipe");
        boutonsuppTF.addActionListener(e -> {
            //your actions
            new Admin("delTF", db);
        });
        JButton boutonsuppMF = new JButton("supprimer un match");
        boutonsuppMF.addActionListener(e -> {
            //your actions
            new Admin("delMF", db);
        });
        JButton boutonmodifPF = new JButton("modifier un joueur");
        boutonmodifPF.addActionListener(e -> {
            //your actions
            new Admin("modPF", db);
        });
        JButton boutonmodifTF = new JButton("modifier une equipe");
        boutonmodifTF.addActionListener(e -> {
            //your actions
            new Admin("modTF", db);
        });
        JButton boutonmodifMF = new JButton("modifier un match");
        boutonmodifMF.addActionListener(e -> {
            //your actions
            new Admin("modMF", db);
        });

        menu(fen, db);

        //affichage

        panel.add(textf);

        panel.add(nameOfTeam);

        panel.add(buttonValid);

        panel.add(boutonajouterPF);

        panel.add(boutonajouterTF);

        panel.add(boutonajouterMF);

        panel.add(boutonsuppPF);

        panel.add(boutonsuppTF);

        panel.add(boutonsuppMF);

        panel.add(boutonmodifPF);

        panel.add(boutonmodifTF);

        panel.add(boutonmodifMF);

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
        JButton boutonajouterPT = new JButton("ajouter un tennisman");
        boutonajouterPT.addActionListener(e -> {
            //your actions
            new Admin("addPT", db);
        });
        JButton boutonajouterMT = new JButton("ajouter un match");
        boutonajouterMT.addActionListener(e -> {
            //your actions
            new Admin("addMT", db);
        });
        JButton boutonsuppPT = new JButton("supprimer un tennisman");
        boutonsuppPT.addActionListener(e -> {
            //your actions
            new Admin("delPT", db);
        });
        JButton boutonsuppMT = new JButton("supprimer un match");
        boutonsuppMT.addActionListener(e -> {
            //your actions
            new Admin("delMT", db);
        });
        JButton boutonmodifPT = new JButton("modifier un tennisman");
        boutonmodifPT.addActionListener(e -> {
            //your actions
            new Admin("modPT", db);
        });
        JButton boutonmodifMT = new JButton("modifier un match");
        boutonmodifMT.addActionListener(e -> {
            //your actions
            new Admin("modMT", db);
        });


        menu(fen, db);

        //affichage

        panel.add(text1);

        panel.add(jtennis);

        panel.add(bouton);

        panel.add(boutonajouterPT);

        panel.add(boutonajouterMT);

        panel.add(boutonsuppPT);

        panel.add(boutonsuppMT);

        panel.add(boutonmodifPT);

        panel.add(boutonmodifMT);

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
        JButton boutonajouterH = new JButton("ajouter un cheval");
        boutonajouterH.addActionListener(e -> {
            //your actions
            new Admin("addH", db);
        });
        JButton boutonajouterJH = new JButton("ajouter un jockey");
        boutonajouterJH.addActionListener(e -> {
            //your actions
            new Admin("addJH", db);
        });
        JButton boutonajouterCH = new JButton("ajouter une course hippique");
        boutonajouterCH.addActionListener(e -> {
            //your actions
            new Admin("addCH", db);
        });
        JButton boutonsuppH = new JButton("supprimer un cheval");
        boutonsuppH.addActionListener(e -> {
            //your actions
            new Admin("delH", db);
        });
        JButton boutonsuppJH = new JButton("supprimer un jockey");
        boutonsuppJH.addActionListener(e -> {
            //your actions
            new Admin("delJH", db);
        });
        JButton boutonsuppCH = new JButton("supprimer une course hippique");
        boutonsuppCH.addActionListener(e -> {
            //your actions
            new Admin("delCH", db);
        });
        JButton boutonmodifH = new JButton("modifier un cheval");
        boutonajouterH.addActionListener(e -> {
            //your actions
            new Admin("modH", db);
        });
        JButton boutonmodifJH = new JButton("modifier un jockey");
        boutonmodifJH.addActionListener(e -> {
            //your actions
            new Admin("modJH", db);
        });
        JButton boutonmodifCH = new JButton("modifier une course hippique");
        boutonmodifCH.addActionListener(e -> {
            //your actions
            new Admin("modCH", db);
        });

        menu(fen, db);

        //affichage

        panel.add(texth);

        panel.add(jhippique);

        panel.add(bouton);

        panel.add(boutonajouterH);

        panel.add(boutonajouterJH);

        panel.add(boutonajouterCH);

        panel.add(boutonsuppH);

        panel.add(boutonsuppJH);

        panel.add(boutonsuppCH);

        panel.add(boutonmodifH);

        panel.add(boutonmodifJH);

        panel.add(boutonmodifCH);

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
