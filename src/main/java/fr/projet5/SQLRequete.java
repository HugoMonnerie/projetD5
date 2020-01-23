package fr.projet5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLRequete
{
    int i=0;

    public String nbTitulaireFoot(Connection db, String name){
        String request2 = "SELECT COUNT(Titulaire_player_f) as Nbr_Titulaire FROM football_player Left Join football_team as FT on football_player.J_id_team_f = FT.Id_team_f where FT.Team_name = " + "'"+name+"'" + " and Titulaire_player_f = 'titulaire' ;" ;

        try{
            PreparedStatement ps2 = db.prepareStatement(request2);
            ResultSet rs2 = ps2.executeQuery(request2);
            String result2 = "";

            while (rs2.next())
            {
                result2 = rs2.getString("Nbr_Titulaire");
            }

            rs2.close();
            ps2.close();
            return result2 ;
        }catch (Exception e){

        }
        return null;
    }

    public String nbPlayerFoot(Connection db, String name){
        String request2 = "SELECT COUNT(Name_player_f) as Nbr_Player FROM football_player Left Join football_team as FT on football_player.J_id_team_f = FT.Id_team_f where FT.Team_name = " + "'"+name+"';" ;

        try{
            PreparedStatement ps2 = db.prepareStatement(request2);
            ResultSet rs2 = ps2.executeQuery(request2);
            String result2 = "";

            while (rs2.next())
            {
                result2 = rs2.getString("Nbr_Player");
            }

            rs2.close();
            ps2.close();
            return result2 ;
        }catch (Exception e){

        }
        return null;
    }

    public List<String> requeteTeamFoot(Connection db, String name){
        try {
            String request = "SELECT * FROM football_team AS FT where FT.Team_name =" + "'" + name + "';" ;

            PreparedStatement ps = db.prepareStatement(request);
            ResultSet rs = ps.executeQuery(request);

            List<String> liste = new ArrayList<>();

            while (rs.next())
            {
                liste.add(rs.getString("Team_name"));
                liste.add(rs.getString("Team_create"));
                liste.add(rs.getString("Site_team"));
                liste.add(new SQLRequete().nbTitulaireFoot(db, name));
                liste.add(new SQLRequete().nbPlayerFoot(db, name));
            }
            rs.close();
            ps.close();

            return liste;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> requetePlayerFoot(Connection db, String name)
    {
        try {
            String request2 = "SELECT COUNT(Titulaire_player_f) as Nbr_Titulaire FROM football_player Left Join football_team as FT on football_player.J_id_team_f = FT.Id_team_f where FT.Team_name = " + "'"+name+"'" + " and Titulaire_player_f = 'titulaire' ;" ;
            String request3 = "SELECT * FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f where FT.Team_name  = " + "'"+name+"';";

            PreparedStatement ps2 = db.prepareStatement(request2);
            PreparedStatement ps3 = db.prepareStatement(request3);

            ResultSet rs2 = ps2.executeQuery(request2);
            ResultSet rs3 = ps3.executeQuery(request3);

            List<String> liste = new ArrayList<>();

            while (rs3.next())
            {
                liste.add(rs3.getString("FP.Name_player_f"));
                liste.add(rs3.getString("FP.Age_player_f"));
                liste.add(rs3.getString("FP.Titulaire_player_f"));

            }
            rs3.close();
            ps3.close();

            return liste;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> requeteMatchFoot(Connection db, String name){

        try {
            String request = "SELECT count(MT.Id_team_inside_f) as nb_win_inside FROM matchs_football AS MT LEFT JOIN football_team AS FT ON FT.Id_team_f = MT.Id_team_inside_f WHERE MT.Nbr_but_inside_f>MT.Nbr_but_outside_f AND FT.Team_name =  " + "'"+name+"';";

            String request2 = "SELECT count(MT.Id_team_outside_f) as nb_win_outside FROM matchs_football AS MT LEFT JOIN football_team AS FT ON FT.Id_team_f = MT.Id_team_outside_f WHERE MT.Nbr_but_inside_f<MT.Nbr_but_outside_f AND FT.Team_name =  " + "'"+name+"';";

            String request3 = "SELECT count(tab.id) as nb_team_fight FROM (SELECT  MF.Id_team_inside_f+MF.Id_team_outside_f as id , MF.Id_team_inside_f, MF.Id_team_outside_f FROM matchs_football AS MF LEFT JOIN football_team AS FT ON MF.Id_team_inside_f = FT.Id_team_f LEFT JOIN football_team as FT2 ON MF.Id_team_outside_f = FT2.Id_team_f WHERE FT.Team_name = "+"'"+name+"'"+" OR FT2.Team_name = "+"'"+name+"'"+" GROUP BY id) as tab;";

            String request4 = "SELECT tab1.Name_team_adv ,tab2.Name_team_adv FROM football_team AS FT LEFT JOIN (SELECT tabBut.id as id, FT.Team_name as Name_team ,max(tabBut.but) as but, FT2.Team_name as Name_team_adv FROM (SELECT Id_team_inside_f as id, Nbr_but_inside_f as but, Id_team_outside_f as id_adv FROM matchs_football UNION SELECT Id_team_outside_f, Nbr_but_outside_f, Id_team_inside_f FROM matchs_football order by but DESC) as tabBut LEFT JOIN football_team as FT ON tabBut.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut.id_adv=FT2.Id_team_f GROUP BY id) AS tab1 ON FT.Id_team_f=tab1.id LEFT JOIN (SELECT tabBut2.id as id, FT.Team_name as Name_team ,max(tabBut2.but) as but,FT2.Team_name as Name_team_adv FROM (SELECT Id_team_outside_f as id, Nbr_but_inside_f as but , Id_team_inside_f as id_adv FROM matchs_football UNION SELECT Id_team_inside_f, Nbr_but_outside_f, Id_team_outside_f FROM matchs_football ORDER BY but DESC) as tabBut2 LEFT JOIN football_team as FT ON tabBut2.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut2.id_adv=FT2.Id_team_f GROUP BY id) AS tab2 ON FT.Id_team_f=tab2.id WHERE FT.Team_name = " + "'"+name+"';";


            PreparedStatement ps = db.prepareStatement(request);
            PreparedStatement ps2 = db.prepareStatement(request2);
            PreparedStatement ps3 = db.prepareStatement(request3);
            PreparedStatement ps4 = db.prepareStatement(request4);

            ResultSet rs = ps.executeQuery(request);
            ResultSet rs2 = ps2.executeQuery(request2);
            ResultSet rs3 = ps3.executeQuery(request3);
            ResultSet rs4 = ps4.executeQuery(request4);

            List<String> liste = new ArrayList<>();

            while (rs.next())
            {
                liste.add(rs.getString("nb_win_inside"));
            }
            rs.close();
            ps.close();

            while (rs2.next())
            {
                liste.add(rs2.getString("nb_win_outside"));
            }
            rs2.close();
            ps2.close();

            while (rs3.next())
            {
                liste.add(rs3.getString("nb_team_fight"));
            }
            rs3.close();
            ps3.close();

            while (rs4.next())
            {
                liste.add(rs4.getString("tab1.Name_team_adv"));
                liste.add(rs4.getString("tab2.Name_team_adv"));
            }
            rs4.close();
            ps4.close();

            return liste;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<String> requetePlayerTennis(Connection db,String name)
    {
        try {
        String request = "SELECT * FROM players_tennis AS PT where PT.Name_player_t  = " + "'" +name+"';" ;

        PreparedStatement ps = db.prepareStatement(request);

        ResultSet rs = ps.executeQuery(request);

        List<String> liste = new ArrayList<>();

        while (rs.next())
        {
            liste.add(rs.getString("Name_player_t"));
            liste.add(rs.getString("Firstname_player_t"));
            liste.add(rs.getString("Age_player_t"));
            liste.add(rs.getString("Nbr_medal_t"));
        }
        rs.close();
        ps.close();

        return liste;
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }

    public List<String> requeteMatchTennis(Connection db,String name)
    {
        try {
            String request = "SELECT PT.Firstname_player_t,PT.Name_player_t, PT.Age_player_t, COUNT(MT.`Id_first_player_t`) AS NBR_Win, tab.nb AS NBR_Loose,PT.Nbr_medal_t,tabVit.max_v_frappe as vitesse_frappe_max,tabVit.max_v_course as vitesse_max FROM players_tennis as PT LEFT JOIN matchs_tennis as MT ON MT.Id_first_player_t = PT.Id_player_t LEFT JOIN (SELECT MT.Id_secondary_player_t as Id, COUNT(MT.Id_secondary_player_t) as nb FROM matchs_tennis as MT GROUP BY MT.Id_secondary_player_t )as tab ON tab.Id = PT.Id_player_t LEFT JOIN (SELECT tabV.id, max(tabV.v_frappe) as max_v_frappe, max(tabV.v_course) as max_v_course FROM (SELECT Id_first_player_t as id, Speed_shot_first_player_t as v_frappe, Speedrun_first_player_t as v_course FROM matchs_tennis UNION SELECT Id_secondary_player_t, Speed_shot_secondary_player_t, Speedrun_secondary_player_t FROM matchs_tennis) as tabV GROUP BY id) as tabVit ON tabVit.id=PT.Id_player_t where PT.Name_player_t  = "+"'"+name+"'"+" GROUP BY PT.Id_player_t order by PT.Name_player_t ASC;" ;

            PreparedStatement ps = db.prepareStatement(request);

            ResultSet rs = ps.executeQuery(request);

            List<String> liste = new ArrayList<>();

            while (rs.next())
            {
                liste.add(rs.getString("NBR_Win"));
                liste.add(rs.getString("NBR_Loose"));
                liste.add(rs.getString("vitesse_frappe_max"));
                liste.add(rs.getString("vitesse_max"));
            }
            rs.close();
            ps.close();

            return liste;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> requeteHorseJockey(Connection db, String name)
    {
        try {
            String request = "SELECT * FROM chevaux_hippique AS CH LEFT JOIN jockeys_hippique AS JH ON JH.Id_horse_j = CH.Id_horse where CH.Name_horse  = " + "'" +name+"';" ;

            PreparedStatement ps = db.prepareStatement(request);

            ResultSet rs = ps.executeQuery(request);

            List<String> liste = new ArrayList<>();

            while (rs.next())
            {
                liste.add(rs.getString("Name_horse"));
                liste.add(rs.getString("Age_horse"));
                liste.add(rs.getString("Picture_horse"));
                liste.add(rs.getString("Date_veterinaire"));
                liste.add(rs.getString("Name_jockey"));
                liste.add(rs.getString("Firstname_jockey"));
                liste.add(rs.getString("Age_jockey"));
                liste.add(rs.getString("Weight_jockey"));
            }
            rs.close();
            ps.close();

            return liste;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> requeteRaceHippique(Connection db, String name)
    {
        try {
            String request = "SELECT * FROM classement_horse_race AS CHH LEFT JOIN race_hippiques as RH ON CHH.Id_race_c = RH.Id_race LEFT JOIN chevaux_hippique as CH ON CH.Id_horse = CHH.Id_horse_c where CH.Name_horse  = " + "'" +name+"'"+"ORDER BY CHH.Speed_horse DESC ;" ;
            String request2 = "SELECT tab1.UN AS premier, tab2.TROIS AS podium, Looser.Loose FROM chevaux_hippique AS CH LEFT JOIN classement_horse_race AS CHH ON CH.Id_horse = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id,COUNT(CHH.Classement_horse) AS UN FROM classement_horse_race AS CHH WHERE CHH.Classement_horse = 1 GROUP BY CHH.Id_horse_c )AS tab1 ON tab1.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS TROIS FROM classement_horse_race AS CHH WHERE CHH.Classement_horse <= 3 GROUP BY CHH.Id_horse_c ) AS tab2 ON tab2.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS Loose FROM classement_horse_race AS CHH WHERE CHH.Classement_horse > 3 GROUP BY CHH.Id_horse_c )AS Looser On Looser.Id = CHH.Id_horse_c GROUP BY CH.Id_horse where CH.Name_horse  = " + "'" +name+"'"+"ORDER BY premier ASC;" ;

            PreparedStatement ps = db.prepareStatement(request);
            PreparedStatement ps2 = db.prepareStatement(request2);

            ResultSet rs = ps.executeQuery(request);
            ResultSet rs2 = ps2.executeQuery(request2);

            List<String> liste = new ArrayList<>();

            while (rs.next())
            {
                liste.add(rs.getString("CHH.Speed_horse"));
            }
            rs.close();
            ps.close();

            while (rs2.next())
            {
                liste.add(rs2.getString("premier"));
                liste.add(rs2.getString("podium"));
                liste.add(rs2.getString("Looser.Loose"));
            }
            rs2.close();
            ps2.close();


            return liste;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
