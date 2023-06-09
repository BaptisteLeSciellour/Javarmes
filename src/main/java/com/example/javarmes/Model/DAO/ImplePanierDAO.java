package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;
import com.example.javarmes.Model.Articles.*;
import com.example.javarmes.Model.DAO.*;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe implementation du panier : BDD
 * @author Akshaya
 **/
public class ImplePanierDAO implements PanierDAO {

    /**
     * Méthode de création d'une table panier qui garde le panier en mémoire
     * @author Akshaya
     **/
    /**
    public void CreationPanier( int id_createur) throws SQLException{
        Connection con = null;
        Statement stmnt = null;
        PreparedStatement pst = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "CREATE TABLE IF NOT EXISTS panier ( id_panier INT PRIMARY KEY AUTO_INCREMENT,type VARCHAR(50) ? ,id_arme VARCHAR(255)  NULL,id_munition VARCHAR(255)  NULL,qte INT NOT NULL,prix_unique DOUBLE NOT NULL,prix_vrac DOUBLE NULL,prix_total DOUBLE NOT NULL, reduction BOOLEAN NOT NULL)";
            pst = con.prepareStatement(requete);
            pst.setInt(1, id_createur);
            stmnt = con.createStatement();
            stmnt.execute(requete);
            System.out.println("Panier crée avec succès !");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Panier non crée");
        } finally {
            if ((stmnt != null) || (con != null)) {
                stmnt.close();
                con.close();
            }
        }
    }
     **/

    /**
     *Méthode qui calcule le prix totale dans le panier pour des munitions
     * @author Akshaya
 **/
    @Override
    // la vente au prix vrac est fixé à au dessus de 10
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
                prix_total = quantite * prix_unique;
                System.out.println("Prix total pour arme calculé");
            } else {
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
     * @author Akshaya
     **/
    public void AjouterProduitPanier(String id_article, int quantite, int id_createur) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet rsl = null;
        /**Création des String pour les requêtes SQL et initialisation à vide **/
        System.out.println("%%");
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
                String requete3 = "INSERT INTO panier(creation,type,id_arme,qte, prix_unique, prix_total, reduction,id_panier) VALUES (?, ?, ?, ?, ?, ?,?,?)";
                pstmnt = con.prepareStatement(requete3);
                pstmnt.setInt(1,id_createur);
                pstmnt.setString(2, article_type);
                pstmnt.setString(3, id_article);
                pstmnt.setInt(4, quantite);
                pstmnt.setDouble(5, article_prix);
                pstmnt.setDouble(6, prixTotal(id_article, quantite));
                pstmnt.setBoolean(7, reduction);
                int max = 1000000;
                int min = 0;
                int range = (max - min) + 1;

                // Générer un nombre aléatoire entre une plage spécifique
                int nbr = (int)(Math.random() * range) + min;

                pstmnt.setInt(8,nbr);
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

                    String requete4 = "INSERT INTO panier(creation,type, id_munition, qte, prix_unique, prix_total, reduction,id_panier) VALUES (?, ?, ?, ?, ?, ?,?,?)";
                    pstmnt = con.prepareStatement(requete4);
                    pstmnt.setInt(1, id_createur);
                    pstmnt.setString(2, article_type);
                    pstmnt.setString(3, id_article);
                    pstmnt.setInt(4, quantite);
                    pstmnt.setDouble(5, article_prix);
                    pstmnt.setDouble(6, prixTotal(id_article, quantite));
                    pstmnt.setBoolean(7, reduction);
                    int max = 1000000;
                    int min = 0;
                    int range = (max - min) + 1;

                    // Générer un nombre aléatoire entre une plage spécifique
                    int nbr = (int)(Math.random() * range) + min;

                    pstmnt.setInt(8,nbr);
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

    @Override
    public void Payer(int id_client) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = new DAOFactory().getConnection();
            ///con.setAutoCommit(false);
            String requete = "SELECT id_arme,id_munition,qte FROM panier WHERE creation = ?";
            pst = con.prepareStatement(requete);
            pst.setInt(1,id_client);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id_arme = rs.getString("id_arme");
                String id_munition = rs.getString("id_munition");
                int qte_article = rs.getInt("qte");
                if ((id_arme != null)) {
                    ImpleArmesDAO ArmesDAO = new ImpleArmesDAO();
                    ArmesDAO.GererStockArme(id_arme, (-qte_article));
                    con = new DAOFactory().getConnection();
                    String requeteVente = "UPDATE armes SET nb_vente = nb_vente+? WHERE identification = ?";
                    pst = con.prepareStatement(requeteVente);
                    pst.setInt(1, qte_article);
                    pst.setString(2,id_arme);
                    pst.executeUpdate();
                } else if (id_munition != null) {
                    ImpleMunitionsDAO MunitionDAO = new ImpleMunitionsDAO();
                    MunitionDAO.GererStockMunition(id_munition, (-qte_article));
                    String requeteVente = "UPDATE munitions SET nb_vente = nb_vente+? WHERE identification = ?";
                    pst = con.prepareStatement(requeteVente);
                    pst.setInt(1, qte_article);
                    pst.setString(2, id_munition);
                    pst.executeUpdate();
                }
            }
            String requeteClient = "UPDATE clients SET nb_commandes = nb_commandes+1 WHERE id = ?";
            pst = con.prepareStatement(requeteClient);
            pst.setInt(1, id_client);
            pst.executeUpdate();
            SupressionPanier(id_client);
            System.out.println("Panier supprimé à bientot !");
            ///con.commit();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression...");
            System.out.println(e);
        } finally {
            if ((pst != null) || (con != null) || (rs != null)) {
                pst.close();
                con.close();
                rs.close();
            }
        }
    }

    /**
     * /**Méthode de suppression de produit
     * * @param id_article
     * * Set l'id_article dans le bouton "retirer" correspondant à l'article
     *
     * @param id_article
     * @author Akshaya
     * **/
    public void SupprimerProduitPanier(String id_article,int id_createur) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        try {
            con = new DAOFactory().getConnection();
            String requete1 = "DELETE FROM panier WHERE id_arme = ? AND creation = ?";
            pstmnt = con.prepareStatement(requete1);
            pstmnt.setString(1, id_article);
            pstmnt.setInt(2,id_createur);
            int lignesupp1 = pstmnt.executeUpdate(); //executeUpdate renvoie le nombre de ligne qui a été modifié et 0 sinon
            if (lignesupp1 > 0) {
                System.out.println("L'article a été supprimé du panier !");
            } else {
                String requete2 = "DELETE FROM panier WHERE id_munition = ?";
                pstmnt = con.prepareStatement(requete2);
                pstmnt.setString(1, id_article);
                int lignesupp2 = pstmnt.executeUpdate();
                if (lignesupp2 > 0) {
                    System.out.println("L'article a été supprimé du panier !");
                } else { //en cas d'erreur de saisi dans le set du bouton
                    System.out.println("L'article n'a pas été reconnu");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression...");
            System.out.println(e);
            con.rollback();
        } finally {
            if ((pstmnt != null) || (con != null)) {
                pstmnt.close();
                con.close();
            }
        }
    }

    /**
     * Méthode de la destruction de la table panier dans la bdd
     * @author Akshaya
     **/
    public void SupressionPanier(int id_createur) throws SQLException {
        Connection con = null;
        PreparedStatement stmnt = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "DELETE FROM panier WHERE creation = ?";
            stmnt = con.prepareStatement(requete);
            stmnt.setInt(1,id_createur);
            stmnt.execute();
            System.out.println("Panier supprimée");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Panier non supprimée");
        } finally {
            if ((stmnt != null) || (con != null)) {
                stmnt.close();
                con.close();
            }
        }
    }
    public String ResumePaiement(int id_createur) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = new DAOFactory().getConnection();
            int i = AffichePanier(id_createur).size();
            String requeteNbProduit = "SELECT MAX(?) AS TotalProduit FROM panier";
            pst = con.prepareStatement(requeteNbProduit);
            pst.setInt(1,id_createur);
            rs = pst.executeQuery();
            if (rs.next()) {
                int TotalProduit = rs.getInt("TotalProduit");
                String requetePrixTotal = "SELECT SUM(prix_total) AS PrixPanier FROM panier WHERE creation = ?";
                pst = con.prepareStatement(requetePrixTotal);
                pst.setInt(1,id_createur);
                rs = pst.executeQuery();
                if(rs.next()){
                    AffichePanier(id_createur);
                    int PrixPanier = rs.getInt("PrixPanier");
                    return "Vous avez actuellement " + i + " produits dans votre panier pour une somme totale à payer de " + PrixPanier+"€";
                }
            }else{
                System.out.println("Erreur lors du calcul...");
            }
            } catch (SQLException e) {
                System.out.println("Erreur SQL");
                System.out.println(e);
            } finally {
                if ((pst != null) || (con != null) || (rs != null)) {
                    pst.close();
                    con.close();
                }
            }
        return "Votre panier nous semble vide";
        }
        @Override
        public List<Panier> AffichePanier(int id_createur) throws SQLException{
            Connection con = null;
            PreparedStatement pstmnt = null;
            ResultSet result = null;
            List<Panier> PanierContenu = new ArrayList<>();
            try{
                con = new DAOFactory().getConnection();
                String requete = "SELECT * FROM panier WHERE creation = ?";
                pstmnt = con.prepareStatement(requete);
                pstmnt.setInt(1,id_createur);
                result = pstmnt.executeQuery();
                while(result.next()){
                    Panier panier = new Panier(result.getString("type"),result.getInt("qte"),result.getDouble("prix_total"),result.getInt("reduction"),result.getString("id_arme"));
                    PanierContenu.add(panier);
                }
            } catch(SQLException e) {
                System.out.println("Erreur lors de la récupération du panier");
                System.out.println(e);
            } finally {
                if ((pstmnt !=null)||(con!=null)||(result!=null)) {
                    pstmnt.close();
                    con.close();
                    result.close();
                }
            }
            System.out.println(PanierContenu);
           return PanierContenu;
        }
    }
