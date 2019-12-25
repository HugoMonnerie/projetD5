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
            String request = "SELECT * FROM football_team AS FT where FT.Team_name  = " + "'" +name+"'" ;
            System.out.println(request);
            PreparedStatement ps = db.prepareStatement(request);
            ResultSet rs = ps.executeQuery(request);
            String result = "";
            String result2 = "";
            String result3 = "";
            while (rs.next())
            {
                result = rs.getString("Team_Name");
                System.out.println(result  + "\n");
                result2 = rs.getString("Team_create");
                System.out.println(result2 + "\n");
                result3 = rs.getString("Site_Team");
                System.out.println(result3  + "\n");
            }
            result = result +"\n"+ result2 +"\n"+ result3;
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