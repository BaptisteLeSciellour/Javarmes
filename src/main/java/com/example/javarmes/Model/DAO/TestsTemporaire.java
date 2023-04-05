package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Articles.*;

import java.sql.SQLException;

public class TestsTemporaire {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ImpleArmesDAO ArmesDAO = new ImpleArmesDAO();
        //Client client = new Client (2, "test1@gmail.com", "test_1mdp");
        Armes arme = new Armes("O3612","B", "Revolver",639.99,7.99);
        try{
            ArmesDAO.AjouterArmeB(arme);
            if(arme != null){
                System.out.println("Arme ajouté :"+" "+ arme.getIndentification() +" "+ arme.getCategorie()+" "+ arme.getNom() +" "+ arme.getPrix_unique()+" "+ arme.getCalibre());
            }else{
                System.out.println("Aucune arme !");
            }
        }catch(SQLException e){
            System.out.println("Erreur");
            System.out.println(e);
        }


    }

    }
