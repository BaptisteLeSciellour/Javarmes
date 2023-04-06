package com.example.javarmes.Model.DAO;
import com.example.javarmes.Model.Articles.*;
import java.sql.SQLException;
import java.util.*;

public interface ArmesDAO {

     void AjouterArmeB(Armes armes) throws SQLException;
     void GererStockArmeB(String identification, int quantite) throws SQLException;/**Gestion du stock - incrémentation/décrémentation **/
     public List<Armes> RechercherArmes(String recherche, String critere)throws SQLException;


}
