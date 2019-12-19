package fr.projet5;

import java.sql.Connection;

public class App
{
    public static void main(String[] args)
    {
        Connection db = null;
        new Fenetre();
        new Panneau();
    }
}