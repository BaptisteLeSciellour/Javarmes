package com.example.javarmes.Model.DAO;

import org.example.Modèle.Utilisateurs.*;

import java.sql.SQLException;

public interface EmployeDAO {

    /** Méthodes de gestion des employés */
    void  AjouterEmploye(Employe employe) throws SQLException; /**Des employés peuvent être ajoutés*/
    void MettreAJourEmploye(Employe employe) throws SQLException;
    void SupprimerEmploye(int id) throws SQLException;

    /** Méthodes de gestion de clients faisable par les employés*/

    Client ChoisirClient (int id) throws SQLException;
    void  AjouterClient(Client client) throws SQLException;
    void MettreAJourClient(Client client) throws SQLException;
    void SupprimerClient(int id) throws SQLException;

}
