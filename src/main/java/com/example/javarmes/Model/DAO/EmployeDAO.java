package com.example.javarmes.Model.DAO;
import java.util.*;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import com.example.javarmes.Model.Utilisateurs.*;

import java.sql.SQLException;

/**
 * Interface employee
 * @author Baptiste
 * @version 3.0
 */
public interface EmployeDAO {


    void  AjouterEmployes(Employes Employes) throws SQLException; /**Des employés peuvent être ajoutés*/
    void MettreAJourEmployes(Employes employe) throws SQLException;
    void SupprimerEmployes(int id) throws SQLException;
    Employes ChoisirEmploye(int id) throws SQLException;
    List<Employes> ChoisirEmploye() throws SQLException;

    public Employes connexionemployes(int ID, String nom) throws SQLException;
    /** Méthodes de gestion de clients faisable par les employés*/

    Client ChoisirClient (int id) throws SQLException;
    List<Client> ChoisirClient () throws SQLException;
    void  AjouterClient(Client client) throws SQLException;
    void MettreAJourClient(Client client) throws SQLException;
    void SupprimerClient(int id) throws SQLException;

}
