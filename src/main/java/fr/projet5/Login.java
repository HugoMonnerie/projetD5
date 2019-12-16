package fr.projet5;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Login {

    public static boolean co = false;

    public static void login(String id, String mdp){
        try {
            DriverManager.getConnection("jdbc:mysql://192.168.43.223:3306/projet5", id, mdp);
            System.out.println("Connected !");
            co = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
