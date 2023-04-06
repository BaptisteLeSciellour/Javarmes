package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import com.example.javarmes.Model.Utilisateurs.*;

import java.sql.SQLException;

public interface EmployeDAO {

    /** Méthodes de gestion des employés */
    void  AjouterEmployes(Employes Employes) throws SQLException; /**Des employés peuvent être ajoutés*/
    void MettreAJourEmployes(Employes employe) throws SQLException;
    void SupprimerEmployes(int id) throws SQLException;
    Employes ChoisirEmploye(int id) throws SQLException;

    /** Méthodes de gestion de clients faisable par les employés*/

    Client ChoisirClient (int id) throws SQLException;
    void  AjouterClient(Client client) throws SQLException;
    void MettreAJourClient(Client client) throws SQLException;
    void SupprimerClient(int id) throws SQLException;

}
