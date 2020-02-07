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
import java.util.Objects;


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

    void menu(JFrame fen, Connection db){
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
        panel.setBackground(new Color(32, 32, 32, 255));

        panel.setForeground(new Color(32, 32, 32));

    }


    Container panelAdmin(String type, Connection db) {
        panel.setLayout(new FlowLayout());
        properties.createFile();
        rme = false;
        switch (type) {
            case "addPF": {
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
                    SQLRequete.requeteAddPlayerFoot(db, nomm, prenomm, agee, equipee, titulairee);

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
                break;
            }
            case "addPT": {
                JLabel nom = new JLabel("<html><body>nom du joueur :</body></html>");
                JLabel prenom = new JLabel("<html><body>prenon du joueur :</body></html>");
                JLabel age = new JLabel("<html><body>age:</body></html>");
                JLabel nbMed = new JLabel("<html><body>nombre de medaille:</body></html>");

                JTextField nom2 = new JTextField();
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
                    SQLRequete.requeteAddPlayerTennis(db, nomm, prenomm, agee, equipeee);
                    panel.add(boutonValidePT);
                });

                panel.add(boutonValidePT);
                panel.add(nom);
                panel.add(nom2);
                panel.add(prenom);
                panel.add(prenom2);
                panel.add(age);
                panel.add(age2);
                panel.add(nbMed);
                panel.add(nbMed2);

                break;
            }
            case "addH": {
                JLabel nom = new JLabel("<html><body>nom du cheval :</body></html>");
                JLabel age = new JLabel("<html><body>age:</body></html>");
                JLabel photo = new JLabel("<html><body>photo:</body></html>");
                JLabel dateveto = new JLabel("<html><body>date veterinaire:</body></html>");

                JTextField nom2 = new JTextField();
                nom2.setColumns(10);
                JTextField age2 = new JTextField();
                age2.setColumns(10);
                JTextField photo2 = new JTextField();
                photo2.setColumns(10);
                JTextField dateveto2 = new JTextField();
                dateveto2.setColumns(10);

                JButton boutonValideHH = new JButton("valide");
                boutonValideHH.setForeground(new Color(97, 40, 0));
                boutonValideHH.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nom2.getText();
                    String prenomm = dateveto2.getText();
                    String agee = age2.getText();
                    String equipeee = photo2.getText();
                    SQLRequete.requeteAddChevauxHippique(db, nomm, prenomm, agee, equipeee);
                });

                panel.add(boutonValideHH);
                panel.add(nom);
                panel.add(nom2);
                panel.add(age);
                panel.add(age2);
                panel.add(photo);
                panel.add(photo2);
                panel.add(dateveto);
                panel.add(dateveto2);
                break;
            }
            case "addMF": {
                JLabel dateMatchFoot = new JLabel("<html><body>Date match foot :</body></html>");
                JLabel equipeDom = new JLabel("<html><body>equipe domicile :</body></html>");
                JLabel equipeExt = new JLabel("<html><body>equipe exterieur :</body></html>");
                JLabel nbButDom = new JLabel("<html><body>nb but domicile :</body></html>");
                JLabel nbButExt = new JLabel("<html><body>nb but exterieur :</body></html>");


                JTextField dateMatchFoot2 = new JTextField();
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

                    SQLRequete.requeteAddMatchFoot(db, dateMatchFoottt, nomm, prenomm, agee, equipeee);
                    panel.add(boutonValideHH);
                });


                panel.add(boutonValideHH);
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
                break;
            }
            case "addMT": {
                JLabel dateMatchTennis = new JLabel("<html><body>Date match tennis :</body></html>");
                JLabel location = new JLabel("<html><body>location match :</body></html>");
                JLabel surface = new JLabel("<html><body>surface du terrain :</body></html>");
                JLabel premierTennisman = new JLabel("<html><body>premier joueur :</body></html>");
                JLabel deuxiemeTennisman = new JLabel("<html><body>deuxieme joueur :</body></html>");
                JLabel vitMaxTirPremier = new JLabel("<html><body>vitesse de tir max premier joueur :</body></html>");
                JLabel vitMaxTirDeuxieme = new JLabel("<html><body>vitesse de tir max deuxieme joueur :</body></html>");
                JLabel vitMaxCoursePremier = new JLabel("<html><body>vitesse de course max premier joueur :</body></html>");
                JLabel vitMaxCourseDeuxieme = new JLabel("<html><body>vitesse de course max deuxieme joueur :</body></html>");

                JTextField dateMatchTennis2 = new JTextField();
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
                    SQLRequete.requeteAddMatchTennis(db, nomm, prenomm, agee, equipeee, equipeeee, iddd, iddde, idddd, iddddd, Result_match_first_player);
                    panel.add(boutonValideHH);
                });

                panel.add(boutonValideHH);
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
                break;
            }
            case "addTF": {
                JLabel nomTeam = new JLabel("<html><body>nom de l'equipe :</body></html>");
                JLabel dateCrea = new JLabel("<html><body>date de creation :</body></html>");
                JLabel site = new JLabel("<html><body>site de l'equipe:</body></html>");

                JTextField nomTeam2 = new JTextField();
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

                    SQLRequete.requeteAddTeamFoot(db, nomm, prenomm, agee);
                    panel.add(boutonValideHH);
                });

                panel.add(boutonValideHH);
                panel.add(nomTeam);
                panel.add(nomTeam2);
                panel.add(dateCrea);
                panel.add(dateCrea2);
                panel.add(site);
                panel.add(site2);
                break;
            }
            case "addCH": {
                JLabel date = new JLabel("<html><body>date et heure de la course :</body></html>");
                JLabel lieu = new JLabel("<html><body>lieu de la course :</body></html>");
                JLabel meteo = new JLabel("<html><body>meteo de la course :</body></html>");

                JTextField date2 = new JTextField();
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

                    SQLRequete.requeteAddRaceHippique(db, nomm, prenomm, agee);
                    panel.add(boutonValideHH);
                });

                panel.add(boutonValideHH);
                panel.add(date);
                panel.add(date2);
                panel.add(lieu);
                panel.add(lieu2);
                panel.add(meteo);
                panel.add(meteo2);
                break;
            }
            case "addJH": {
                JLabel nom = new JLabel("<html><body>nom du jockey :</body></html>");
                JLabel prenom = new JLabel("<html><body>prenom du jockey :</body></html>");
                JLabel age = new JLabel("<html><body>age du jockey :</body></html>");
                JLabel poids = new JLabel("<html><body>poids du jockey:</body></html>");
                JLabel cheval = new JLabel("<html><body>nom de son cheval:</body></html>");

                JTextField nom2 = new JTextField();
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
                    String datevetoo = poids2.getText();
                    String chevall = cheval2.getText();

                    SQLRequete.requeteAddJockeyHippique(db, nomm, prenomm, agee, datevetoo, chevall);
                });

                panel.add(boutonValideHH);
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
                break;
            }
            case "delPF":

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
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPF = new JComboBox<>(listPlayer);
                    delPF.addItemListener(itemEvent -> {
                        try {
                            String request1 = "SELECT * FROM football_player";
                            PreparedStatement ps1 = db.prepareStatement(request1);
                            ResultSet rs1 = ps1.executeQuery(request1);
                            List<String> values1 = new ArrayList<>();
                            while (rs1.next()) {
                                values1.add(rs1.getString("Name_player_f") + " " + rs1.getString("Firstname_player_f"));
                                //JComboBox.add(rs.getString("Name_player_f"));
                                //JComboBox.add(rs.getString("Firstname_player_f"));
                            }
                            rs1.close();
                            ps1.close();


                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPF.getSelectedItem()).toString();
                        String[] splited = player.split(" ");

                        String nom2 = splited[0];
                        String prenom2 = splited[1];

                        String prenomm = prenom2.toString();
                        SQLRequete.requeteDelPlayerFoot(db, nom2, prenomm);

                    });
                    panel.add(football_player);
                    panel.add(delPF);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "delPT":
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
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request12 = "SELECT * FROM players_tennis";
                            PreparedStatement ps12 = db.prepareStatement(request12);
                            ResultSet rs12 = ps12.executeQuery(request12);
                            List<String> values12 = new ArrayList<>();
                            while (rs12.next()) {
                                values12.add(rs12.getString("Name_player_t") + " " + rs12.getString("Firstname_player_t"));
                            }
                            rs12.close();
                            ps12.close();

                        } catch (SQLException ex) {

                        }
                    });
                    JButton player_tennis = new JButton("supprimer");
                    player_tennis.setForeground(new Color(97, 40, 0));
                    player_tennis.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split(" ");

                        String nom2 = splited[0];
                        String prenom2 = splited[1];

                        String nomm = nom2;
                        String prenomm = prenom2.toString();
                        SQLRequete.requeteDelPlayerTennis(db, nomm, prenomm);
                    });
                    panel.add(player_tennis);

                    panel.add(delPt);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                break;
            case "delH":
                try {
                    String request = "SELECT * FROM chevaux_hippique";
                    PreparedStatement ps = db.prepareStatement(request);
                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();
                    while (rs.next()) {
                        values.add(rs.getString("Name_horse"));
                        //JComboBox.add(rs.getString("Name_player_f"));
                        //JComboBox.add(rs.getString("Firstname_player_f"));
                    }
                    rs.close();
                    ps.close();
                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request13 = "SELECT * FROM chevaux_hippique";
                            PreparedStatement ps13 = db.prepareStatement(request13);
                            ResultSet rs13 = ps13.executeQuery(request13);
                            List<String> values13 = new ArrayList<>();
                            while (rs13.next()) {
                                values13.add(rs13.getString("Name_horse"));
                            }
                            rs13.close();
                            ps13.close();

                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("  ");

                        String nom2 = splited[0];

                        String nomm = nom2;
                        SQLRequete.requeteDelChevauxHippique(db, nomm);

                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "delMF":
                try {
                    String request = "SELECT * FROM matchs_football";
                    PreparedStatement ps = db.prepareStatement(request);
                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();
                    while (rs.next()) {
                        values.add(rs.getString("date_match_f"));
                        //JComboBox.add(rs.getString("Name_player_f"));
                        //JComboBox.add(rs.getString("Firstname_player_f"));
                    }
                    rs.close();
                    ps.close();
                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request14 = "SELECT * FROM matchs_football";
                            PreparedStatement ps14 = db.prepareStatement(request14);
                            ResultSet rs14 = ps14.executeQuery(request14);
                            List<String> values14 = new ArrayList<>();
                            while (rs14.next()) {
                                values14.add(rs14.getString("date_match_f"));
                            }
                            rs14.close();
                            ps14.close();

                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("  ");

                        String nom2 = splited[0];

                        String datee = nom2;

                        SQLRequete.requeteDelMatchFoot(db, datee);
                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "delMT":
                try {
                    String request = "SELECT * FROM matchs_tennis";
                    PreparedStatement ps = db.prepareStatement(request);
                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();
                    while (rs.next()) {
                        values.add(rs.getString("date_match_t"));
                        //JComboBox.add(rs.getString("Name_player_f"));
                        //JComboBox.add(rs.getString("Firstname_player_f"));
                    }
                    rs.close();
                    ps.close();
                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request15 = "SELECT * FROM matchs_tennis";
                            PreparedStatement ps15 = db.prepareStatement(request15);
                            ResultSet rs15 = ps15.executeQuery(request15);
                            List<String> values15 = new ArrayList<>();
                            while (rs15.next()) {
                                values15.add(rs15.getString("date_match_t"));
                            }
                            rs15.close();
                            ps15.close();

                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("  ");

                        String nom2 = splited[0];

                        String datee = nom2;

                        SQLRequete.requeteDelMatchTennis(db, datee);
                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "delTF":
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
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request16 = "SELECT * FROM football_team";
                            PreparedStatement ps16 = db.prepareStatement(request16);
                            ResultSet rs16 = ps16.executeQuery(request16);
                            List<String> values16 = new ArrayList<>();
                            while (rs16.next()) {
                                values16.add(rs16.getString("Team_name"));
                            }
                            rs16.close();
                            ps16.close();

                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("  ");

                        String nom2 = splited[0];

                        String nomm = nom2;
                        SQLRequete.requeteDelTeamFoot(db, nomm);
                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "delCH":
                try {
                    String request = "SELECT * FROM race_hippiques";
                    PreparedStatement ps = db.prepareStatement(request);
                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();
                    while (rs.next()) {
                        values.add(rs.getString("Time_race"));
                    }
                    rs.close();
                    ps.close();
                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(itemEvent -> {
                        try {
                            String request17 = "SELECT * FROM race_hippiques";
                            PreparedStatement ps17 = db.prepareStatement(request17);
                            ResultSet rs17 = ps17.executeQuery(request17);
                            List<String> values17 = new ArrayList<>();
                            while (rs17.next()) {
                                values17.add(rs17.getString("Time_race"));
                            }
                            rs17.close();
                            ps17.close();

                        } catch (SQLException ignored) {

                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("  ");

                        String nom2 = splited[0];

                        String datee = nom2;
                        SQLRequete.requeteDelRaceHippique(db, datee);
                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "delJH":
                try {
                    String request = "SELECT * FROM jockeys_hippique";
                    PreparedStatement ps = db.prepareStatement(request);
                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();
                    while (rs.next()) {
                        values.add(rs.getString("Name_jockeys") + " " + rs.getString("Firstname_jockey"));
                    }
                    rs.close();
                    ps.close();
                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> delPt = new JComboBox<>(listPlayer);
                    delPt.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent itemEvent) {
                            try {
                                String request = "SELECT * FROM jockeys_hippique";
                                PreparedStatement ps = db.prepareStatement(request);
                                ResultSet rs = ps.executeQuery(request);
                                List<String> values = new ArrayList<>();
                                while (rs.next()) {
                                    values.add(rs.getString("Name_jockeys") + " " + rs.getString("Firstname_jockey"));
                                }
                                rs.close();
                                ps.close();

                            } catch (SQLException ex) {

                            }
                        }
                    });
                    JButton football_player = new JButton("supprimer");
                    football_player.setForeground(new Color(97, 40, 0));
                    football_player.addActionListener(e -> {
                        //your actions
                        panel.setVisible(false);
                        String player = Objects.requireNonNull(delPt.getSelectedItem()).toString();
                        String[] splited = player.split("\\ ");

                        String nom2 = splited[0];
                        String prenom2 = splited[1];

                        String nomm = nom2.toString();
                        String prenomm = prenom2.toString();
                        SQLRequete.requeteDelJockeyHippique(db, nomm, prenomm);
                    });
                    panel.add(football_player);
                    panel.add(delPt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
            case "modPF": {

                JLabel nom = new JLabel("<html><body>nom du joueur :</body></html>");
                JLabel prenom = new JLabel("<html><body>prenon du joueur :</body></html>");
                JLabel age = new JLabel("<html><body>age:</body></html>");
                JLabel equipe = new JLabel("<html><body>equipe :</body></html>");
                JLabel titulaire = new JLabel("<html><body>titulaire :</body></html>");

                JTextField nom2 = new JTextField();
                nom2.setColumns(10);
                JTextField prenom2 = new JTextField();
                prenom2.setColumns(10);
                JTextField age2 = new JTextField();
                age2.setColumns(10);
                JTextField equipe2 = new JTextField();
                equipe2.setColumns(10);
                JTextField titulaire2 = new JTextField();
                titulaire2.setColumns(10);
                try {
                    String request = "SELECT * FROM football_player";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Name_player_f") + " " + rs.getString("Firstname_player_f"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }


                    JComboBox<? extends String> modPF = new JComboBox<>(listPlayer);
                    modPF.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modPF.getSelectedItem()).toString();
                            String[] splited = player.split("\\ ");

                            nom2.setText(splited[0]);
                            prenom2.setText(splited[1]);

                            String request18 = "SELECT * FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f WHERE FP.Name_player_f = '" + nom2.getText() + "' AND FP.Firstname_player_f = '" + prenom2.getText() + "';";

                            PreparedStatement ps18 = db.prepareStatement(request18);

                            ResultSet rs18 = ps18.executeQuery(request18);

                            while (rs18.next()) {
                                age2.setText(rs18.getString("FP.Age_player_f"));
                                equipe2.setText(rs18.getString("FT.Team_name"));
                                titulaire2.setText(rs18.getString("FP.Titulaire_player_f"));
                            }
                            rs18.close();
                            ps18.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modPF);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JButton football_player = new JButton("modifier");
                football_player.setForeground(new Color(97, 40, 0));
                football_player.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nom2.getText();
                    String prenomm = prenom2.getText();
                    String agee = age2.getText();
                    String equipee = equipe2.getText();
                    String titulairee = titulaire2.getText();

                    SQLRequete.requeteModPlayerFoot(db, nomm, prenomm, agee, equipee, titulairee);
                });
                panel.add(football_player);

                panel.add(nom);
                panel.add(nom2);
                panel.add(prenom);
                panel.add(prenom2);
                panel.add(age);
                panel.add(age2);
                panel.add(equipe);
                panel.add(equipe2);
                panel.add(titulaire);
                panel.add(titulaire2);

                break;
            }
            case "modPT": {
                JLabel nom = new JLabel("<html><body>nom du joueur :</body></html>");
                JLabel prenom = new JLabel("<html><body>prenon du joueur :</body></html>");
                JLabel age = new JLabel("<html><body>age:</body></html>");
                JLabel nbMed = new JLabel("<html><body>nombre de medaille:</body></html>");

                JTextField nom2 = new JTextField();
                nom2.setColumns(10);
                JTextField prenom2 = new JTextField();
                prenom2.setColumns(10);
                JTextField age2 = new JTextField();
                age2.setColumns(10);
                JTextField nbMed2 = new JTextField();
                nbMed2.setColumns(10);
                try {
                    String request = "SELECT * FROM players_tennis";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Name_player_t") + " " + rs.getString("Firstname_player_t"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }

                    JComboBox<? extends String> modPT = new JComboBox<>(listPlayer);
                    modPT.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modPT.getSelectedItem()).toString();
                            String[] splited = player.split("\\ ");

                            nom2.setText(splited[0]);
                            prenom2.setText(splited[1]);

                            String request19 = "SELECT * FROM players_tennis AS PT WHERE PT.Name_player_t = '" + nom2.getText() + "' AND PT.Firstname_player_t = '" + prenom2.getText() + "';";

                            PreparedStatement ps19 = db.prepareStatement(request19);

                            ResultSet rs19 = ps19.executeQuery(request19);

                            while (rs19.next()) {
                                age2.setText(rs19.getString("PT.Age_player_t"));
                                nbMed2.setText(rs19.getString("PT.Nbr_medal_t"));
                            }
                            rs19.close();
                            ps19.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modPT);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JButton football_player = new JButton("modifier");
                football_player.setForeground(new Color(97, 40, 0));
                football_player.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nom2.getText();
                    String prenomm = prenom2.getText();
                    String agee = age2.getText();
                    String titulairee = nbMed2.getText();
                    SQLRequete.requeteModPlayerTennis(db, nomm, prenomm, agee, titulairee);
                });
                panel.add(football_player);
                panel.add(nom);
                panel.add(nom2);
                panel.add(prenom);
                panel.add(prenom2);
                panel.add(age);
                panel.add(age2);
                panel.add(nbMed);
                panel.add(nbMed2);

                break;
            }
            case "modH": {
                JLabel nom = new JLabel("<html><body>nom du cheval :</body></html>");
                JLabel age = new JLabel("<html><body>age:</body></html>");
                JLabel photo = new JLabel("<html><body>photo:</body></html>");
                JLabel dateveto = new JLabel("<html><body>date veterinaire:</body></html>");

                JTextField nom2 = new JTextField();
                nom2.setColumns(10);
                JTextField age2 = new JTextField();
                age2.setColumns(10);
                JTextField photo2 = new JTextField();
                photo2.setColumns(10);
                JTextField dateveto2 = new JTextField();
                dateveto2.setColumns(10);
                try {
                    String request = "SELECT * FROM chevaux_hippique";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Name_horse"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }
                    JComboBox<? extends String> modH = new JComboBox<>(listPlayer);
                    modH.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modH.getSelectedItem()).toString();
                            String[] splited = player.split("  ");

                            nom2.setText(splited[0]);

                            String request110 = "SELECT * FROM chevaux_hippique AS CH WHERE CH.Name_horse = '" + nom2.getText() + "';";

                            PreparedStatement ps110 = db.prepareStatement(request110);

                            ResultSet rs110 = ps110.executeQuery(request110);

                            while (rs110.next()) {
                                age2.setText(rs110.getString("CH.Age_horse"));
                                photo2.setText(rs110.getString("CH.Picture_horse"));
                                dateveto2.setText(rs110.getString("CH.Date_veterinaire"));
                            }
                            rs110.close();
                            ps110.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                    panel.add(modH);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JButton football_player = new JButton("modifier");
                football_player.setForeground(new Color(97, 40, 0));
                football_player.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nom2.getText();
                    String agee = age2.getText();
                    String equipee = photo2.getText();
                    String titulairee = dateveto2.getText();

                    SQLRequete.requeteModChevauxHippique(db, nomm, agee, equipee, titulairee);
                });
                panel.add(football_player);

                panel.add(nom);
                panel.add(nom2);
                panel.add(age);
                panel.add(age2);
                panel.add(photo);
                panel.add(photo2);
                panel.add(dateveto);
                panel.add(dateveto2);
                break;
            }
            case "modMF": {
                JLabel dateMatchFoot = new JLabel("<html><body>Date match foot :</body></html>");
                JLabel equipeDom = new JLabel("<html><body>equipe domicile :</body></html>");
                JLabel equipeExt = new JLabel("<html><body>equipe exterieur :</body></html>");
                JLabel nbButDom = new JLabel("<html><body>nb but domicile :</body></html>");
                JLabel nbButExt = new JLabel("<html><body>nb but exterieur :</body></html>");

                JTextField dateMatchFoot2 = new JTextField();
                dateMatchFoot2.setColumns(10);
                JTextField equipeDom2 = new JTextField();
                equipeDom2.setColumns(10);
                JTextField equipeExt2 = new JTextField();
                equipeExt2.setColumns(10);
                JTextField nbButDom2 = new JTextField();
                nbButDom2.setColumns(10);
                JTextField nbButExt2 = new JTextField();
                nbButExt2.setColumns(10);

                try {
                    String request = "SELECT * FROM matchs_football";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Date_match_f"));
                    }
                    rs.close();
                    ps.close();

                    String[] listMatch = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listMatch[i] = values.get(i);
                    }

                    JComboBox<? extends String> modMF = new JComboBox<>(listMatch);
                    modMF.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modMF.getSelectedItem()).toString();
                            String[] splited = player.split("  ");

                            dateMatchFoot2.setText(splited[0]);

                            String request111 = "SELECT * FROM matchs_football AS MF Left JOIN football_team as ft on MF.Id_team_inside_f = ft.Id_team_f Left JOIN football_team as ft2 on MF.Id_team_outside_f = ft2.Id_team_f WHERE MF.Date_match_f = '" + dateMatchFoot2.getText() + "';";

                            PreparedStatement ps111 = db.prepareStatement(request111);

                            ResultSet rs111 = ps111.executeQuery(request111);

                            while (rs111.next()) {
                                equipeDom2.setText(rs111.getString("ft.Team_name"));
                                equipeExt2.setText(rs111.getString("ft2.Team_name"));
                                nbButDom2.setText(rs111.getString("MF.Nbr_but_inside_f"));
                                nbButExt2.setText(rs111.getString("MF.Nbr_but_outside_f"));
                            }
                            rs111.close();
                            ps111.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modMF);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                JButton football_player = new JButton("modifier");
                football_player.setForeground(new Color(97, 40, 0));
                football_player.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = dateMatchFoot2.getText();
                    String agee = equipeDom2.getText();
                    String equipee = equipeExt2.getText();
                    String titulairee = nbButDom2.getText();
                    String titulaireee = nbButExt2.getText();

                    SQLRequete.requeteModMatchFoot(db, nomm, agee, equipee, titulairee, titulaireee);
                });
                panel.add(football_player);


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
                break;
            }
            case "modMT": {
                JLabel dateMatchTennis = new JLabel("<html><body>Date match tennis :</body></html>");
                JLabel location = new JLabel("<html><body>location match :</body></html>");
                JLabel surface = new JLabel("<html><body>surface du terrain :</body></html>");
                JLabel premierTennisman = new JLabel("<html><body>premier joueur :</body></html>");
                JLabel deuxiemeTennisman = new JLabel("<html><body>deuxieme joueur :</body></html>");
                JLabel vitMaxTirPremier = new JLabel("<html><body>vitesse de tir max premier joueur :</body></html>");
                JLabel vitMaxTirDeuxieme = new JLabel("<html><body>vitesse de tir max deuxieme joueur :</body></html>");
                JLabel vitMaxCoursePremier = new JLabel("<html><body>vitesse de course max premier joueur :</body></html>");
                JLabel vitMaxCourseDeuxieme = new JLabel("<html><body>vitesse de course max deuxieme joueur :</body></html>");

                JTextField dateMatchTennis2 = new JTextField();
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

                try {
                    String request = "SELECT * FROM matchs_tennis";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Date_match_t"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }


                    JComboBox<? extends String> modMT = new JComboBox<>(listPlayer);
                    modMT.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modMT.getSelectedItem()).toString();
                            String[] splited = player.split("  ");

                            dateMatchTennis2.setText(splited[0]);

                            String request112 = "SELECT * FROM matchs_tennis AS MT LEFT JOIN players_tennis AS PT on MT.Id_first_player_t = PT.Id_player_t left join players_tennis as PT2 on MT.Id_secondary_player_t = PT2.Id_player_t WHERE MT.Date_match_t = '" + dateMatchTennis2.getText() + "';";

                            PreparedStatement ps112 = db.prepareStatement(request112);

                            ResultSet rs112 = ps112.executeQuery(request112);

                            while (rs112.next()) {
                                location2.setText(rs112.getString("MT.Location_match_t"));
                                surface2.setText(rs112.getString("MT.Surface_t"));
                                premierTennisman2.setText(rs112.getString("PT.Name_player_t"));
                                deuxiemeTennisman2.setText(rs112.getString("PT2.Name_player_t"));
                                vitMaxTirPremier2.setText(rs112.getString("MT.Speed_shot_first_player_t"));
                                vitMaxTirDeuxieme2.setText(rs112.getString("MT.Speed_shot_secondary_player_t"));
                                vitMaxCoursePremier2.setText(rs112.getString("MT.Speedrun_first_player_t"));
                                vitMaxCourseDeuxieme2.setText(rs112.getString("MT.Speedrun_secondary_player_t"));
                                Result_match_first_player_t.setText(rs112.getString("MT.Result_match_first_player_t"));
                            }
                            rs112.close();
                            ps112.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modMT);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

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
                    SQLRequete.requeteModMatchTennis(db, nomm, prenomm, agee, equipeee, equipeeee, iddd, iddde, idddd, iddddd, Result_match_first_player);
                });

                panel.add(boutonValideHH);
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
                break;
            }
            case "modTF": {
                JLabel nomTeam = new JLabel("<html><body>nom de l'equipe :</body></html>");
                JLabel dateCrea = new JLabel("<html><body>date de creation :</body></html>");
                JLabel site = new JLabel("<html><body>site de l'equipe:</body></html>");

                JTextField nomTeam2 = new JTextField();
                nomTeam2.setColumns(10);
                JTextField dateCrea2 = new JTextField();
                dateCrea2.setColumns(10);
                JTextField site2 = new JTextField();
                site2.setColumns(10);

                try {
                    String request = "SELECT * FROM football_team";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();

                    while (rs.next()) {
                        values.add(rs.getString("Team_name"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }

                    JComboBox<? extends String> modTF = new JComboBox<>(listPlayer);
                    modTF.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modTF.getSelectedItem()).toString();
                            String[] splited = player.split("  ");

                            nomTeam2.setText(splited[0]);

                            String request113 = "SELECT * FROM football_team AS FT WHERE FT.Team_name = '" + nomTeam2.getText() + "';";

                            PreparedStatement ps113 = db.prepareStatement(request113);

                            ResultSet rs113 = ps113.executeQuery(request113);

                            while (rs113.next()) {
                                dateCrea2.setText(rs113.getString("FT.Team_create"));
                                site2.setText(rs113.getString("FT.Site_team"));
                            }
                            rs113.close();
                            ps113.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modTF);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                JButton boutonValideHH = new JButton("valide");
                boutonValideHH.setForeground(new Color(97, 40, 0));
                boutonValideHH.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nomTeam2.getText();
                    String prenomm = dateCrea2.getText();
                    String agee = site2.getText();

                    SQLRequete.requeteModTeamFoot(db, nomm, prenomm, agee);
                });

                panel.add(boutonValideHH);
                panel.add(nomTeam);
                panel.add(nomTeam2);
                panel.add(dateCrea);
                panel.add(dateCrea2);
                panel.add(site);
                panel.add(site2);
                break;
            }
            case "modCH": {
                JLabel date = new JLabel("<html><body>date et heure de la course :</body></html>");
                JLabel lieu = new JLabel("<html><body>lieu de la course :</body></html>");
                JLabel meteo = new JLabel("<html><body>meteo de la course :</body></html>");

                JTextField date2 = new JTextField();
                date2.setColumns(10);
                JTextField lieu2 = new JTextField();
                lieu2.setColumns(10);
                JTextField meteo2 = new JTextField();
                meteo2.setColumns(10);

                try {
                    String request = "SELECT * FROM race_hippiques";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Time_race"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }


                    JComboBox<? extends String> modCH = new JComboBox<>(listPlayer);
                    modCH.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modCH.getSelectedItem()).toString();
                            String[] splited = player.split("  ");

                            date2.setText(splited[0]);

                            String request114 = "SELECT * FROM race_hippiques AS RH WHERE RH.Time_race = '" + date2.getText() + "';";

                            PreparedStatement ps114 = db.prepareStatement(request114);

                            ResultSet rs114 = ps114.executeQuery(request114);

                            while (rs114.next()) {
                                lieu2.setText(rs114.getString("RH.Location_race"));
                                meteo2.setText(rs114.getString("RH.Weather_race"));
                            }
                            rs114.close();
                            ps114.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modCH);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                JButton boutonValideHH = new JButton("valide");
                boutonValideHH.setForeground(new Color(97, 40, 0));
                boutonValideHH.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = date2.getText();
                    String prenomm = lieu2.getText();
                    String agee = meteo2.getText();

                    SQLRequete.requeteModRaceHippique(db, nomm, prenomm, agee);
                });

                panel.add(boutonValideHH);
                panel.add(date);
                panel.add(date2);
                panel.add(lieu);
                panel.add(lieu2);
                panel.add(meteo);
                panel.add(meteo2);
                break;
            }
            case "modJH": {
                JLabel nom = new JLabel("<html><body>nom du jockey :</body></html>");
                JLabel prenom = new JLabel("<html><body>prenom du jockey :</body></html>");
                JLabel age = new JLabel("<html><body>age du jockey :</body></html>");
                JLabel poids = new JLabel("<html><body>poids du jockey:</body></html>");
                JLabel cheval = new JLabel("<html><body>nom de son cheval:</body></html>");

                JTextField nom2 = new JTextField();
                nom2.setColumns(10);
                JTextField prenom2 = new JTextField();
                prenom2.setColumns(10);
                JTextField age2 = new JTextField();
                age2.setColumns(10);
                JTextField poids2 = new JTextField();
                poids2.setColumns(10);
                JTextField cheval2 = new JTextField();
                cheval2.setColumns(10);

                try {
                    String request = "SELECT * FROM jockeys_hippique";

                    PreparedStatement ps = db.prepareStatement(request);

                    ResultSet rs = ps.executeQuery(request);
                    List<String> values = new ArrayList<>();


                    while (rs.next()) {
                        values.add(rs.getString("Name_jockey") + " " + rs.getString("Firstname_jockey"));
                    }
                    rs.close();
                    ps.close();

                    String[] listPlayer = new String[values.size()];
                    for (int i = 0; i < values.size(); i++) {
                        listPlayer[i] = values.get(i);
                    }


                    JComboBox<? extends String> modJH = new JComboBox<>(listPlayer);
                    modJH.addItemListener(itemEvent -> {
                        try {
                            String player = Objects.requireNonNull(modJH.getSelectedItem()).toString();
                            String[] splited = player.split("\\ ");

                            nom2.setText(splited[0]);
                            prenom2.setText(splited[1]);

                            String request115 = "SELECT * FROM jockeys_hippique AS JH LEFT JOIN chevaux_hippique AS CH on JH.Id_horse_j = CH.Id_horse WHERE JH.Name_jockey = '" + nom2.getText() + "' AND JH.Firstname_jockey = '" + prenom2.getText() + "';";

                            PreparedStatement ps115 = db.prepareStatement(request115);

                            ResultSet rs115 = ps115.executeQuery(request115);

                            while (rs115.next()) {
                                age2.setText(rs115.getString("JH.Age_jockey"));
                                poids2.setText(rs115.getString("JH.Weight_jockey"));
                                cheval2.setText(rs115.getString("CH.Name_horse"));
                            }
                            rs115.close();
                            ps115.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });
                    panel.add(modJH);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                JButton boutonValideHH = new JButton("valide");
                boutonValideHH.setForeground(new Color(97, 40, 0));
                boutonValideHH.addActionListener(e -> {
                    //your actions
                    panel.setVisible(false);
                    String nomm = nom2.getText();
                    String prenomm = prenom2.getText();
                    String agee = age2.getText();
                    String datevetoo = poids2.getText();
                    String chevall = cheval2.getText();

                    SQLRequete.requeteModJockeyHippique(db, nomm, prenomm, agee, datevetoo, chevall);
                });

                panel.add(boutonValideHH);
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
                break;
            }
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
        text1.setForeground(new Color(255, 255, 255));
        text1.setForeground(new Color(225,225,225));

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
        boutonmodifH.addActionListener(e -> {
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

        List<String> valuesMF;
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
