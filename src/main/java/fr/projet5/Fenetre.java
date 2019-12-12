package fr.projet5;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public Fenetre(){
        this.setTitle("MySQL");
        this.setSize(1100, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panneau panneau = new Panneau();
        this.setContentPane(panneau.buildContentPane());

        this.setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel text1 = new JLabel("<html><body>Utilisateur :</body></html>");

        JLabel text2 = new JLabel("<html><body>Mot de passe :</body></html>");

        JTextField utilisateur = new JTextField();
		utilisateur.setColumns(10);

		JTextField mdp = new JTextField();
		mdp.setColumns(10);

		JButton bouton = new JButton("Connection");

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

}