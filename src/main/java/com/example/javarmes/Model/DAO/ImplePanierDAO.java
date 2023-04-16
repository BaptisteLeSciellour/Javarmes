package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.Connection;
import java.sql.*;

/**
 * Classe implementation du panier : BDD
 * @author Akshaya
 * @param
 **/
public class ImplePanierDAO implements PanierDAO {

    /**
     * Méthode de création d'une table panier qui garde le panier en mémoire
     * @author Akshaya
     * @param
     **/
    public void CreationPanier() throws SQLException{
        Connection con = null;
        Statement stmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete ="CREATE TABLE IF NOT EXISTS panier ( id_panier INT PRIMARY KEY AUTO_INCREMENT,type VARCHAR(50) NOT NULL,id_arme VARCHAR(255)  NULL,id_munition VARCHAR(255)  NULL,qte INT NOT NULL,prix_unique DOUBLE NOT NULL,prix_vrac DOUBLE NULL,prix_total DOUBLE NOT NULL, reduction BOOLEAN NOT NULL, FOREIGN KEY (id_arme) REFERENCES armes(identification), FOREIGN KEY (id_munition) REFERENCES munitions(identification))";
            stmnt= con.createStatement();
            stmnt.execute(requete);
            System.out.println("Panier crée avec succès !");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Panier non crée");
        }finally {
            if ((stmnt != null) || (con != null)){
                stmnt.close();
                con.close();
            }
        }
    }

    /**
     *Méthode qui calcule le prix totale dans le panier pour des munitions
     * @author Akshaya
     * @param quantite
     * @param id_article **/
    @Override
    // la vente au prix vrac est fixé à au dessus de  10
    public double prixTotal(String id_article, int quantite) throws SQLException {
        int quantiteVrac = 10;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rsl = null;
        double prix_total=0.0;
        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT prix_unique FROM armes where identification = ?";
            pst = con.prepareStatement(requete);
            pst.setString(1, id_article);
            rsl = pst.executeQuery();
            if (rsl.next()) {
                double prix_unique = rsl.getDouble("prix_unique");
                //double prix_vrac = rsl.getDouble("prix_vrac");
                prix_total = quantite * prix_unique;
                System.out.println("Prix total pour arme calculé");
            } else {
                //con = new DAOFactory().getConnection();
                String requete1 = "SELECT prix_unique, prix_vrac FROM munitions where identification = ?";
                pst = con.prepareStatement(requete1);
                pst.setString(1, id_article);
                rsl = pst.executeQuery();
                if (rsl.next()) {
                    double prix_unique1 = rsl.getDouble("prix_unique");
                    double prix_vrac1 = rsl.getDouble("prix_vrac");
                    if (quantite >= quantiteVrac) {
                        int nombreVrac1 = quantite / quantiteVrac;
                        int reste1 = quantite % quantiteVrac;
                        prix_total = nombreVrac1 * prix_vrac1;
                        prix_total += reste1 * prix_unique1;
                        System.out.println("Prix total pour munition calculé");
                    }
                } else {
                    System.out.println("erreur de calcul");
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Panier non crée");
        } finally {
            if ((pst != null) || (con != null) || (rsl != null)) {
                pst.close();
                con.close();
                rsl.close();
            }
        }
        return prix_total;
    }




    /**
     * Méthode d'ajout de produit choisi par le client dans son panier
     *      * Il faudrait ici pour chaque bouton situé près de l'article, set les valeurs String id_article et String type_article
     *      * demander la saisie de
     * @author Akshaya
     * @param id_article
     * @param quantite
     **/
    public void AjouterProduitPanier(String id_article, int quantite) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet rsl = null;
        /**Création des String pour les requêtes SQL et initialisation à vide **/

        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM armes WHERE identification = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, id_article);
            rsl = pstmnt.executeQuery();
            if (rsl.next()) {
                String article_type = "arme";
                Double article_prix = rsl.getDouble("prix_unique");
                Double article_prix_vrac = rsl.getDouble("prix_unique");
                boolean reduction = rsl.getBoolean("reduction");

                String requete3 = "INSERT INTO panier(type,id_arme,qte, prix_unique, prix_total, reduction) VALUES (?, ?, ?, ?, ?, ?)";
                pstmnt = con.prepareStatement(requete3);
                pstmnt.setString(1,article_type);
                pstmnt.setString(2,id_article);
                pstmnt.setInt(3,quantite);
                pstmnt.setDouble(4,article_prix);
                pstmnt.setDouble(5, prixTotal(id_article, quantite));
                pstmnt.setBoolean(6,reduction);
                pstmnt.executeUpdate();
                System.out.println("Article ajouté à votre panier !");
            } else {
                //con = new DAOFactory().getConnection();
                String requete2 = "SELECT * FROM munitions WHERE identification = ?";
                pstmnt = con.prepareStatement(requete2);
                pstmnt.setString(1, id_article);
                rsl = pstmnt.executeQuery();
                if (rsl.next()) {
                    String article_type = "munition";
                    Double article_prix = rsl.getDouble("prix_unique");
                    Double article_prix_vrac = rsl.getDouble("prix_vrac");
                    boolean reduction = rsl.getBoolean("reduction");

                    String requete4 = "INSERT INTO panier(type, id_munition, qte, prix_unique, prix_total, reduction) VALUES (?, ?, ?, ?, ?, ?)";
                    pstmnt = con.prepareStatement(requete4);
                    pstmnt.setString(1,article_type);
                    pstmnt.setString(2,id_article);
                    pstmnt.setInt(3,quantite);
                    pstmnt.setDouble(4,article_prix);
                    pstmnt.setDouble(5, prixTotal(id_article,quantite));
                    pstmnt.setBoolean(6,reduction);
                    pstmnt.executeUpdate();
                    System.out.println("Article ajouté à votre panier !");
                } else {
                    System.out.println("Article inconnu");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Panier non crée");
        } finally {
            if ((pstmnt != null) || (con != null) || (rsl != null)) {
                pstmnt.close();
                con.close();
                rsl.close();
            }
        }
    }



    /**
     *  /**Méthode de suppression de produit
     *      * @param id_article
     *      * Set l'id_article dans le bouton "retirer" correspondant à l'article
     * @author Akshaya
     * @param
     **/
    public void SupprimerProduitPanier(String id_article) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete1 = "DELETE FROM panier WHERE id_arme = ?";
            pstmnt = con.prepareStatement(requete1);
            pstmnt.setString(1, id_article);
            int lignesupp1 = pstmnt.executeUpdate(); //executeUpdate renvoie le nombre de ligne qui a été modifié et 0 sinon
            if(lignesupp1 >0){
                System.out.println("L'article a été supprimé du panier !");
            }else{
                    String requete2 = "DELETE FROM panier WHERE id_munition = ?";
                    pstmnt = con.prepareStatement(requete2);
                    pstmnt.setString(1, id_article);
                    int lignesupp2 = pstmnt.executeUpdate();
                    if(lignesupp2>0){
                        System.out.println("L'article a été supprimé du panier !");
                    }else{ //en cas d'erreur de saisi dans le set du bouton
                        System.out.println("L'article n'a pas été reconnu");
                    }
            }
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

    /**
     * Méthode de la destruction de la table panier dans la bdd
     * @author Akshaya
     * @param
     **/
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
    }
    public void Payer() throws SQLException{}
}
