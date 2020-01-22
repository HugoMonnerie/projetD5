package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like cargo's Id,
 * country from where it go and where it was/will arrive or depart's and arrive's date.
 */
public class TableMatchTennis implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableCargoDetails constructor, used to set all the column values of our table
     * @param NBR_Win
     * @param NBR_Loose
     * @param vitesse_frappe_max
     * @param vitesse_max
     */
    public TableMatchTennis(String NBR_Win, String NBR_Loose, String vitesse_frappe_max, String vitesse_max) {
        super();

        this.listValues.add(NBR_Win);
        this.listValues.add(NBR_Loose);
        this.listValues.add(vitesse_frappe_max);
        this.listValues.add(vitesse_max);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
