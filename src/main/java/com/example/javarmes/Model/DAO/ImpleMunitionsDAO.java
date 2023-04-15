package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Munitions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe implementation des munitions
 * @author Akshaya
 * @param
 **/
public class ImpleMunitionsDAO implements MunitionsDAO {


    /**
     * Méthode d'ajout de munitions
     * @author Akshaya
     * @param
     **/
    @Override
    public void ajouter(Munitions munition) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO munition( identification, categorie, nom, prix_unique, quantite, calibre, reduction, prix_vrac ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, munition.getIndentification());
            pstmnt.setString(2, munition.getCategorie());
            pstmnt.setString(3, munition.getNom());
            pstmnt.setDouble(4, munition.getPrix_unique());
            pstmnt.setInt(5, munition.getQuantite());
            pstmnt.setDouble(6, munition.getCalibre());
            pstmnt.setBoolean(7, munition.getReduction());
            pstmnt.setDouble(8, munition.getPrix_vrac());
            pstmnt.executeUpdate();
            System.out.println("Munition ajoutée à la base de données !");
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
     * Méthode de gestion de stock des munitions idem à celle des armes
     * @author Akshaya
     * @param
     **/
    @Override
    public void GererStockMunition(String identification, int quantite) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT quantite FROM munitions WHERE identification = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, identification);
            resultat = pstmnt.executeQuery();
            if (resultat.next()) {
                int nouvelleQuantite = resultat.getInt("quantite") + quantite;
                if (nouvelleQuantite >= 0) {
                    requete = "UPDATE munitions SET quantite = ? WHERE identification = ?";
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
            if ((pstmnt != null) || (con != null) || (resultat != null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
    }

    /**
     * Méthode de recherches des munitions identiques à celle des armes
     * @author Akshaya
     * @param
     **/
    @Override
    public List<Munitions> RechercherMunitions(String recherche, String critere) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet result = null;
        List<Munitions> ResultatRecherche = new ArrayList<>();
        try {
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM munitions WHERE " + recherche + " = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, critere);
            result = pstmnt.executeQuery();
            while (result.next()) {
                Munitions munition = new Munitions(result.getString("identification"), result.getString("categorie"), result.getString("nom"), result.getDouble("prix_unique"), result.getInt("quantite"), result.getDouble("calibre"), result.getBoolean("reduction"), result.getDouble("prix_vrac"), result.getInt("nb_vente"));
                ResultatRecherche.add(munition);
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

    /**
     * Méthode d'affichage de l'ensemble des munitions
     * @author Akshaya
     * @param
     **/
    @Override
    public List<Munitions> ChoisirMunitions() throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet result = null;
        List<Munitions> ListeMunitions = new ArrayList<>();
        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM munitions ";
            pstmnt = con.prepareStatement(requete);
            result = pstmnt.executeQuery();
            if (result.next()) {
                Munitions munition = new Munitions(result.getString("identification"), result.getString("categorie"), result.getString("nom"), result.getDouble("prix_unique"), result.getInt("quantite"), result.getDouble("calibre"), result.getBoolean("reduction"), result.getDouble("prix_vrac"), result.getInt("nb_vente"));
                ListeMunitions.add(munition);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la liste des munitions");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null) || (result != null)) {
                pstmnt.close();
                con.close();
                result.close();
            }
        }
        return ListeMunitions;
    }
}
