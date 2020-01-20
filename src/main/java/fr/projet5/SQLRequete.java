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
    public String requetefoot(Connection db, String name)
    {
        try {
            String request = "SELECT * FROM football_team AS FT where FT.Team_name  = " + "'" +name+"';" ;
            /*String request2 = "SELECT * FROM football_player Left Join football_team as FT on football_player.J_id_team_f = FT.Id_team_f where FT.Team_name = " + "'"+name+"'" + " and Titulaire_player_f = 'titulaire' ;" ;
            String request3 = "SELECT * FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f where FT.Team_name  = " + "'"+name+"';";
            String request4 = "SELECT * as Nbr_Player FROM football_player AS FP LEFT JOIN football_team AS FT ON FP.J_id_team_f = FT.Id_team_f where FT.Team_name  = " + "'"+name+"';";
            String request5 = "SELECT * as Nbr_team FROM football_team ;";
            String request6 = "SELECT * FROM football_team AS FT LEFT JOIN (SELECT tabBut.id as id, FT.Team_name as Name_team ,max(tabBut.but) as but, FT2.Team_name as Name_team_adv FROM (SELECT Id_team_inside_f as id, Nbr_but_inside_f as but, Id_team_outside_f as id_adv FROM matchs_football UNION SELECT Id_team_outside_f, Nbr_but_outside_f, Id_team_inside_f FROM matchs_football order by but DESC) as tabBut LEFT JOIN football_team as FT ON tabBut.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut.id_adv=FT2.Id_team_f GROUP BY id) AS tab1f ON FT.Id_team_f=tab1.id LEFT JOIN (SELECT tabBut2.id as id, FT.Team_name as Name_team ,max(tabBut2.but) as but, FT2.Team_name as Name_team_adv FROM (SELECT Id_team_outside_f as id, Nbr_but_inside_f as but , Id_team_inside_f as id_adv FROM matchs_football UNION SELECT Id_team_inside_f, Nbr_but_outside_f, Id_team_outside_f FROM matchs_football ORDER BY but DESC) as tabBut2 LEFT JOIN football_team as FT ON tabBut2.id = FT.Id_team_f LEFT JOIN football_team as FT2 ON tabBut2.id_adv=FT2.Id_team_f GROUP BY id) AS tab2 ON FT.Id_team_f=tab2.id;";
*/
            System.out.println(request);
            /*System.out.println(request2);
            System.out.println(request3);
            System.out.println(request4);
            System.out.println(request5);
            System.out.println(request6);*/

            PreparedStatement ps = db.prepareStatement(request);
            /*PreparedStatement ps2 = db.prepareStatement(request2);
            PreparedStatement ps3 = db.prepareStatement(request3);
            PreparedStatement ps4 = db.prepareStatement(request4);
            PreparedStatement ps5 = db.prepareStatement(request5);
            PreparedStatement ps6 = db.prepareStatement(request6);*/

            ResultSet rs = ps.executeQuery(request);
            /*ResultSet rs2 = ps2.executeQuery(request2);
            ResultSet rs3 = ps3.executeQuery(request3);
            ResultSet rs4 = ps4.executeQuery(request4);
            ResultSet rs5 = ps5.executeQuery(request5);
            ResultSet rs6 = ps6.executeQuery(request6);*/

            String result = "";
            while (rs.next())
            {
                result = rs.getString("Team_create");
            }
            result = result +"\n";
            rs.close();
            ps.close();

            /*String result2 = "";
            while (rs2.next())
            {
                result2 = rs2.getString("COUNT(Titulaire_player_f) as Nbr_Titulaire");
            }
            result2 = result2 +"\n";
            rs2.close();
            ps2.close();

            String result3 = "";
            while (rs3.next())
            {
                result3 = rs3.getString("FP.Name_player_f,  FP.Age_player_f");
            }
            result3 = result3 +"\n";
            rs3.close();
            ps3.close();

            String result4 = "";
            while (rs4.next())
            {
                result4 = rs4.getString("COUNT(FP.Name_player_f)");
            }
            result4 = result4 +"\n";
            rs4.close();
            ps4.close();

            String result5 = "";
            while (rs5.next())
            {
                result5 = rs5.getString("COUNT(Team_name)-1");
            }
            result5 = result5 +"\n";
            rs5.close();
            ps5.close();

            String result6 = "";
            while (rs4.next())
            {
                result6 = rs6.getString("tab1.Name_team,tab1.but, tab1.Name_team_adv ,tab2.Name_team_adv, tab2.but");
            }
            result6 = result6 +"\n";
            rs6.close();
            ps6.close();*/

            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "error";
    }
    public String requeteTennis(Connection db,String name)
    {try {
        String request = "SELECT * FROM players_tennis AS PT where PT.Name_player_t  = " + "'" +name+"';" ;
        String request2 = "SELECT * FROM players_tennis as PT LEFT JOIN matchs_tennis as MT ON MT.Id_first_player_t = PT.Id_player_t LEFT JOIN (SELECT MT.Id_secondary_player_t as Id, COUNT(MT.Id_secondary_player_t) as nb FROM matchs_tennis as MT GROUP BY MT.Id_secondary_player_t )as tab ON tab.Id = PT.Id_player_t LEFT JOIN (SELECT tabV.id, max(tabV.v_frappe) as max_v_frappe, max(tabV.v_course) as max_v_course FROM (SELECT Id_first_player_t as id, Speed_shot_first_player_t as v_frappe, Speedrun_first_player_t as v_course FROM matchs_tennis UNION SELECT Id_secondary_player_t, Speed_shot_secondary_player_t, Speedrun_secondary_player_t FROM matchs_tennis) as tabV GROUP BY id) as tabVit ON tabVit.id=PT.Id_player_t GROUP BY PT.Id_player_t where PT.Name_player_t  = " + "'" +name+"'"+"order by PT.Name_player_t ASC;" ;

        System.out.println(request);
        System.out.println(request2);

        PreparedStatement ps = db.prepareStatement(request);
        PreparedStatement ps2 = db.prepareStatement(request2);

        ResultSet rs = ps.executeQuery(request);
        ResultSet rs2 = ps2.executeQuery(request2);

        String result = "";
        while (rs.next())
        {
            result = rs.getString("Name_player_t, Firstname_player_t, Age_player_t");
        }
        rs.close();
        ps.close();

        String result2 = "";
        while (rs2.next())
        {
            result2 = rs2.getString("PT.Firstname_player_t,PT.Name_player_t, PT.Age_player_t, COUNT(MT.`Id_first_player_t`) AS NBR_Win, tab.nb AS NBR_Loose,PT.Nbr_medal_t,tabVit.max_v_frappe as vitesse_frappe_max,tabVit.max_v_course as vitesse_max");
        }
        rs2.close();
        ps2.close();

        return result + result2;
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
        return "error";
    }

    public String requeteHippique(Connection db,String name)
    {
        try {
            String request = "SELECT * FROM chevaux_hippique AS CH LEFT JOIN jockeys_hippique AS JH ON JH.Id_horse_j = CH.Id_horse where CH.Name_horse  = " + "'" +name+"';" ;
            String request2 = "SELECT * FROM classement_horse_race AS CHH LEFT JOIN race_hippiques as RH ON CHH.Id_race_c = RH.Id_race LEFT JOIN chevaux_hippique as CH ON CH.Id_horse = CHH.Id_horse_c where CH.Name_horse  = " + "'" +name+"'"+"ORDER BY CHH.Speed_horse DESC ;" ;
            String request3 = "SELECT * FROM chevaux_hippique AS CH LEFT JOIN classement_horse_race AS CHH ON CH.Id_horse = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id,COUNT(CHH.Classement_horse) AS UN FROM classement_horse_race AS CHH WHERE CHH.Classement_horse = 1 GROUP BY CHH.Id_horse_c )AS tab1 ON tab1.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS TROIS FROM classement_horse_race AS CHH WHERE CHH.Classement_horse <= 3 GROUP BY CHH.Id_horse_c ) AS tab2 ON tab2.Id = CHH.Id_horse_c LEFT JOIN (SELECT CHH.Id_horse_c as Id, COUNT(CHH.Classement_horse) AS Loose FROM classement_horse_race AS CHH WHERE CHH.Classement_horse > 3 GROUP BY CHH.Id_horse_c )AS Looser On Looser.Id = CHH.Id_horse_c GROUP BY CH.Id_horse where CH.Name_horse  = " + "'" +name+"'"+"ORDER BY premier ASC;" ;

            System.out.println(request);
            System.out.println(request2);
            System.out.println(request3);

            PreparedStatement ps = db.prepareStatement(request);
            PreparedStatement ps2 = db.prepareStatement(request2);
            PreparedStatement ps3 = db.prepareStatement(request3);

            ResultSet rs = ps.executeQuery(request);
            ResultSet rs2 = ps2.executeQuery(request2);
            ResultSet rs3 = ps3.executeQuery(request3);

            String result = "";
            while (rs.next())
            {
                result = rs.getString("Name_horse, Age_horse, Name_jockey, Firstname_jockey, Age_jockey, Weight_jockey");
            }
            rs.close();
            ps.close();

            String result2 = "";
            while (rs2.next())
            {
                result2 = rs2.getString("CHH.Speed_horse");
            }
            rs2.close();
            ps2.close();

            String result3 = "";
            while (rs3.next())
            {
                result3 = rs3.getString("tab1.UN AS premier, tab2.TROIS AS podium, Looser.Loose");
            }
            rs3.close();
            ps3.close();

            return result + result2 + result3;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
