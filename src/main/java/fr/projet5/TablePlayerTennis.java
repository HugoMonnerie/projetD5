package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like cargo's Id,
 * country from where it go and where it was/will arrive or depart's and arrive's date.
 */
public class TablePlayerTennis implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableCargoDetails constructor, used to set all the column values of our table
     * @param nom_joueur id of the cargo
     * @param prenom_joueur
     * @param age_joueur Name of country of departure
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
