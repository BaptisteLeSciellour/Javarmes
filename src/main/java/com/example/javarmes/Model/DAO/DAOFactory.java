package com.example.javarmes.Model.DAO;
import java.sql.*;

public class DAOFactory {

    private static String url = "jdbc:mysql://localhost:3306/ece_shopping";
    private static String username = "root";
    private static String password = "";


    /*Cette constructeur permet de faire la liaison entre les différentes tables de la BDD et Java*/
    public DAOFactory() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connexion avec la base de données réussie !");
        }
        catch(Exception e)
        {
            System.out.println("Connexion avec la base de données échouée...");
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    }


