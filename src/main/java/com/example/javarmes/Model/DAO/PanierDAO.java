package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.SQLException;
import java.util.List;

public interface PanierDAO {
    void CreationPanier() throws SQLException;
    public double prixTotal(String id_article, int quantite) throws SQLException;
    void AjouterProduitPanier(String id_article, int quantite) throws SQLException;
    void SupprimerProduitPanier(String id_article) throws SQLException;
    void ResumePaiement() throws SQLException;
    void Payer(int id_client) throws SQLException;
    void SupressionPanier() throws SQLException;
    List<Panier> AffichePanier() throws SQLException;

}
