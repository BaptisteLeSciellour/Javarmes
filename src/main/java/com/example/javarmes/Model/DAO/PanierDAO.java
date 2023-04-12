package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.SQLException;

public interface PanierDAO {
    void CreationPanier() throws SQLException;
    void AjouterProduit() throws SQLException;
    void SupprimerProduit(int id) throws SQLException;
    void SupressionPanier() throws SQLException;
    void Payer() throws SQLException;
}
