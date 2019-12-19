package fr.projet5;

import java.beans.Statement;

public class SQLRequete
{
    public void  requete()
    {
        Statement st = db.createStatement();
        st.setFetchSize(0);
        ResultSet rs = st.executeQuery("SELECT * FROM matable");
        while (rs.next()) {
            System.out.print("toutes les lignes ont été renvoyées.");
        }
        rs.close();
    }
}
