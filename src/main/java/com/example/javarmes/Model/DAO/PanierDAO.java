package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.SQLException;

public interface PanierDAO {
    void CreationPanier() throws SQLException;
    public double prixTotal(String id_article, int quantite) throws SQLException;
    void AjouterProduitPanier(String id_article, int quantite) throws SQLException;
    void SupprimerProduitPanier(String id_article) throws SQLException;
    void SupressionPanier() throws SQLException;
    void Payer() throws SQLException;
}
