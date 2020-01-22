package fr.projet5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like cargo's Id,
 * country from where it go and where it was/will arrive or depart's and arrive's date.
 */
public class TableMatchFoot implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableCargoDetails constructor, used to set all the column values of our table
     * @param nb_win_inside
     * @param nb_win_outside
     * @param nb_team_fight
     * @param team_max_but_win
     * @param team_max_but_loose
     * */
    public TableMatchFoot(String nb_win_inside, String nb_win_outside, String nb_team_fight, String team_max_but_win, String team_max_but_loose) {
        super();

        this.listValues.add(nb_win_inside);
        this.listValues.add(nb_win_outside);
        this.listValues.add(nb_team_fight);
        this.listValues.add(team_max_but_win);
        this.listValues.add(team_max_but_loose);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
