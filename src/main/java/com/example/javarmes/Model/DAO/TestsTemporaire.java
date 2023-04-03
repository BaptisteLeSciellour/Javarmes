package com.example.javarmes.Model.DAO;

import org.example.Modèle.Utilisateurs.Client;

import java.sql.SQLException;

public class TestsTemporaire {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ImpleClientDAO clientDAO = new ImpleClientDAO();
        //Client client = new Client (2, "test1@gmail.com", "test_1mdp");
        try{
            Client client = clientDAO.ChoisirClient(2);
            if(client != null){
                System.out.println("Client récupéré :"+" "+ client.getMail() +" "+ client.getMdp()+" "+ client.getNb_commandes());
            }else{
                System.out.println("Aucun client avec cet id n'a été trouvé");
            }
        }catch(SQLException e){
            System.out.println("Erreur");
            System.out.println(e);
        }
    }
    }
