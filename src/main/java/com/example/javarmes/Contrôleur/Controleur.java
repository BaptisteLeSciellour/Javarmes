package com.example.javarmes.Contrôleur;

import java.util.ArrayList;
import java.util.Random;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Utilisateurs.Client;

import  com.example.javarmes.Model.DAO.*;
import com.example.javarmes.Model.Utilisateurs.Employes;

import java.sql.SQLException;
import java.util.Scanner;

public class Controleur {

        /**On appel les fonctions pour ajouter un client**/
        public static void main(String[] args) throws SQLException, ClassNotFoundException {


            /***bouton client **/

            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            int str=0;
            String mail,mdp;

            do {
                System.out.println("Voulez-vous ajouter un client: 1-OUI 2-NON ");
                str = sc.nextInt();

            }while(str==1 && str==2);

            if(str==1)
            {

                System.out.println("Création d'un client : ");

                System.out.println("Saisir le mail:");
                mail= sc2.nextLine();

                System.out.println("Saisir le MDP:");
                mdp= sc3.nextLine();

                ImpleClientDAO clientDAO = new ImpleClientDAO();
                //Client client = new Client (2, "test1@gmail.com", "test_1mdp");

                //Client client= new Client(mail, mdp);


                Client client= new Client(mail, mdp);

                try{

                    clientDAO.Ajouter(client);

                    if(client != null){
                        System.out.println("Client ajouté :"+"\nmail: "+ client.getMail() +"\nMDP: "+ client.getMdp()+" \n");
                    }else{
                        System.out.println("Le client n'a pas été créé\n");
                    }
                }catch(SQLException e){
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                /**création des vecteurs d'un client**/
                ArrayList<Client> vecclient = new ArrayList<Client>();
                vecclient.add(client);

                /**Affichage**/
                for ( Client cli : vecclient)
                {
                    cli.ToString();
                    System.out.println("\n");
                }
            }


            /**bouton employee**/

            Scanner sc4 = new Scanner(System.in);/**choix**/
            Scanner sc5 = new Scanner(System.in);/**nom**/
            Scanner sc6 = new Scanner(System.in);/**prenom**/

            int choix=0;
            String nom,prenom;
            int id=0;

            do {
                System.out.println("Voulez-vous ajouter un employee: 1-OUI 2-NON");
                choix = sc4.nextInt();

            }while(choix==1 && choix==2);

            Random rand= new Random();


            if(choix==1)
            {

                System.out.println("Création d'un employee : ");

                System.out.println("Saisir le prenom:");
                prenom= sc5.nextLine();

                System.out.println("Saisir le nom:");
                nom= sc6.nextLine();


                /**Saisie l'ID : ALEATOIRE entre 4 500 20 000 **/
                id=rand.nextInt(4500+14500); /** generation aléatoire**/

                ImpleEmployeDAO EmployeDAO = new ImpleEmployeDAO();
                //Client client = new Client (2, "test1@gmail.com", "test_1mdp");

                //Client client= new Client(mail, mdp);

                Employes employes= new Employes(id,nom,prenom);

                try{

                    EmployeDAO.AjouterEmployes(employes);

                    if(employes != null){
                        System.out.println("Employe ajouté : \n"+"prenom: "+ employes.getPrenom() + "\nnom: "+ employes.getNom() +"\nID: "+ employes.getId()+" \n");
                    }else{
                        System.out.println("L'employé n'a pas été créé\n");
                    }
                }catch(SQLException e){
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                /**création des vecteurs d'employee**/
                ArrayList<Employes> vecemployee = new ArrayList<Employes>();
                vecemployee.add(employes);

                /**Affichage**/
                for ( Employes emp : vecemployee)
                {
                    emp.ToString();
                    System.out.println("\n");
                }

            }
        }



}

