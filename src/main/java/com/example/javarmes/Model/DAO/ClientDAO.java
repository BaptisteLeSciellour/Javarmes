package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;

import java.sql.SQLException;
public interface ClientDAO {

    void  Ajouter(Client Client) throws SQLException;
    void MettreAJour(Client Client) throws SQLException;
    void Supprimer(int id) throws SQLException;
     Client ChoisirClient (int id) throws SQLException;
     boolean BlindageParRecherche (String mailSaisi) throws SQLException;

     Client connexionClient(int ID, String mail, String mdp) throws SQLException;

}
