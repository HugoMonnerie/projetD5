package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TableRaceHippique implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     * @param Speed_horse
     * @param nb_premier
     * @param nb_podium
     * @param nb_loose
     * */
    public TableRaceHippique(String Speed_horse, String nb_premier, String nb_podium, String nb_loose) {
        super();

        this.listValues.add(Speed_horse);
        this.listValues.add(nb_premier);
        this.listValues.add(nb_podium);
        this.listValues.add(nb_loose);


    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
