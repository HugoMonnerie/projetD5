package fr.projet5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RecupChamps extends AbstractAction {
    private Panneau panneau;

    public RecupChamps(Panneau panneau, String texte){
        super(texte);

        this.panneau = panneau;
    }

    public void actionPerformed(ActionEvent e) {
        String champ1 = panneau.getUtilisateur();//On récupère la valeur dans le premier champ

        String champ2 = panneau.getMdp();//On récupère la valeur dans le deuxième champ

    }

}
