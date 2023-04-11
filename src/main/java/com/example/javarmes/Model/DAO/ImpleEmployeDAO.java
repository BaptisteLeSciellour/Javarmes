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

public class ImpleEmployeDAO implements EmployeDAO {
    /** Méthodes de gestion des employés */
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
            if (resultat.next()){
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

    /** Méthodes de gestion de clients faisable par les employés*/
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
            if (resultat.next()){
                Client client = new Client(resultat.getInt("id"), resultat.getString("mail"));
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
        return ListeClients;
    }

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

}

