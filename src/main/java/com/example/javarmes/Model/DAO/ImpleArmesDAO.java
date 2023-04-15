package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Utilisateurs.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO: implementation d'armes
 * @author Akshaya
 */
public class ImpleArmesDAO implements ArmesDAO {

    /**
     * Méthode qui permet d'ajouter une nouvelle arme à la bdd
     * @author Akshaya
     * @param
     */
    @Override
    public void AjouterArme(Armes armes) throws SQLException {
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
            System.out.println("Arme ajoutée à la base de données !");
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
     *      ex : (categorie,B) affiche toutes les armes de la catégorie B
     * @author Akshaya
     * @param
     **/

    @Override
    public List<Article> RechercherArmes(String recherche, String critere) throws SQLException {
       Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet result = null;
        List<Article> ResultatRecherche = new ArrayList<>();
        try {
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM armes WHERE " + recherche + " = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, critere);
            result = pstmnt.executeQuery();
            while (result.next()) {
                Armes arme = new Armes(result.getString("identification"),result.getString("type"), result.getString("categorie"), result.getString("nom"), result.getDouble("prix_unique"), result.getInt("quantite"), result.getDouble("calibre"), result.getBoolean("reduction"),result.getInt("nb_vente"));
                ResultatRecherche.add(arme);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche ...");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null) || (result != null)) {
                pstmnt.close();
                con.close();
                assert result != null;
                result.close();
            }
        }
        return ResultatRecherche;
    }

    /**
     * Méthode qui permet de diminuer ou augmenter le stock d'une arme
     *      * nombre négatif pour décrementer, positif pour incrémenter
     *      * avec blindage quantité>=0
     * @author Akshaya
     * @param
     **/
    @Override
    public void GererStockArme(String identification, int quantite) throws SQLException {
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

    /**
     * Méthode qui permet de récupérer les informations d'une arme
     * @author Akshaya
     * @param
     **/
    @Override
    public List<Armes> ChoisirArmes() throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet result = null;
        List<Armes> ListeArmes = new ArrayList<>();
        try{
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM armes ";
            pstmnt = con.prepareStatement(requete);
            result = pstmnt.executeQuery();
            while(result.next()){
                Armes armes = new Armes(result.getString("identification"),result.getString("type"), result.getString("categorie"), result.getString("nom"), result.getDouble("prix_unique"), result.getInt("quantite"), result.getDouble("calibre"), result.getBoolean("reduction"), result.getInt("nb_vente"));
                ListeArmes.add(armes);
            }
        } catch(SQLException e) {
            System.out.println("Erreur lors de la récupération de la liste des armes");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)||(result!=null)) {
                pstmnt.close();
                con.close();
                result.close();
            }
        }
        System.out.println(ListeArmes.size());
        return ListeArmes;
    }

    /**
     * Méthode qui permet de supprimer définitivement une arme de la bdd
     * @author Akshaya
     * @param
     **/
    @Override
    public void SupprimerArme(int identification) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "DELETE FROM armes WHERE identification = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, identification);
            pstmnt.executeUpdate();
            System.out.println("L'arme a été supprimée de la base !");
        } catch(SQLException e) {
            System.out.println("Erreur lors de la suppression...");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)) {
                pstmnt.close();
                con.close();
            }
        }
    }
}








