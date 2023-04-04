package com.example.javarmes.Contrôleur;

import com.example.javarmes.Model.Utilisateurs.Client;

import  com.example.javarmes.Model.DAO.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Controleur {

        /**On appel les fonctions pour ajouter un client**/
        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            int str=0;
            String mail,mdp;

            do {
                System.out.println("Voulez-vous ajouter un client: 1-OUI 2-NON\n");
                str = sc.nextInt();

            }while(str==1 && str==2);

            if(str==1)
            {

                System.out.println("Création d'un client \n");

                System.out.println("Saisir le mail:\n");
                mail= sc2.nextLine();

                System.out.println("Saisir le MDP:\n");
                mdp= sc3.nextLine();

                ImpleClientDAO clientDAO = new ImpleClientDAO();
                //Client client = new Client (2, "test1@gmail.com", "test_1mdp");

                //Client client= new Client(mail, mdp);


                try{
                    Client client= new Client(mail, mdp);
                    clientDAO.Ajouter(client);

                    if(client != null){
                        System.out.println("Client ajouté :"+"mail: "+ client.getMail() +"MDP: "+ client.getMdp()+" \n");
                    }else{
                        System.out.println("Le client n'as pas été créé\n");
                    }
                }catch(SQLException e){
                    System.out.println("Erreur");
                    System.out.println(e);
                }


            }



        }
    }
