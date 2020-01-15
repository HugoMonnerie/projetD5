package fr.projet5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLRequete
{

    public String dispatch(Connection db, String name, int index)
    {
        if(index == 1)
        {
            return requetefoot(db, name);
        }
        else if(index == 2)
        {
            return requeteTennis(db, name);
        }
        else if(index == 3)
        {
            return requeteHippique(db, name);
        }
        else
        {
            System.out.println("ERROR INDEX");
            return "error";
        }
    }
    public String  requetefoot(Connection db,String name)
    {
        try {
            String request = "SELECT * FROM football_team AS FT where FT.Team_name  = " + "'" +name+"';" ;
            String request2 = "SELECT COUNT(Titulaire_player_f) as Nbr_Titulaire FROM football_player Left Join football_team as FT on football_player.J_id_team_f = FT.Id_team_f where FT.Team_name = " + "'"+name+"'" + " and Titulaire_player_f = 'titulaire' ;" ;
            String request3 = "SELECT FP.Name_player_f,  FP.Age_player_f FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f where FT.Team_name  = " + "'"+name+"';";
            String request4 = "SELECT COUNT(FP.Name_player_f) as Nbr_Player FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f where FT.Team_name  = " + "'"+name+"';";
            String request5 = "SELECT COUNT(Team_name)-1 as Nbr_team FROM football_team ;";
            String request6 = "SELECT tab1.Name_team,tab1.but, tab1.Name_team_adv ,tab2.Name_team_adv, tab2.but FROM football_team AS FT LEFT JOIN (SELECT tabBut.id as id, FT.Team_name as Name_team ,max(tabBut.but) as but, FT2.Team_name as Name_team_adv FROM (SELECT Id_team_inside_f as id, Nbr_but_inside_f as but, Id_team_outside_f as id_adv FROM matchs_football UNION SELECT Id_team_outside_f, Nbr_but_outside_f, Id_team_inside_f FROM matchs_football order by but DESC) as tabBut LEFT JOIN football_team as FT ON tabBut.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut.id_adv=FT2.Id_team_f GROUP BY id) AS tab1f ON FT.Id_team_f=tab1.id LEFT JOIN (SELECT tabBut2.id as id, FT.Team_name as Name_team ,max(tabBut2.but) as but, FT2.Team_name as Name_team_adv FROM (SELECT Id_team_outside_f as id, Nbr_but_inside_f as but , Id_team_inside_f as id_adv FROM matchs_football UNION SELECT Id_team_inside_f, Nbr_but_outside_f, Id_team_outside_f FROM matchs_football ORDER BY but DESC) as tabBut2 LEFT JOIN football_team as FT ON tabBut2.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut2.id_adv=FT2.Id_team_f GROUP BY id) AS tab2 ON FT.Id_team_f=tab2.id;";

            System.out.println(request);
            System.out.println(request2);
            System.out.println(request3);
            System.out.println(request4);
            System.out.println(request5);
            System.out.println(request6);

            PreparedStatement ps = db.prepareStatement(request);
            PreparedStatement ps2 = db.prepareStatement(request2);
            PreparedStatement ps3 = db.prepareStatement(request3);
            PreparedStatement ps4 = db.prepareStatement(request4);
            PreparedStatement ps5 = db.prepareStatement(request5);
            PreparedStatement ps6 = db.prepareStatement(request6);

            ResultSet rs = ps.executeQuery(request);
            ResultSet rs2 = ps2.executeQuery(request2);
            ResultSet rs3 = ps3.executeQuery(request3);
            ResultSet rs4 = ps4.executeQuery(request4);
            ResultSet rs5 = ps5.executeQuery(request5);
            ResultSet rs6 = ps6.executeQuery(request6);

            String result = "";
            while (rs.next())
            {
                result = rs.getString("Team_Name");
                System.out.println(result  + "\n");
            }
            result = result +"\n";
            rs.close();
            ps.close();
            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "error";
    }
    public String requeteTennis(Connection db,String name)
    {

        return "error";
    }
    public String requeteHippique(Connection db,String name)
    {

        return "error";
    }
}