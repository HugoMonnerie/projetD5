package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like cargo's Id,
 * country from where it go and where it was/will arrive or depart's and arrive's date.
 */
public class TableTeamFoot implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableCargoDetails constructor, used to set all the column values of our table
     * @param nom_team id of the cargo
     * @param date Name of country of departure
     * @param site
     * @param nb_titulaire
     * @param nb_player
     */
    public TableTeamFoot(String nom_team, String date, String site, String nb_titulaire, String nb_player) {
        super();

        this.listValues.add(nom_team);
        this.listValues.add(date);
        this.listValues.add(site);
        this.listValues.add(nb_titulaire);
        this.listValues.add(nb_player);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
