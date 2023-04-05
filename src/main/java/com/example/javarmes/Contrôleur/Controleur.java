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


    /**
     * On appel les fonctions pour ajouter un client
     **/

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner p = new Scanner(System.in);
        Scanner p2 = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        Scanner md = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int str = 0;
        String mail, mdp, mailMAJ, mdpMAJ;
        int id;
        boolean passage = false;
        boolean pass2 = false;
        int ch = 0;

        /**création des vecteurs d'employee**/
        ArrayList<Employes> vecemployee = new ArrayList<Employes>();
        /**création des vecteurs d'un client**/
        ArrayList<Client> vecclient = new ArrayList<Client>();

        Client clientt1 = new Client(4569, "Oliviagaad@gmail.com", "ttt");
        Client clientt2 = new Client(5669, "AkshayaKone@gmail.com", "aaa");
        Client clientt3 = new Client(12555, "Baptsite@gmail.com", "bbb");
        vecclient.add(clientt1);
        vecclient.add(clientt2);
        vecclient.add(clientt3);


        /**Creation client**/
        Client client = new Client();
        Controleur.CreationClient(client, vecclient);


        /**MAJ**/
        Client cli = new Client();
        MAJclient(cli,vecclient);

        /**Suppression client**/
        Client iencli = new Client();
        SuppressionClient(iencli, vecclient);

        ///Afficher un client
        Client ienclit = new Client();
        AfficherClient( ienclit, vecclient);


        Scanner sc4 = new Scanner(System.in);/**choix**/
        Scanner sc5 = new Scanner(System.in);/**nom**/
        Scanner sc6 = new Scanner(System.in);/**prenom**/

        int choix = 0;
        String nom, prenom;
        int ident = 0;

        do {
            System.out.println("Voulez-vous ajouter un employee: 1-OUI 2-NON");
            choix = sc4.nextInt();

        } while (choix == 1 && choix == 2);

        Random rand = new Random();


        if (choix == 1) {

            System.out.println("Création d'un employee : ");

            System.out.println("Saisir le prenom:");
            prenom = sc5.nextLine();

            System.out.println("Saisir le nom:");
            nom = sc6.nextLine();


            /**Saisie l'ID : ALEATOIRE entre 4 500 20 000 **/
            ident = rand.nextInt(4500 + 14500); /** generation aléatoire**/

            ImpleEmployeDAO EmployeDAO = new ImpleEmployeDAO();
            //Client client = new Client (2, "test1@gmail.com", "test_1mdp");

            //Client client= new Client(mail, mdp);

            Employes employes = new Employes(ident, nom, prenom);


            try {

                EmployeDAO.AjouterEmployes(employes);

                if (employes != null) {
                    System.out.println("Employe ajouté : \n" + "prenom: " + employes.getPrenom() + "\nnom: " + employes.getNom() + "\nID: " + employes.getId() + " \n");
                } else {
                    System.out.println("L'employé n'a pas été créé\n");
                }
            } catch (SQLException e) {
                System.out.println("Erreur");
                System.out.println(e);
            }


            vecemployee.add(employes);

            /**Affichage**/
            for (Employes emp : vecemployee) {
                emp.ToString();
                System.out.println("\n");
            }

        }

    }


    public static void CreationClient(Client client, ArrayList<Client> vecclient) {

        /**bouton client **/

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);


        int str = 0;
        String mail, mdp;
        int ch = 0;
        boolean passage = false;


        /**création des vecteurs d'un client**/
        //ArrayList<Client> vecclient = new ArrayList<Client>();


        do {
            do {
                System.out.println("Voulez-vous ajouter un client: 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str == 1 && str == 2);


            if (str == 1) {

                System.out.println("Création d'un client : ");

                System.out.println("Saisir le mail:");
                mail = sc2.nextLine();

                System.out.println("Saisir le MDP:");
                mdp = sc3.nextLine();

                ImpleClientDAO clientDAO = new ImpleClientDAO();
                //Client client = new Client (2, "test1@gmail.com", "test_1mdp");

                //Client client= new Client(mail, mdp);


                // Client client = new Client(mail, mdp);
                Client clien = new Client(mail,mdp);
                try {

                    clientDAO.Ajouter(clien);

                    if (client != null) {
                        System.out.println("Client ajouté :" + "\nmail: " + clien.getMail() + "\nMDP: " + clien.getMdp() + " \n");
                    } else {
                        System.out.println("Le client n'a pas été créé\n");
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                vecclient.add(clien);

                /**Affichage**/
                for (Client cli : vecclient) {
                    cli.ToString();
                    System.out.println("\n");
                }

            }
            if (str == 2) {

                passage = true;
            }

        } while (!passage);

    }

    public static void MAJclient(Client client, ArrayList<Client> vecclient) {


        Scanner sc = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        Scanner md = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);


        String mailMAJ, mdpMAJ;
        int id;
        boolean passage = false;
        boolean pass2 = false;


        /**création des vecteurs d'un client**/
        //ArrayList<Client> vecclient = new ArrayList<Client>();

        int str = 0;


        ImpleClientDAO clientDAO = new ImpleClientDAO();

        do {
            do {
                System.out.println("Voulez-vous MAJ un client : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str == 1 && str == 2);


            if (str == 1) {


                try {

                    do {
                        System.out.println("MAJ d'un client : ");

                        System.out.println("Quel est l'identifiant du client : ");
                        id = identi.nextInt();

                        //Client clien = new Client();

                        /**Affichage**/
                        for (Client cli : vecclient) {
                            if (id == cli.getId()) {
                                System.out.println("MAJ d'un client : ");

                                System.out.println("Saisir le nouveau mail:");
                                mailMAJ = m.nextLine();

                                System.out.println("Saisir le nouveau MDP:");
                                mdpMAJ = md.nextLine();

                                cli.setMail(mailMAJ);
                                cli.setMdp(mailMAJ);

                                pass2 = false;

                                // Client client = new Client(mail, mdp);
                                Client clien = new Client(mailMAJ,mdpMAJ);
                                clientDAO.MettreAJour(clien);

                            } else {
                                System.out.println("Identifiant incompatible avec : ");
                                pass2 = true;
                            }

                            cli.ToString();
                            System.out.println("\n");

                        }
                    } while (!pass2);





                   // passage = true;

                    if (client == null) {

                        System.out.println("Les informations n'ont pas été mise à jour\n");
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }
            }
                if (str == 2) {
                    passage =true;
                }


        } while (!passage);
    }

    public static void SuppressionClient(Client client,ArrayList<Client> vecclient)
    {
        Scanner sc = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int id;
        boolean passage = false;
        boolean pass2 = false;



        int str = 0;


        ImpleClientDAO clientDAO = new ImpleClientDAO();

        do {
            do {
                System.out.println("Voulez-vous Supprimer un client : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str == 1 && str == 2);


            if (str == 1) {

                try {

                    do {
                        System.out.println("Supprimer un client : ");

                        System.out.println("Quel est l'identifiant du client : ");
                        id = identi.nextInt();



                        clientDAO.Supprimer(id);
                        //Client clien = new Client();

                        /**Affichage**/
                        for (Client cli : vecclient) {
                            if (id == cli.getId()) {

                                System.out.println("Suppression du client ayant pour : "+ "mail : " + cli.getMail()+ " mdp : " + cli.getMdp() + " identifiant : "+ cli.getId());

                                System.out.println("On affiche la suppression pour tester "+ vecclient.remove(cli));



                                pass2 = false;

                                    cli.ToString();
                                    System.out.println("\n");

                            } else {
                                System.out.println("Identifiant incompatible ");
                                pass2 = true;
                            }

                        }

                        /***Affiche pas ici **/

                        System.out.println("TEST2");
                    } while (!pass2);

                    System.out.println("TEST3");



                    // passage = true;

                    if (client == null) {
                        System.out.println("Les informations du client n'ont pas été supprimées\n");
                    }

                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }
            }
            if (str == 2) {
                passage =true;
            }

        } while (!passage);

    }


    public static void AfficherClient(Client client,ArrayList<Client> vecclient)
    {

        Scanner sc = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int id;
        boolean passage = false;
        boolean pass2 = false;



        int str = 0;


        ImpleClientDAO clientDAO = new ImpleClientDAO();

        do {
            do {
                System.out.println("Voulez-vous Afficher un client : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str == 1 && str == 2);


            if (str == 1) {

                try {

                    do {
                        System.out.println("Supprimer un client : ");

                        System.out.println("Quel est l'identifiant du client : ");
                        id = identi.nextInt();

                        //Client clien = new Client();

                        /**Affichage**/
                        for (Client cli : vecclient) {
                            if (id == cli.getId()) {

                                cli.ToString();
                                System.out.println("\n");
                                clientDAO.ChoisirClient(id);

                            } else {

                                pass2 = true;
                            }

                        }

                    } while (!pass2);




                    // passage = true;

                    if (client == null) {
                        System.out.println("Les informations du client ne peuvent pas etre affichées\n");
                    }

                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }
            }
            if (str == 2) {
                passage =true;
            }

        } while (!passage);
    }
}



