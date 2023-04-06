package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpleArmesDAO implements ArmesDAO {

    public void AjouterArmeB(Armes armes) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO armes( identification, categorie, nom, prix_unique, quantite, calibre, reduction ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, armes.getIndentification());
            pstmnt.setString(2, armes.getCategorie());
            pstmnt.setString(3, armes.getNom());
            pstmnt.setDouble(4, armes.getPrix_unique());
            pstmnt.setInt(5, armes.getQuantite());
            pstmnt.setDouble(6, armes.getCalibre());
            pstmnt.setBoolean(7, armes.getReduction());
            pstmnt.executeUpdate();
            System.out.println("Arme ajouté à la base de données !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout ...");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null)) {
                pstmnt.close();
                con.close();
            }
        }
    }

    /**
     * Méthode qui recherche dans la table Armes selon le critère saisi et la valeur voulue
     **/
    public List<Armes> RechercherArmes(String recherche, String critere) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet result = null;
        List<Armes> ResultatRecherche = new ArrayList<>();
        try {
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM armes WHERE " + recherche + " = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, critere);
            result = pstmnt.executeQuery();
            while (result.next()) {
                Armes arme = new Armes(result.getString("identification"), result.getString("categorie"), result.getString("nom"), result.getDouble("prix_unique"), result.getInt("quantite"), result.getDouble("calibre"), result.getBoolean("reduction"));
                ResultatRecherche.add(arme);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche ...");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null) || (result != null)) {
                pstmnt.close();
                con.close();
                result.close();
            }
        }
        return ResultatRecherche;
    }

    public void GererStockArmeB(String identification, int quantite) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT quantite FROM armes WHERE identification = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, identification);
            resultat = pstmnt.executeQuery();
            if (resultat.next()) {
                int nouvelleQuantite = resultat.getInt("quantite")+quantite;
                if (nouvelleQuantite >= 0) {
                    requete = "UPDATE armes SET quantite = ? WHERE identification = ?";
                    pstmnt = con.prepareStatement(requete);
                    pstmnt.setInt(1, nouvelleQuantite);
                    pstmnt.setString(2, identification);
                    pstmnt.executeUpdate();
                    System.out.println("Les informations ont été modifiées !");
                } else {
                    System.out.println("La quantité obtenue est négative, les informations n'ont pas été changées");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification...");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null)||(resultat !=null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
    }
}








