package fr.projet5;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import jdk.jfr.internal.cmd.Execute;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    JPanel buildContentPane(JFrame fen){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");

        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        this.utilisateur = new JTextField();
        utilisateur.setColumns(10);

        this.mdp = new JPasswordField();
        mdp.setColumns(10);

        new JButton("Connection");
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
        setJMenuBar();

        menuBar.add(option1);

        option1.add(quitter);

        menuBar.add(option2);

        option2.add(aide);

        option2.add(question);

        return panel;
    }

    private void setJMenuBar() {
    }

    public JPanel buildContentPane2(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Type de parie :</body></html>");

        JButton bouton1 = new JButton("Football");
        bouton1.addActionListener(e -> {
            //your actions
            String content = "select * from football_player ; select * from football_team; select * from matchs_football;";

            File file = new File("/Users/souksou/Desktop/projet 5/projetD5/src/main/resources/db/1cf3f972-69bc-4297-b7f2-a83d7b88cc16/console.sql");

            // créer le fichier s'il n'existe pas


            FileWriter fw = null;
            try {
                fw = new FileWriter(file.getAbsoluteFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            assert fw != null;
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                bw.write(content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("Modification terminée!");
        });

        JButton bouton2 = new JButton("Tennis");
        bouton2.addActionListener(e -> {
            //your actions

        });

        JButton bouton3 = new JButton("Hippique");
        bouton3.addActionListener(e -> {
            //your actions
        });

        //affichage

        panel.add(text1);

        panel.add(bouton1);

        panel.add(bouton2);

        panel.add(bouton3);
        panel.setVisible(true);

        return panel;
    }

}