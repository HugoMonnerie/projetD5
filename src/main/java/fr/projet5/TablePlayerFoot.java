package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TablePlayerFoot implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     * @param nom_joueur
     * @param age_joueur
     * @param titulaire
     */
    public TablePlayerFoot(String nom_joueur, String age_joueur, String titulaire) {
        super();

        this.listValues.add(nom_joueur);
        this.listValues.add(age_joueur);
        this.listValues.add(titulaire);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
