package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Articles.*;

import java.sql.SQLException;
import java.util.List;

public class TestsTemporaire {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       ImpleArmesDAO ArmesDAO = new ImpleArmesDAO();
        //Client client = new Client (2, "test1@gmail.com", "test_1mdp");
        //Armes arme = new Armes("O3612","B", "Revolver",639.99,7.99);
        String recherche = "categorie";
        String critere = "A";
        try{
            //ArmesDAO.AjouterArmeB(arme);
            List<Armes> resultatRecherche = ArmesDAO.RechercherArmes(recherche, critere);
            if(resultatRecherche!= null){
                System.out.println("Résultats de la recherche");
                System.out.println(resultatRecherche);
                //System.out.println("Arme ajouté :"+" "+ resultatRecherche.getIndentification() +" "+ arme.getCategorie()+" "+ arme.getNom() +" "+ arme.getPrix_unique()+" "+ arme.getCalibre());
            }else{
                System.out.println("Aucune arme !");
            }
        }catch(SQLException e){
            System.out.println("Erreur");
            System.out.println(e);
        }  //-------------------Test de la méthode de recherches dans le rayon Armes


    }

    }
