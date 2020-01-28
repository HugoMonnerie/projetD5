package fr.projet5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLRequete {
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

    public List<String> requetePlayerFoot(Connection db, String name){
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

    public List<String> requetePlayerTennis(Connection db,String name){
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

    public List<String> requeteMatchTennis(Connection db,String name){
        try {
            String request = "SELECT PT.Firstname_player_t,PT.Name_player_t, PT.Age_player_t, COUNT(MT.'Id_first_player_t') AS NBR_Win, tab.nb AS NBR_Loose,PT.Nbr_medal_t,tabVit.max_v_frappe as vitesse_frappe_max,tabVit.max_v_course as vitesse_max FROM players_tennis as PT LEFT JOIN matchs_tennis as MT ON MT.Id_first_player_t = PT.Id_player_t LEFT JOIN (SELECT MT.Id_secondary_player_t as Id, COUNT(MT.Id_secondary_player_t) as nb FROM matchs_tennis as MT GROUP BY MT.Id_secondary_player_t )as tab ON tab.Id = PT.Id_player_t LEFT JOIN (SELECT tabV.id, max(tabV.v_frappe) as max_v_frappe, max(tabV.v_course) as max_v_course FROM (SELECT Id_first_player_t as id, Speed_shot_first_player_t as v_frappe, Speedrun_first_player_t as v_course FROM matchs_tennis UNION SELECT Id_secondary_player_t, Speed_shot_secondary_player_t, Speedrun_secondary_player_t FROM matchs_tennis) as tabV GROUP BY id) as tabVit ON tabVit.id=PT.Id_player_t where PT.Name_player_t  = "+"'"+name+"'"+" GROUP BY PT.Id_player_t order by PT.Name_player_t ASC;" ;

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

    public List<String> requeteHorseJockey(Connection db, String name){
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

    public List<String> requeteRaceHippique(Connection db, String name){
        try {
            String request = "SELECT * FROM classement_horse_race AS CHH LEFT JOIN race_hippiques as RH ON CHH.Id_race_c = RH.Id_race LEFT JOIN chevaux_hippique as CH ON CH.Id_horse = CHH.Id_horse_c where CH.Name_horse  = " + "'" +name+"'"+" ORDER BY CHH.Speed_horse DESC ;" ;
            String request2 = "SELECT tab1.UN AS premier, tab2.TROIS AS podium, Looser.Loose FROM chevaux_hippique AS CH LEFT JOIN classement_horse_race AS CHH ON CH.Id_horse = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id,COUNT(CHH.Classement_horse) AS UN FROM classement_horse_race AS CHH WHERE CHH.Classement_horse = 1 GROUP BY CHH.Id_horse_c )AS tab1 ON tab1.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS TROIS FROM classement_horse_race AS CHH WHERE CHH.Classement_horse <= 3 GROUP BY CHH.Id_horse_c ) AS tab2 ON tab2.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS Loose FROM classement_horse_race AS CHH WHERE CHH.Classement_horse > 3 GROUP BY CHH.Id_horse_c )AS Looser On Looser.Id = CHH.Id_horse_c where CH.Name_horse  = " + "'" +name+"'"+" GROUP BY CH.Id_horse ORDER BY premier ASC;" ;

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


    public static void requeteAddTeamFoot(Connection db, String Team_name, String Team_create, String Site_team){
        String request = "INSERT INTO 'football_team'('Team_name', 'Team_create', 'Site_team') VALUES (?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Team_name);
            ps.setString(2, Team_create);
            ps.setString(3, Site_team);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelTeamFoot(Connection db, String id){
        String request = "DELETE FROM 'football_team' WHERE 'Id_team_f' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModTeamFoot(Connection db, String id, String Team_name, String Team_create, String Site_team){
    String request = "UPDATE 'football_team' SET 'Team_name'=?,'Team_create'=?,'Site_team'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Team_name);
            ps.setString(2, Team_create);
            ps.setString(3, Site_team);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddPlayerFoot(Connection db, String Name_player_f, String Firstname_player_f, String Age_player_f, int J_id_team_f, String Titulaire_player_f){
        String request = "INSERT INTO 'football_player'('Name_player_f', 'Firstname_player_f', 'Age_player_f', 'J_id_team_f', 'Titulaire_player_f') VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_player_f);
            ps.setString(2, Firstname_player_f);
            ps.setString(3, Age_player_f);
            ps.setInt(4, J_id_team_f);
            ps.setString(5, Titulaire_player_f);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelPlayerFoot(Connection db, String id){
        String request = "DELETE FROM 'football_player' WHERE 'Id_player_f' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModPlayerFoot(Connection db, String id, String Name_player_f, String Firstname_player_f, String Age_player_f, int J_id_team_f, String Titulaire_player_f){
        String request = "UPDATE 'football_player' SET 'Name_player_f'=?,'Firstname_player_f'=?,'Age_player_f'=?, 'J_id_team_f'=?, 'Titulaire_player_f'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_player_f);
            ps.setString(2, Firstname_player_f);
            ps.setString(3, Age_player_f);
            ps.setInt(4, J_id_team_f);
            ps.setString(5, Titulaire_player_f);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddMatchFoot(Connection db, String Date_match_f, int Id_team_inside_f, int Id_team_outside_f, int Nbr_but_inside_f, int Nbr_but_outside_f){
        String request = "INSERT INTO 'matchs_football'('Date_match_f', 'Id_team_inside_f', 'Id_team_outside_f', 'Nbr_but_inside_f', 'Nbr_but_outside_f') VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Date_match_f);
            ps.setInt(2, Id_team_outside_f);
            ps.setInt(3, Id_team_inside_f);
            ps.setInt(4, Nbr_but_inside_f);
            ps.setInt(5, Nbr_but_outside_f);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelMatchFoot(Connection db, String id){
        String request = "DELETE FROM 'matchs_football' WHERE 'Id_match_f' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModMatchFoot(Connection db, String id, String Date_match_f, int Id_team_inside_f, int Id_team_outside_f, int Nbr_but_inside_f, int Nbr_but_outside_f){
        String request = "UPDATE 'matchs_football' SET 'Date_match_f'=?, 'Id_team_inside_f'=?, 'Id_team_outside_f'=?, 'Nbr_but_inside_f'=?, 'Nbr_but_outside_f'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Date_match_f);
            ps.setInt(2, Id_team_outside_f);
            ps.setInt(3, Id_team_inside_f);
            ps.setInt(4, Nbr_but_inside_f);
            ps.setInt(5, Nbr_but_outside_f);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddPlayerTennis(Connection db, String Name_player_t, String Firstname_player_t, int Age_player_t, int Nbr_medal_t){
        String request = "INSERT INTO 'players_tennis'('Name_player_t', 'Firstname_player_t', 'Age_player_t', 'Nbr_medal_t') VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_player_t);
            ps.setString(2, Firstname_player_t);
            ps.setInt(3, Age_player_t);
            ps.setInt(4, Nbr_medal_t);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelPlayerTennis(Connection db, String id){
        String request = "DELETE FROM 'players_tennis' WHERE 'Id_player_t' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModPlayerTennis(Connection db, String id, String Name_player_t, String Firstname_player_t, int Age_player_t, int Nbr_medal_t){
        String request = "UPDATE 'players_tennis' SET 'Name_player_t'=?, 'Firstname_player_t'=?, 'Age_player_t'=?, 'Nbr_medal_t'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_player_t);
            ps.setString(2, Firstname_player_t);
            ps.setInt(3, Age_player_t);
            ps.setInt(4, Nbr_medal_t);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddMatchTennis(Connection db, String Date_match_t, String Location_match_t, String Surface_t, int Id_first_player_t, int Id_secondary_player_t, int Speed_shot_first_player_t, int Speed_shot_secondary_player_t, int Speedrun_first_player_t, int Speedrun_secondary_player_t, int Result_match_first_player_t){
        String request = "INSERT INTO 'matchs_tennis'('Date_match_t', 'Location_match_t', 'Surface_t', 'Id_first_player_t', 'Id_secondary_player_t', 'Speed_shot_first_player_t', 'Speed_shot_secondary_player_t', 'Speedrun_first_player_t', 'Speedrun_secondary_player_t', 'Result_match_first_player_t') VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Date_match_t);
            ps.setString(2, Location_match_t);
            ps.setString(3, Surface_t);
            ps.setInt(4, Id_first_player_t);
            ps.setInt(5, Id_secondary_player_t);
            ps.setInt(6, Speed_shot_first_player_t);
            ps.setInt(7, Speed_shot_secondary_player_t);
            ps.setInt(8, Speedrun_first_player_t);
            ps.setInt(9, Speedrun_secondary_player_t);
            ps.setInt(10, Result_match_first_player_t);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelMatchTennis(Connection db, String id){
        String request = "DELETE FROM 'matchs_tennis' WHERE 'Id_match_t' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModMatchTennis(Connection db, String id, String Date_match_t, String Location_match_t, String Surface_t, int Id_first_player_t, int Id_secondary_player_t, int Speed_shot_first_player_t, int Speed_shot_secondary_player_t, int Speedrun_first_player_t, int Speedrun_secondary_player_t, int Result_match_first_player_t){
        String request = "UPDATE 'matchs_tennis' SET 'Date_match_t'=?, 'Location_match_t'=?, 'Surface_t'=?, 'Id_first_player_t'=?, 'Id_secondary_player_t'=?, 'Speed_shot_first_player_t'=?, 'Speed_shot_secondary_player_t'=?, 'Speedrun_first_player_t'=?, 'Speedrun_secondary_player_t'=?, 'Result_match_first_player_t'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Date_match_t);
            ps.setString(2, Location_match_t);
            ps.setString(3, Surface_t);
            ps.setInt(4, Id_first_player_t);
            ps.setInt(5, Id_secondary_player_t);
            ps.setInt(6, Speed_shot_first_player_t);
            ps.setInt(7, Speed_shot_secondary_player_t);
            ps.setInt(8, Speedrun_first_player_t);
            ps.setInt(9, Speedrun_secondary_player_t);
            ps.setInt(10, Result_match_first_player_t);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddChevauxHippique(Connection db, String Name_horse, int Age_horse, String Picture_horse, String Date_veterinaire){
        String request = "INSERT INTO 'chevaux_hippique'('Name_horse', 'Age_horse', 'Picture_horse', 'Date_veterinaire') VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_horse);
            ps.setInt(2, Age_horse);
            ps.setString(3, Picture_horse);
            ps.setString(4, Date_veterinaire);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelChevauxHippique(Connection db, String id){
        String request = "DELETE FROM 'chevaux_hippique' WHERE 'Id_horse' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModChevauxHippique(Connection db, String id, String Name_horse, int Age_horse, String Picture_horse, String Date_veterinaire){
        String request = "UPDATE 'chevaux_hippique' SET 'Name_horse'=?, 'Age_horse'=?, 'Picture_horse'=?, 'Date_veterinaire'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_horse);
            ps.setInt(2, Age_horse);
            ps.setString(3, Picture_horse);
            ps.setString(4, Date_veterinaire);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddJockeyHippique(Connection db, String Name_jockey, String Firstname_jockey, int Age_jockey, int Weight_jockey, int Id_horse_j) {
        String request = "INSERT INTO 'jockeys_hippique'('Name_jockey', 'Firstname_jockey', 'Age_jockey', 'Weight_jockey', 'Id_horse_j') VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_jockey);
            ps.setString(2, Firstname_jockey);
            ps.setInt(3, Age_jockey);
            ps.setInt(4, Weight_jockey);
            ps.setInt(5, Id_horse_j);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelJockeyHippique(Connection db, String id){
        String request = "DELETE FROM 'jockeys_hippique' WHERE 'Id_jockey' ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModJockeyHippique(Connection db, String id, String Name_jockey, String Firstname_jockey, int Age_jockey, int Weight_jockey, int Id_horse_j){
        String request = "UPDATE 'jockeys_hippique' SET 'Name_jockey'=?, 'Firstname_jockey'=?, 'Age_jockey'=?, 'Weight_jockey'=?, 'Id_horse_j'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Name_jockey);
            ps.setString(2, Firstname_jockey);
            ps.setInt(3, Age_jockey);
            ps.setInt(4, Weight_jockey);
            ps.setInt(5, Id_horse_j);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteAddRaceHippique(Connection db, String Time_race, String Location_race, String Weather_race) {
        String request = "INSERT INTO 'race_hippiques'('Time_race', 'Location_race', 'Weather_race') VALUES (?,?,?);";
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Time_race);
            ps.setString(2, Location_race);
            ps.setString(3, Weather_race);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteDelRaceHippique(Connection db, String id){
        String request = "DELETE FROM 'race_hippiques' WHERE 'Id_race' ="+id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void requeteModRaceHippique(Connection db, String id, String Time_race, String Location_race, String Weather_race){
        String request = "UPDATE 'race_hippiques' SET 'Time_race'=?, 'Location_race'=?, 'Weather_race'=? WHERE ="+ id;
        try {
            PreparedStatement ps = db.prepareStatement(request);
            ps.setString(1, Time_race);
            ps.setString(2, Location_race);
            ps.setString(3, Weather_race);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
