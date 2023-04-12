package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class ImplePanierDAO implements PanierDAO {
    public void CreationPanier() throws SQLException{
        Connection con = null;
        Statement stmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete ="CREATE TABLE IF NOT EXISTS panier (id INT NOT NULL AUTO_INCREMENT, type VARCHAR(50) NOT NULL,"+
                    "prix DOUBLE NOT NULL, quantite INT NOT NULL, PRIMARY KEY(id));";
            stmnt= con.createStatement();
            stmnt.execute(requete);
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Panier non crée");
        }
    };
    public void AjouterProduit() throws SQLException{};
    public void SupprimerProduit(int id) throws SQLException{};

    public void SupressionPanier() throws SQLException{
        Connection con = null;
        Statement stmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete ="DROP TABLE panier";
            stmnt= con.createStatement();
            stmnt.execute(requete);
            System.out.println("Panier supprimée");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Panier non supprimée");
        }
    };

    public void Payer() throws SQLException{};
}
