package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Utilisateurs.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpleClientDAO implements ClientDAO {
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
    /** Enlever ou laisser ? */
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

    /** Méthode qui retourne true si le mail existe déjà et false si ce n'est pas le cas**/
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
}
