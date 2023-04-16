package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Articles.Munitions;

import java.sql.SQLException;

import java.util.*;

/**
 * Interface de munition
 * @author Akshaya
 **/
public interface MunitionsDAO {
    void ajouter (Munitions munition) throws SQLException;
    void GererStockMunition(String identification, int quantite) throws SQLException;
    List<Munitions> RechercherMunitions(String recherche, String critere) throws SQLException;
    List<Munitions> ChoisirMunitions() throws SQLException;
    void SupprimerMunition (String identification) throws SQLException;
}
