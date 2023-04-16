package com.example.javarmes.Model.DAO;
import java.util.*;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import com.example.javarmes.Model.Utilisateurs.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe implementation du client : BDD
 * @author Akshaya
 * @param
 **/
public class ImpleEmployeDAO implements EmployeDAO {

    /**
     * Méthodes de gestion des employés
     * Méthode qui permet d'ajouter un employé
     * @author Akshaya
     * @param
     **/

    @Override
    public void AjouterEmployes(Employes employe) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO employés( nom , prénom) VALUES (?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, employe.getNom());
            pstmnt.setString(2, employe.getPrenom());
            pstmnt.executeUpdate();
            System.out.println("Employé ajouté à la base de données !");
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
     * Méthode de suppression d'un employé
     * @author Akshaya
     * @param
     **/
    @Override
    public void SupprimerEmployes(int id) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "DELETE FROM employés WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, id);
            pstmnt.executeUpdate();
            System.out.println("L'employé a été supprimé de la base !");
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
     * Méthode de mise à jour des informations d'un employé
     * @author Akshaya
     * @param
     **/
    @Override
    public void MettreAJourEmployes(Employes employe) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "UPDATE employés SET nom = ?, prénom = ? WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, employe.getPrenom());
            pstmnt.setString(2, employe.getNom());
            pstmnt.setInt(3, employe.getId());
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
     * Méthode d'affichage des infos d'un employé
     * @author Akshaya
     * @param
     **/
    public Employes ChoisirEmploye(int id) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        Employes employe = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM employés  WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, id);
            resultat = pstmnt.executeQuery();
            if (resultat.next()){
                employe = new Employes(resultat.getInt("id"), resultat.getString("nom"),resultat.getString("prénom"));
            }
        } catch(SQLException e) {
            System.out.println("Erreur lors de la récupération de l'employé");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)||(resultat!=null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
        return employe;
    }


    /**
     * Méthode d'affichage de l'ensemble des employés
     * @author Akshaya
     * @param
     **/

    public List<Employes>  ChoisirEmploye() throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        List<Employes> ListeEmployes = new ArrayList<>();
        try{
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM employés ";
            pstmnt = con.prepareStatement(requete);
            resultat = pstmnt.executeQuery();
            while (resultat.next()){
                Employes employes = new Employes(resultat.getInt("id"), resultat.getString("nom"),resultat.getString("prénom"));
                ListeEmployes.add(employes);
            }
        } catch(SQLException e) {
            System.out.println("Erreur lors de la récupération des employés");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)||(resultat!=null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
        return ListeEmployes;
    }

    /**
     * Méthodes de gestion de clients faisable par les employés
     * Méthode d'affichage des infos de tous les clients
     * @author Akshaya
     * @param
     **/

    public List<Client> ChoisirClient() throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        List<Client> ListeClients = new ArrayList<>();
        try{
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM clients ";
            pstmnt = con.prepareStatement(requete);
            resultat = pstmnt.executeQuery();
            while (resultat.next()){
                    Client client = new Client(resultat.getInt("id"), resultat.getString("mail"),resultat.getString("mdp"),resultat.getInt("nb_commandes"));
                ListeClients.add(client);
            }
        } catch(SQLException e) {
            System.out.println("Erreur lors de la récupération des clients");
            System.out.println(e);
        } finally {
            if ((pstmnt !=null)||(con!=null)||(resultat!=null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
        System.out.println(ListeClients.size());
        return ListeClients;
    }

    /**
     * Méthode d'affichage des infos d'un client
     * @author Akshaya
     * @param
     **/
    public Client ChoisirClient(int id) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet resultat = null;
        Client client = null;
        try {
            con = new DAOFactory().getConnection();
            String requete = "SELECT * FROM clients  WHERE id = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, id);
            resultat = pstmnt.executeQuery();
            if (resultat.next()) {
                client = new Client(resultat.getInt("id"), resultat.getString("mail"), resultat.getString("mdp"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du client");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null) || (resultat != null)) {
                pstmnt.close();
                con.close();
                resultat.close();
            }
        }
        return client;
    }

    /**
     * Méthode d'ajout d'un nouveau client
     * @author Akshaya
     * @param
     **/
    @Override
    public void AjouterClient (Client client) throws SQLException{
        Connection con = null;
        PreparedStatement pstmnt = null;
        try{
            con = new DAOFactory().getConnection();
            String requete = "INSERT INTO clients( mail , mdp) VALUES (?, ?)";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setString(1, client.getMail());
            pstmnt.setString(2, client.getMdp());
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
     * Méthode de modification des infos d'un client
     * @author Akshaya
     * @param
     **/
    @Override
    public void MettreAJourClient(Client client) throws SQLException{
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
     * Méthode de suppression des données d'un client
     * @author Akshaya
     * @param
     **/
    @Override
    public void SupprimerClient(int id) throws SQLException{
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
     * Méthode de
     * @author Akshaya
     * @param ID
     * @param nom
     **/
    @Override
    public Employes connexionemployes(int ID, String nom) throws SQLException {
        Connection con = null;
        PreparedStatement pstmnt = null;
        ResultSet rsl = null;
        Employes connexionEmploye = null;
        try {
            con = DAOFactory.getConnection();
            String requete = "SELECT * FROM employés WHERE id = ? AND nom = ?";
            pstmnt = con.prepareStatement(requete);
            pstmnt.setInt(1, ID);
            pstmnt.setString(2,nom);
            rsl = pstmnt.executeQuery();
            if (rsl.next()) {
                connexionEmploye = new Employes(rsl.getInt("id"), rsl.getString("nom"));
                System.out.println("Employé identifié");
            } else{
                System.out.println("Erreur : Employé non identifié ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'authentification");
            System.out.println(e);
        } finally {
            if ((pstmnt != null) || (con != null) || (rsl != null)) {
                pstmnt.close();
                con.close();
                rsl.close();
            }
        }
        return connexionEmploye;
    }
}

