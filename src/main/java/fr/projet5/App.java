package fr.projet5;

<<<<<<< HEAD
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        new Fenetre();
        new Panneau();
        new SQLDatabaseConnection();
        SQLDatabaseConnection.Sql();

=======
public class App {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        Panneau panneau = new Panneau();
>>>>>>> master
    }
}