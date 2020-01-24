package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TableTeamFoot implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     * @param nom_team
     * @param date
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
