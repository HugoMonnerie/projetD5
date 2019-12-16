package fr.projet5;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        new Fenetre();
        new Panneau();
        new SQLDatabaseConnection();
        SQLDatabaseConnection.Sql();
        

            }
        }