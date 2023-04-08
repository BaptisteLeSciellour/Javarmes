package com.example.javarmes.Contrôleur;

import java.util.ArrayList;
import java.util.Random;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Utilisateurs.Client;

import  com.example.javarmes.Model.DAO.*;
import com.example.javarmes.Model.Utilisateurs.Employes;
import com.example.javarmes.Model.Articles.*;

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


        /**création des vecteurs d'un client**/
        ArrayList<Client> vecclient = new ArrayList<Client>();

        Client clientt1 = new Client(4569, "Oliviagaad@gmail.com", "ttt");
        Client clientt2 = new Client(5669, "AkshayaKone@gmail.com", "aaa");
        Client clientt3 = new Client(12555, "Baptsite@gmail.com", "bbb");
        vecclient.add(clientt1);
        vecclient.add(clientt2);
        vecclient.add(clientt3);

        /**création des vecteurs d'employee**/
        ArrayList<Employes> vecemployee = new ArrayList<Employes>();
        Employes employee1 = new Employes(6666, "Gaad", "Olivia");
        Employes employee2 = new Employes(7896, "Kone", "Akshaya");
        Employes employee3 = new Employes(16465, "Lesciellour", "Baptiste");
        vecemployee.add(employee1);
        vecemployee.add(employee2);
        vecemployee.add(employee3);


        /**Creation Employee**/
        Employes employes = new Employes();
        Controleur.CreationEmployee(employes, vecemployee);

        /**Creation client**/
        Client client = new Client();
        Controleur.CreationClient(client, vecclient);


        /**MAJ**/
        Client cli = new Client();
        MAJclient(cli,vecclient);

        /**Suppression client**/
        Client iencli = new Client();
        SuppressionClient(iencli, vecclient);

        /**Suppression employee**/
        Employes emp = new Employes();
        SuppressionEmployee(emp, vecemployee);

        /**Afficher un client**/
        Client ienclit = new Client();
        AfficherClient( ienclit, vecclient);


        /**Afficher un client**/
        Employes empl = new Employes();
        AfficherEmployee( empl, vecemployee);

        /**MAJ**/
        Employes employ = new Employes();
        MAJemployee(employ, vecemployee);

    }

    public static void CreationEmployee(Employes employes, ArrayList<Employes> vecemployee)
    {
        /**bouton client **/

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);


        int str = 0;
        String nom, prenom;
        boolean passage = false;
        boolean pass2 = true;

        /**création des vecteurs d'un client**/
        //ArrayList<Client> vecclient = new ArrayList<Client>();
        int id=0;

        do {
            do {
                System.out.println("Voulez-vous ajouter un employee: 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);


            if (str == 1) {

                System.out.println("Création d'un employee : ");

                System.out.println("Saisir le prenom:");
                prenom = sc2.nextLine();

                System.out.println("Saisir le nom:");
                nom = sc3.nextLine();

                do {
                    pass2=true;

                    /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
                    Random rand = new Random();
                    id = rand.nextInt(4500 + 14500); /** generation aléatoire**/

                    /***on verifie que l'identifiant n'existe pas deja**/
                    for (Employes emp : vecemployee) {

                        if (id == emp.getId()) {
                            System.out.println("L'identifiant est deja pris par un autre employee");

                            pass2=false;

                        }
                        break;
                    }
                } while (!pass2);


                ImpleEmployeDAO EmployeDAO = new ImpleEmployeDAO();
                Employes employe = new Employes(id, nom, prenom);

                System.out.println("Votre identifiant est : " + id);


                try {

                    EmployeDAO.AjouterEmployes(employe);

                    if (employe != null) {
                        System.out.println("Employe ajouté : \n" + "prenom: " + employe.getPrenom() + "\nnom: " + employe.getNom() + "\nID: " + employe.getId() + " \n");
                    } else {
                        System.out.println("L'employé n'a pas été créé\n");
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                vecemployee.add(employe);

                /**Affichage**/
                for (Employes emp : vecemployee) {
                    emp.ToString();
                    System.out.println("\n");
                }
            }

            if (str == 2) {

                passage = true;
            }

        } while (!passage);

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
        boolean pass2 = true,pass3=true;

        /**création des vecteurs d'un client**/
        //ArrayList<Client> vecclient = new ArrayList<Client>();
        int id=0;

        do {
            do {
                System.out.println("Voulez-vous ajouter un client: 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2); /**!(str == 1 || str == 2)**/



            if (str == 1) {

                System.out.println("Création d'un client : ");

                do {
                    pass3=true;

                System.out.println("Saisir le mail:");
                mail = sc2.nextLine();

                    for (Client cli : vecclient) {

                        if (mail == cli.getMail()) {
                            System.out.println("Le mail existe deja");
                            pass3=false;
                            break;
                        }

                    }

                } while (!pass3);

                System.out.println("Saisir le MDP:");
                mdp = sc3.nextLine();

                do {

                    pass2=true;

                    /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
                    Random rand = new Random();
                    id = rand.nextInt(4500 + 14500); /** generation aléatoire**/

                    /***on verifie que l'identifiant n'existe pas deja**/
                    for (Client cli : vecclient) {

                        if (id == cli.getId()) {
                            System.out.println("L'identifiant est deja pris par un autre client");
                           pass2=false;
                        }
                        break;
                    }

                }while(!pass2);

                System.out.println("Votre identifiant est : "+ id);

                ImpleClientDAO clientDAO = new ImpleClientDAO();

                // Client client = new Client(mail, mdp);
                Client clien = new Client(id,mail,mdp);
                try {

                    clientDAO.Ajouter(clien);

                    if (clien != null) {
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

            } while (str != 1 && str != 2);

            if (str == 1) {

                try {

                    do {

                        pass2=false;
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

                                pass2 = true;

                                // Client client = new Client(mail, mdp);
                                Client clien = new Client(id,mailMAJ,mdpMAJ);
                                clientDAO.MettreAJour(clien);

                                break;

                            } else {
                                System.out.println("Identifiant incompatible avec : ");

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


    public static void MAJemployee(Employes employes, ArrayList<Employes> vecemployes) {


        Scanner sc = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        Scanner md = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);


        String nom, prenom;
        int id;
        boolean passage = false;
        boolean pass2 = false;
        int str = 0;


        ImpleEmployeDAO employeDAO = new ImpleEmployeDAO();

        do {
            do {
                System.out.println("Voulez-vous MAJ un employee : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);

            if (str == 1) {

                try {

                    do {

                        pass2=false;
                        System.out.println("MAJ d'un employee : ");

                        System.out.println("Quel est l'identifiant de l'employee : ");
                        id = identi.nextInt();



                        /**Affichage**/
                        for (Employes emp : vecemployes) {
                            if (id == emp.getId()) {
                                System.out.println("MAJ d'un employee : ");

                                System.out.println("Saisir le nom:");
                                nom = m.nextLine();

                                System.out.println("Saisir le prenom:");
                                prenom = md.nextLine();

                                emp.setNom(nom);
                                emp.setPrenom(prenom);

                                pass2 = true;


                                Employes employe = new Employes(id,nom,prenom);
                                employeDAO.MettreAJourEmployes(employe);
                                break;

                            } else {
                                System.out.println("Identifiant incompatible avec : ");

                            }

                            emp.ToString();
                            System.out.println("\n");

                        }
                    } while (!pass2);



                    if (employes == null) {

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
        boolean pass2 = true;

        int str = 0;

        ImpleClientDAO clientDAO = new ImpleClientDAO();

        do {
            do {
                System.out.println("Voulez-vous Supprimer un client : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);


            if (str == 1) {

                try {

                    do {
                        pass2 = false;
                        System.out.println("Supprimer un client : ");

                        System.out.println("Quel est l'identifiant du client : ");
                        id = identi.nextInt();



                        clientDAO.Supprimer(id);
                        //Client clien = new Client();

                        /**Verification : si id existe deja **/
                        for (Client cli : vecclient) {

                            if (id == cli.getId()) {

                                System.out.println("Suppression du client ayant pour : "+ "mail : " + cli.getMail()+ " mdp : " + cli.getMdp() + " identifiant : "+ cli.getId());

                                System.out.println("On affiche la suppression pour tester "+ vecclient.remove(cli));

                                pass2 = true;

                                cli.ToString();
                                System.out.println("\n");
                                break;

                            } else {
                                System.out.println("Identifiant incompatible ");

                            }

                        }

                    } while (!pass2);

                    System.out.println("TEST3");

                    if (client == null) {
                        System.out.println("Les informations du client n'ont pas été supprimées\n");
                    }

                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                /**Affichage**/
                for (Client cli : vecclient) {

                        cli.ToString();
                        System.out.println("\n");
                }
            }
            if (str == 2) {
                passage =true;
            }



        } while (!passage);
    }

    public static void SuppressionEmployee(Employes employee,ArrayList<Employes> vecemployee)
    {
        Scanner sc = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int id;
        boolean passage = false;
        boolean pass2 = true;

        int str = 0;

        ImpleEmployeDAO employeDAO = new ImpleEmployeDAO();

        do {
            do {
                System.out.println("Voulez-vous Supprimer un employee : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);


            if (str == 1) {

                try {

                    do {
                        pass2 = false;
                        System.out.println("Supprimer un employee : ");

                        System.out.println("Quel est l'identifiant de l'employee : ");
                        id = identi.nextInt();



                        employeDAO.SupprimerEmployes(id);
                        //Client clien = new Client();

                        /**Verification : si id existe deja **/
                        for (Employes emp : vecemployee) {

                            if (id == emp.getId()) {

                                System.out.println("Suppression du client ayant pour : "+ "nom : " + emp.getPrenom()+ " prenom : " + emp.getNom() + " identifiant : "+ emp.getId());

                                System.out.println("On affiche la suppression pour tester "+ vecemployee.remove(emp));

                                pass2 = true;

                                emp.ToString();
                                System.out.println("\n");
                                break;

                            } else {
                                System.out.println("Identifiant incompatible ");

                            }

                        }

                    } while (!pass2);

                    System.out.println("TEST3");

                    if (employee == null) {
                        System.out.println("Les informations du client n'ont pas été supprimées\n");
                    }

                } catch (SQLException e) {
                    System.out.println("Erreur");
                    System.out.println(e);
                }

                /**Affichage**/
                for (Employes emp : vecemployee) {

                    emp.ToString();
                    System.out.println("\n");
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
        Scanner sc2 = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int id=0,choix=0;
        boolean passage = false;
        boolean pass2 = true;


        int str = 0;


        ImpleClientDAO clientDAO = new ImpleClientDAO();
        ImpleEmployeDAO employeDAO = new ImpleEmployeDAO();

        do {
            do {
                System.out.println("Voulez-vous Afficher un client : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);


            if (str == 1) {

                try {

                    do {

                        do {
                            System.out.println("Afficher un client ou tous les clients: 1-Un 2-Tous ");
                            choix = sc2.nextInt();

                        } while (choix != 1 && choix != 2);

                        if (choix == 1) {


                            pass2 = false;
                            System.out.println("Quel est l'identifiant du client : ");
                            id = identi.nextInt();

                            /**Affichage**/
                            for (Client cli : vecclient) {
                                if (id == cli.getId()) {

                                    cli.ToString();
                                    System.out.println("\n");
                                    clientDAO.ChoisirClient(id);

                                    pass2 = true;

                                    break;
                                }

                            }
                            if(!pass2)
                            {
                                System.out.println("Le client n'existe pas ");
                                pass2=true;
                            }
                        }
                        if(choix==2)
                        {

                            /**Affichage**/
                            for (Client cli : vecclient) {

                                cli.ToString();
                                System.out.println("\n");
                                employeDAO.ChoisirClient();
                            }
                            pass2 = true;
                        }

                    } while (!pass2) ;


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


    public static void AfficherEmployee(Employes employes,ArrayList<Employes> vecemployes)
    {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner identi = new Scanner(System.in);

        int id=0,choix=0;
        boolean passage = false;
        boolean pass2 = true;



        int str = 0;


        ImpleEmployeDAO employeDAO = new ImpleEmployeDAO();

        do {
            do {
                System.out.println("Voulez-vous Afficher un employee : 1-OUI 2-NON ");
                str = sc.nextInt();

            } while (str != 1 && str != 2);


            if (str == 1) {

                try {

                    do {

                        do {
                            System.out.println("Afficher un employee ou tous les employees: 1-Un 2-Tous ");
                            choix = sc2.nextInt();

                        } while (choix != 1 && choix != 2);

                        if (choix == 1) {


                            pass2 = false;
                            System.out.println("Quel est l'identifiant de l'employee : ");
                            id = identi.nextInt();


                            /**Affichage**/
                            for (Employes emp : vecemployes) {
                                if (id == emp.getId()) {

                                    emp.ToString();
                                    System.out.println("\n");
                                    employeDAO.ChoisirEmploye(id);

                                    pass2 = true;
                                    break;
                                }

                            }
                            if(!pass2)
                            {
                                System.out.println("L'identifiant de l'employee est inexistant ");
                                pass2=true;
                            }
                        }
                    if(choix==2)
                    {

                        /**Affichage**/
                        for (Employes emp : vecemployes) {

                                emp.ToString();
                                System.out.println("\n");
                                employeDAO.ChoisirEmploye();
                                pass2 = false;
                            }
                        pass2 = true;
                    }

                    } while (!pass2) ;


                    if (employes == null) {
                        System.out.println("Les informations de l'employee ne peuvent pas etre affichées\n");
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