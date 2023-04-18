package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Panier.Panier;

import java.sql.SQLException;
import java.util.List;

public interface PanierDAO {
    ///void CreationPanier(int id_createur) throws SQLException;
    public double prixTotal(String id_article, int quantite) throws SQLException;
    void AjouterProduitPanier(String id_article, int quantite,int id_createur) throws SQLException;
    void SupprimerProduitPanier(String id_article,int id_createur) throws SQLException;
    String ResumePaiement(int id_createur) throws SQLException;
    void Payer(int id_client) throws SQLException;
    void SupressionPanier(int id_createur) throws SQLException;
    List<Panier> AffichePanier(int id_createur) throws SQLException;

}
