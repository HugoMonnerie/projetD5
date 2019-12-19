package fr.projet5;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLRequete
{
    public void  requete(Connection db,String name)
    {
        try {
            String request = "SELECT * FROM football_team AS FT where FT.Team_name  = " + "'" +name+"'" ;
            System.out.println(request);
            PreparedStatement ps = db.prepareStatement(request);
            ResultSet rs = ps.executeQuery(request);
            while (rs.next())
            {
                String result = rs.getString("Team_Name");
                System.out.println(result  + "\n");
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}