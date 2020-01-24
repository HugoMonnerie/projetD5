package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class TableHorseJockey implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     * @param Name_horse
     * @param Age_horse
     * @param Picture_horse
     * @param Date_veterinaire
     * @param Name_jockey
     * @param Firstname_jockey
     * @param Age_jockey
     * @param Weight_jockey
     * */
    public TableHorseJockey(String Name_horse, String Age_horse, String Picture_horse, String Date_veterinaire, String Name_jockey, String Firstname_jockey, String Age_jockey, String Weight_jockey) {
        super();

        this.listValues.add(Name_horse);
        this.listValues.add(Age_horse);
        this.listValues.add(Picture_horse);
        this.listValues.add(Date_veterinaire);
        this.listValues.add(Name_jockey);
        this.listValues.add(Firstname_jockey);
        this.listValues.add(Age_jockey);
        this.listValues.add(Weight_jockey);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
