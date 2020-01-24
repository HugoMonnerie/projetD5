package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TablePlayerTennis implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     * @param nom_joueur
     * @param prenom_joueur
     * @param age_joueur
     * @param nb_medailles
     */
    public TablePlayerTennis(String nom_joueur, String prenom_joueur, String age_joueur, String nb_medailles) {
        super();

        this.listValues.add(nom_joueur);
        this.listValues.add(prenom_joueur);
        this.listValues.add(age_joueur);
        this.listValues.add(nb_medailles);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
