package com.example.javarmes.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestBdD {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ece_shopping","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
