package com.example.javarmes.Model.DAO;
import com.example.javarmes.Model.Articles.*;
import java.sql.SQLException;
import java.util.*;

public interface ArmesDAO {

     void AjouterArme(Armes armes) throws SQLException;
     void GererStockArme (String identification, int quantite) throws SQLException;/**Gestion du stock - incrémentation/décrémentation **/
     public List<Article> RechercherArmes(String recherche, String critere)throws SQLException;
     List<Armes> ChoisirArmes() throws SQLException;
     void SupprimerArme(int id) throws SQLException;
}
