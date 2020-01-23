package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like cargo's Id,
 * country from where it go and where it was/will arrive or depart's and arrive's date.
 */
public class TableRaceHippique implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableCargoDetails constructor, used to set all the column values of our table
     * @param
     * */
    public TableRaceHippique(String Name_horse, String Age_horse, String Picture_horse, String Date_veterinaire) {
        super();

        this.listValues.add(Name_horse);
        this.listValues.add(Age_horse);
        this.listValues.add(Picture_horse);
        this.listValues.add(Date_veterinaire);


    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
