package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Utilisateurs.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe client de la bddd
 * @author Akshaya
 **/
public class ImpleClientDAO implements ClientDAO {

    /**
     * Méthode qui permet à un client de s'inscrire
     * @author Akshaya
     **/

    @Override
    public void Ajouter(Client client) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO clients(id, mail , mdp) VALUES (?, ?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, client.getId());
            pstmnt.setString(2, client.getMail());
            pstmnt.setString(3, client.getMdp());
            pstmnt.executeUpdate();
            System.out.println("Client ajouté à la base de données !");
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


    /**
     * Méthode qui permet à un client de mettre à jour ses informations de connexion
     * @author Akshaya
     * @param client : Objet client
     **/

    @Override
    public void MettreAJour(Client client) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "UPDATE clients SET mail = ?, mdp = ? WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, client.getMail());
            pstmnt.setString(2, client.getMdp());
            pstmnt.setInt(3, client.getId());
            pstmnt.executeUpdate();
            System.out.println("Les informations ont été modifiées !");
        } catch(SQLException e) {
            System.out.println("Erreur lors de la modification...");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)) {
                pstmnt.close();
                con.close();
            }
        }
    }



    /**
     * Méthode qui permet à un client de supprimer son compte
     * @author Akshaya
     * @param id : identifiant du client
     **/
    @Override
    public void Supprimer(int id) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "DELETE FROM clients WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, id);
            pstmnt.executeUpdate();
            System.out.println("Le client a été supprimé de la base !");
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
     * Méthode qui permet d'afficher le compte d'un client
     * @author Akshaya
     * @param id : identifiant du client
     **/
    @Override
    public Client ChoisirClient(int id) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        Client client = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM clients  WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, id);
            resultat= pstmnt.executeQuery();
            if (resultat.next()){
                client = new Client(resultat.getInt("id"), resultat.getString("mail"),resultat.getString("mdp"));
            }
        } catch(SQLException e) {
            System.out.println("Erreur lors de la récupération du client");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)||(resultat!=null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
        return client;
    }

    /**
     * Méthode qui retourne true si le mail existe déjà et false si ce n'est pas le cas
     * @author Akshaya
     * @param mailSaisi : mail du client
     **/
    public boolean BlindageParRecherche (String mailSaisi) throws SQLException {
        Connection con = null;
        Statement stmnt = null;
        ResultSet resultat = null;
        boolean verification = false;
        try {
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM clients WHERE mail = '"+ mailSaisi+ "'";
            stmnt = con.createStatement();
            resultat = stmnt.executeQuery(requete);
            if (resultat.next()) {
                Client client = new Client(resultat.getInt("id"), resultat.getString("mail"),resultat.getString("mdp"));
                verification = true;
                System.out.println(verification);
            }else{
                System.out.println(verification);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche ...");
            System.out.println(e);
        } finally {
            if ((stmnt != null) || (con != null) || (resultat != null)) {
                stmnt.close();
                con.close();
                resultat.close();
            }
        }
        return verification;

    }

    /**
     * Méthode qui permet au client de se connecter
     * @author Akshaya
     * @param ID: identifiant du client
     * @param mail : mail du client
     * @param mdp : mot de passe du client
     **/
    public Client connexionClient(int ID, String mail, String mdp) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null ;
        ResultSet rsl = null;
        Client connexionClient = null;
        try{
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM clients WHERE id = ? AND mail = ?" ;
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1,ID);
            pstmnt.setString(2,mail);
            rsl = pstmnt.executeQuery();
            if(rsl.next()){
                String mdpSaisi = rsl.getString("mdp");
                if(mdpSaisi.equals(mdp)){
                    connexionClient = new Client(rsl.getInt("id"), rsl.getString("mail"), rsl.getString("mdp"));
                    System.out.println("Client identifié");
                }else{
                    System.out.println("Mot de passe saisi incorrect");
                }
            }else{
                System.out.println("Données saisies incorrectes");
            }
        }catch(SQLException e){
            System.out.println("Erreur lors de l'authentification");
            System.out.println(e);
        } finally {
            if((pstmnt!=null)||(con!=null)||(rsl!=null)){
                pstmnt.close();
                con.close();
                rsl.close();
            }
        }
        return connexionClient;
    }

}
