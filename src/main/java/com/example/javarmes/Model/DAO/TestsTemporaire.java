package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Articles.*;

import java.sql.SQLException;
import java.util.List;

public class TestsTemporaire {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       /**ImpleArmesDAO ArmesDAO = new ImpleArmesDAO();
        //Client client = new Client (2, "test1@gmail.com", "test_1mdp");
        //Armes arme = new Armes("O3612","B", "Revolver",639.99,7.99);
        String recherche = "reduction";
        String critere = "5";
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
        }  //----------------------------------------Test de la méthode de recherches dans le rayon Armes------------------------------------------**/


        /**ImpleArmesDAO ArmesDAO = new ImpleArmesDAO();
        System.out.println("Saisissez nombre négatif pour décrémenter le stock et positif pour incrémenter "); // A saisir dans le contrôleur
        try{
            ArmesDAO.GererStockArmeB("A0504", 11);
        }catch(SQLException e) {
            System.out.println("Erreur");
            System.out.println(e);
        }----------------------------------------------Test Gestion des stocks d'armes---------------------------------------------------------**/

        /**ImpleClientDAO ClientDAO = new ImpleClientDAO();
        //String mailSaisi = "tintintin";
        try{
            //ClientDAO.BlindageParRecherche(mailSaisi);
            ClientDAO.connexionClient(14889, "Aksh", "1345");
        }catch(SQLException e) {
            System.out.println("Erreur");
            System.out.println(e);
        }**/
    }

    }
