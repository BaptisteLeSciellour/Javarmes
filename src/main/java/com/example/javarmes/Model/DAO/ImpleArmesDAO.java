package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpleArmesDAO implements ArmesDAO {

    public void AjouterArmeB(Armes armes) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO armes( identification, categorie, nom, prix_unique, quantite, calibre) VALUES (?, ?, ?, ?, ?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, armes.getIndentification());
            pstmnt.setString(2, armes.getCategorie());
            pstmnt.setString(3, armes.getNom());
            pstmnt.setDouble(4, armes.getPrix_unique());
            pstmnt.setInt(5, armes.getQuantite());
            pstmnt.setDouble(6, armes.getCalibre());
            pstmnt.executeUpdate();
            System.out.println("Arme ajouté à la base de données !");
        } catch(SQLException e) {
            System.out.println("Erreur lors de l'ajout ...");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)) {
                pstmnt.close();
                con.close();
            }
        }
    }

    //void MettreAJourArmeB(Armes armes) throws SQLException{

    }


}
