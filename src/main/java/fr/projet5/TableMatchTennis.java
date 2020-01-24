package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TableMatchTennis implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
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
