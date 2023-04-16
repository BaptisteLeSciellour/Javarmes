package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;



import java.sql.SQLException;
import java.util.*;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Munitions;
import  com.example.javarmes.Model.DAO.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Classe de gestion de l'employee
 * @author Olivia GAAD et Baptiste Lesciellour
 * @version 3.0
 */

public class ScreenEmploye {


    /**
     * Methode de mise à jour d'employee
     * @author Olivia GAAD
     * @version 3.0
     */
    public void MAJEmploye(){
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("MAJ employe");
        txt.setLayoutX(90);
        txt.setLayoutY(150);

        Text txt4 = new Text("Saisir l'id:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        ImpleEmployeDAO employeDAO= new ImpleEmployeDAO();

        validation.setOnAction(actionEvent -> {

           try {


               Pane n = new Pane();
               Stage stage = new Stage();

               String mail = mailTF.getText();
               int id = Integer.valueOf(mail);


               ArrayList<Employes> employ= (ArrayList<Employes>) employeDAO.ChoisirEmploye();


               for (Employes emp : employ) {
                   if (emp.getId() == id) {

                       Text nvnom = new Text("Saisir le nouveau nom:");
                       nvnom.setLayoutX(90);
                       nvnom.setLayoutY(290);

                       TextField nvxnom = new TextField();
                       nvxnom.setLayoutX(90);
                       nvxnom.setLayoutY(300);

                       Text nvprenom = new Text("Saisir le nouveau prenom:");
                       nvprenom.setLayoutX(90);
                       nvprenom.setLayoutY(340);

                       TextField prenomTF = new TextField();
                       prenomTF.setLayoutX(90); // ici on les décales
                       prenomTF.setLayoutY(350); // ici on remonte les cases


                       Button saisie = new Button("Saisie");
                       saisie.setLayoutX(330);
                       saisie.setLayoutY(400);
                       n.getChildren().addAll(nvnom, nvxnom, nvprenom, prenomTF, saisie);

                       saisie.setOnAction(actionEvent1 -> {
                           Pane pane = new Pane();

                           try {
                               String prenom = prenomTF.getText();
                               String nom = nvxnom.getText();

                               Employes empl = new Employes(emp.getId(), prenom, nom);

                               Text txt2 = new Text("prenom : " + empl.getPrenom());
                               txt2.setLayoutX(90);
                               txt2.setLayoutY(150);

                               Text txt3 = new Text("nom : " + empl.getNom());
                               txt3.setLayoutX(90);
                               txt3.setLayoutY(200);

                               Text ID = new Text("ID : " + empl.getId());
                               ID.setLayoutX(90);
                               ID.setLayoutY(250);

                               employeDAO.MettreAJourEmployes(empl);

                               pane.getChildren().addAll(txt2, txt3, ID);
                               Scene scene = new Scene(pane, 520, 520);


                               stage.setScene(scene);
                           }
                           catch(SQLException e) {
                               Text supp = new Text(e.toString());
                               supp.setLayoutX(50);
                               supp.setLayoutY(100);
                               pannne.getChildren().add(supp);
                               settle.close();
                           }

                           stage.show();
                       });
                   } else {
                       Text erreur = new Text("pas de personne ce ce nom la ici");
                       erreur.setLayoutX(90);
                       erreur.setLayoutY(150);
                       n.getChildren().add(erreur);
                   }

                   Scene ssc = new Scene(n, 520, 520);
                   stage.setScene(ssc);
                   stage.show();

               }

           } catch(SQLException e) {
                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pannne.getChildren().add(supp);
               settle.close();
            }

            settle.close();
        });

        pannne.getChildren().addAll(txt,validation,txt4,mailTF);

        Scene sceene = new Scene(pannne, 320, 540);

        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    /**
     * Menu de l'employee
     * @author Baptsiste
     * @version 3.0
     */
    public void MenuEmploye()
    {
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(710);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(710);
        Bande1.setFitHeight(110);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(590);

        Text txt = new Text("Employee : Que voulez vous faire?");
        txt.setFont(new Font("Arial", 26));
        txt.setStyle("-fx-fill: white;");
        txt.setLayoutX(90);
        txt.setLayoutY(180);

        /**creer deux boutons**/
        Button bbtn = new Button("Ajouter ");
      bbtn.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        bbtn.setLayoutX(300);
        bbtn.setLayoutY(250);

        Button bbtn2 = new Button("MAJ");
       bbtn2.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn2.setLayoutX(300);
        bbtn2.setLayoutY(350);

        Button bbtn3 = new Button("Supprimer");
      bbtn3.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn3.setLayoutX(300);
        bbtn3.setLayoutY(450);

        Button bbtn4 = new Button("Gerer les stocks");
        bbtn4.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn4.setLayoutX(300);
        bbtn4.setLayoutY(550);

        Button bbtn5 = new Button("Afficher les employees");
       bbtn5.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn5.setLayoutX(300);
        bbtn5.setLayoutY(650);

        bbtn.setOnAction(actionEvent -> {
            InscriptionEmploye(); /** ici on appelle l'écran que nous allons utiliser**/
            settle.close();
        });

        bbtn2.setOnAction(actionEvent -> {
            MAJEmploye();
        });
        bbtn3.setOnAction(actionEvent -> {
            SuppresionEmploye();
        });
        bbtn4.setOnAction(actionEvent -> {

            Stock();

        });

        bbtn5.setOnAction(actionEvent -> {
            Employeafficher();

        });

        pannne.getChildren().addAll(bbtn,bbtn2,txt,bbtn3,bbtn4,Bande,Bande1,bbtn5);

        Scene sceene = new Scene(pannne, 800, 700);

        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    /**
     * Fonction de suppression d'un employee
     * @author Olivia et Baptsiste
     * @version 3.0
     */
    public void SuppresionEmploye() {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt1 = new Text("Supression de l'employé : ");
        txt1.setFont(new Font("Arial", 26));
        txt1.setStyle("-fx-fill: white;");
        txt1.setLayoutX(90);
        txt1.setLayoutY(100);
        ImpleEmployeDAO employeDAO = new ImpleEmployeDAO();

        Text txt4 = new Text("Saisir l'identifiant de cet employé:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField idTF = new TextField();
        idTF.setLayoutX(90);
        idTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);


        pane.getChildren().addAll(txt1,txt4,idTF,validation);

        validation.setOnAction(actionEvent -> {


            try {


                int id = Integer.valueOf(idTF.getText());

                Employes empl=employeDAO.ChoisirEmploye(id);


                int decalage=0;

               System.out.println("Employe :\n" + empl.getId());

                    if (empl.getId()!=-1) {

                        employeDAO.SupprimerEmployes(id);
                        Text supp = new Text("Le profil d'id : "+id+" a bien été supprimer");
                        supp.setLayoutX(100);
                        supp.setLayoutY(550);
                        pane.getChildren().add(supp);

                    }
                    else {

                            Text supp = new Text("Identifiant inexistant");
                            supp.setLayoutX(90);
                            supp.setLayoutY(500);
                        pane.getChildren().add(supp);
                    }


                ArrayList<Employes> employe=(ArrayList<Employes>)employeDAO.ChoisirEmploye();
                for(Employes emp : employe) {
                    Text supp = new Text("Employe :\n" + "Prenon: " + emp.getPrenom() + "\nNom: " + emp.getNom() + "\nID: " + emp.getId());
                    supp.setLayoutX(90);
                    supp.setLayoutY(500+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+150;

                }


            } catch (SQLException e) {
                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }


            });

        Scene scene = new Scene(pane,520,520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Fonction de statistique
     * @author Baptsiste
     * @version 3.0
     */
    public void camembertsamere(Stage primaryStage , List<Client> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Achat par client");
        int i =0;
        for(Client B : art)
        {
            System.out.print("/");
            chart.getData().add(new PieChart.Data(B.getNom(),B.getId()));
            i++;
        }

        // Montage de l'IU.
        final StackPane root = new StackPane();
        root.getChildren().add(chart);
        final Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Test de PieChart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Fonction d'affichage d'un employee
     * @author Olivia et Baptsiste
     * @version 3.0
     */
        public void Employeaffich(String prenom, String nom)
        {
            Pane pane = new Pane();
            Text txt8 = new Text("Coordonnées enregistrées :");
            txt8.setFont(new Font("Arial", 26));
            txt8.setStyle("-fx-fill: white;");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            Text txt2 = new Text("Prénom : "+prenom);
            txt2.setFont(new Font("Arial", 26));
            txt2.setStyle("-fx-fill: white;");
            txt2.setLayoutX(90);
            txt2.setLayoutY(150);

            Text txt3 = new Text("Nom : "+nom);
            txt3.setFont(new Font("Arial", 26));
            txt3.setStyle("-fx-fill: white;");
            txt3.setLayoutX(90);
            txt3.setLayoutY(200);
            pane.getChildren().addAll(txt8,txt2,txt3);
            Stage stage = new Stage();
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }



    public void Employeafficher()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt8 = new Text("Identifiant :");
        txt8.setFont(new Font("Arial", 26));
        txt8.setStyle("-fx-fill: white;");
        txt8.setLayoutX(90);
        txt8.setLayoutY(90);

        TextField txtfield = new TextField();
        txtfield.setLayoutX(90);
        txtfield.setLayoutY(200);


        Button re = new Button("Afficher un employee");
        re.setLayoutX(90);
        re.setLayoutY(300);

        Button de = new Button("Afficher tous les employees");
        de.setLayoutX(300);
        de.setLayoutY(300);

        pane.getChildren().addAll(txt8,re,de,txtfield);

        ImpleEmployeDAO employeDAO=new ImpleEmployeDAO();

        re.setOnAction(actionEvent -> {

            try {

               int  id=Integer.valueOf(txtfield.getText());

               Employes emp=employeDAO.ChoisirEmploye(id);


                    Text supp = new Text("Employe :\n" + "Prenon: " + emp.getPrenom() + "\nNom: " + emp.getNom()+ "\nID: "+ emp.getId() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(600);
                    pane.getChildren().add(supp);


            } catch (SQLException e) {

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }
        });

        de.setOnAction(actionEvent -> {
            try {
              int decalage =0;

              ArrayList<Employes> employ=(ArrayList<Employes>)employeDAO.ChoisirEmploye();


              for(Employes emp : employ) {
                  Text supp = new Text("Employe :\n" + "Prenon: " + emp.getPrenom() + "\nNom: " + emp.getNom() + "\nID: " + emp.getId());
                  supp.setLayoutX(90);
                  supp.setLayoutY(300+decalage);
                  pane.getChildren().add(supp);
                  decalage=decalage+150;

              }
            } catch (SQLException e) {

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }

        });

        Scene scene = new Scene(pane,520,520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Fonction d'inscription d'un employee
     * @author Olivia et Baptsiste
     * @version 3.0
     */
        public void InscriptionEmploye() /** Nous avons un second écran qui apparait**/
        {
            Pane panne = new Pane();
            Pane n = new Pane();
            Stage settle = new Stage();

            Image txt1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/creapro.jpg")));
            //Creating a rotated transition
            ImageView Txt1 = new ImageView(txt1);
            Txt1.setLayoutY(120);
            Txt1.setLayoutX(50);
            Txt1.setFitWidth(700);
            Txt1.setFitHeight(100);

            Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            //Creating a rotated transition
            ImageView Loog = new ImageView(loog);
            Loog.setLayoutY(1);
            Loog.setFitWidth(800);
            Loog.setFitHeight(130);
            Loog.setLayoutX(1);


            Text txt = new Text("Nom");
            txt.setFont(new Font("Arial", 26));
            txt.setStyle("-fx-fill: white;");
            txt.setLayoutX(300);
            txt.setLayoutY(290);

            TextField pr = new TextField();
            pr.setLayoutX(300);
            pr.setLayoutY(310);

            Text txxt = new Text("Prenom");
            txxt.setFont(new Font("Arial", 26));
            txxt.setStyle("-fx-fill: white;");
            txxt.setLayoutX(300);
            txxt.setLayoutY(380);

            TextField nm = new TextField();
            nm.setLayoutX(300); // ici on les décales
            nm.setLayoutY(400); // ici on remonte les cases

            CheckBox cb1 = new CheckBox("J'atteste ajouter un membre du staff.");
            cb1.setLayoutX(300);
            cb1.setLayoutY(450);




            Button bbtn = new Button("Ajouter l'employé(e)");
            bbtn.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
            bbtn.setLayoutX(300);
            bbtn.setLayoutY(600);

            ImpleEmployeDAO employeDAO=new ImpleEmployeDAO();

            bbtn.setOnAction(event1->{

                try {

                    ArrayList<Employes> emp=(ArrayList<Employes>)employeDAO.ChoisirEmploye();

                    int id;
                    do {


                        /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
                        Random rand = new Random();
                        id = rand.nextInt(4500 + 14500); /** generation aléatoire**/

                    } while (id!=0);

                    String prenom = pr.getText();

                    String nom = nm.getText();

                    int cpt=0;

                    for(Employes e: emp)
                    {

                       if(prenom.equals(e.getPrenom()) && nom.equals(e.getNom()))
                       {
                           cpt++;

                       }

                    }

                   Employes empl = new Employes(id, nom,prenom);


                    if(cpt==0)
                    {
                        employeDAO.AjouterEmployes(empl);

                        Employeaffich(prenom, nom);
                    }
                    else
                    {

                        Text sup = new Text("Cet employe existe deja");
                        sup.setLayoutX(90);
                        sup.setLayoutY(600);
                        n.getChildren().add(sup);

                        settle.close();

                    }
                    Scene ssc = new Scene(n, 520, 520);
                    settle.setScene(ssc);
                    settle.show();


                    MenuEmploye();

                    settle.close();
                }
             catch (SQLException e) {

            Text supp = new Text(e.toString());
            supp.setLayoutX(50);
            supp.setLayoutY(100);
            panne.getChildren().add(supp);
            settle.close();
        }

            });
            panne.getChildren().addAll(bbtn,pr,nm,txt,txxt,Txt1,cb1,Loog);

            Scene sceene = new Scene(panne,800,700);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            settle.setScene(sceene);
            settle.setX(0);
            settle.setY(0);
            settle.show();
        }



    /**
     * Fonction de gestion des stocks
     * @author Olivia
     * @version 3.0
     */
        public  void Stock()
        {

            Pane pane = new Pane();
            Stage stage = new Stage();

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(710);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(710);
            Bande1.setFitHeight(110);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(590);

            Button arme = new Button("Armes");
            arme.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            arme.setLayoutX(300);
            arme.setLayoutY(250);

            Button muni = new Button("Munuitions");
            muni.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            muni.setLayoutX(300);
            muni.setLayoutY(350);




            arme.setOnAction(actionEvent -> {

                StockArmes();


            });

            muni.setOnAction(actionEvent -> {

                StockMunitions();
            });

            pane.getChildren().addAll(muni,arme,Bande,Bande1);


            Scene sceene = new Scene(pane, 800, 700);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }

    /**
     * Fonction de gestion des stocks d'armes
     * @author Olivia
     * @version 3.0
     */

        public void StockArmes()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Button ajt = new Button("Ajouter une arme");
            ajt.setLayoutX(90);
            ajt.setLayoutY(300);

            Button sup = new Button("Supprimer une arme");
            sup.setLayoutX(210);
            sup.setLayoutY(300);

            Button aff = new Button("Afficher les armes");
            aff.setLayoutX(370);
            aff.setLayoutY(300);

            Button re = new Button("Rechercher une armes");
            re.setLayoutX(510);
            re.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutArme();

            });

            sup.setOnAction(actionEvent -> {

                SupprimerArmes();

            });


            aff.setOnAction(actionEvent -> {

                Armesaffich();

            });

            re.setOnAction(actionEvent -> {

                RechercherArmes();

            });

            pane.getChildren().addAll(sup,ajt,aff,re);


            Scene sceene = new Scene(pane, 320, 540);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }

    /**
     * Fonction d'ajout d'arme dans le stock
     * @author Olivia
     * @version 3.0
     */
        public  void AjoutArme()
        {  Pane pane = new Pane();
            Stage stage = new Stage();

            Armes armes = new Armes();

            /**identification de l'arme**/
            Text ident = new Text("Saisir le nom de l'identification:");
            ident.setLayoutX(90);
            ident.setLayoutY(90);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(100);

            /**categorie**/
            Text CAT = new Text("Saisir la categorie :  B OU C");
            CAT.setLayoutX(90);
            CAT.setLayoutY(150);


            /**Catégorie Bou C**/
            Button b = new Button("B");
            b.setLayoutX(90);
            b.setLayoutY(160);

            Button c = new Button("C");
            c.setLayoutX(150);
            c.setLayoutY(160);



            b.setOnAction(actionEvent -> {

                armes.setCategorie("B");

            });

            c.setOnAction(actionEvent -> {

                armes.setCategorie("C");

            });

            //ImageView imageView = new ImageView();

            //imageView=DonationImage();


            /**type**/
            Text tp = new Text("Saisir le type :");
            tp.setLayoutX(90);
            tp.setLayoutY(210);


            /**Catégorie Bou C**/
            Button poing = new Button("Poing");
            poing.setLayoutX(90);
            poing.setLayoutY(220);

            Button assaut = new Button("Assaut");
            assaut.setLayoutX(150);
            assaut.setLayoutY(220);

            /**Catégorie Bou C**/
            Button chasse = new Button("Chasse");
            chasse.setLayoutX(250);
            chasse.setLayoutY(220);

            Button precision = new Button("Precision");
            precision.setLayoutX(350);
            precision.setLayoutY(220);


            poing.setOnAction(actionEvent -> {

                armes.setType("Poing");

            });

            assaut.setOnAction(actionEvent -> {

                armes.setType("Assaut");

            });

            chasse.setOnAction(actionEvent -> {


                armes.setType("Chasse");

            });

            precision.setOnAction(actionEvent -> {

                armes.setType("Precision");

            });


            /**prix**/
            Text pr = new Text("Saisir le prix");
            pr.setLayoutX(90);
            pr.setLayoutY(270);

            TextField prix = new TextField();
            prix.setLayoutX(90);
            prix.setLayoutY(280);

            /**nom**/
            Text nm = new Text("Saisir le nom");
            nm.setLayoutX(90);
            nm.setLayoutY(330);

            TextField nom = new TextField();
            nom.setLayoutX(90);
            nom.setLayoutY(340);

            /**Calibre**/
            Text cl = new Text("Saisir le calibre");
            cl.setLayoutX(90);
            cl.setLayoutY(390);

            TextField cal = new TextField();
            cal.setLayoutX(90);
            cal.setLayoutY(400);

            /**Reduction**/
            Text red = new Text("Saisir si une réduction est appliquée :  ");
            red.setLayoutX(90);
            red.setLayoutY(450);


            Button oui = new Button("OUI");
            oui.setLayoutX(90);
            oui.setLayoutY(460);

            Button non = new Button("NON");
            non.setLayoutX(130);
            non.setLayoutY(460);

            oui.setOnAction(actionEvent -> {

                armes.setReduction(true);

            });

            non.setOnAction(actionEvent -> {

                armes.setReduction(false);

            });

            Text qt = new Text("Saisir la quantite");
            qt.setLayoutX(90);
            qt.setLayoutY(510);

            TextField quant = new TextField();
            quant.setLayoutX(90);
            quant.setLayoutY(520);

            /**valide les données**/
            Button ajt = new Button("Valider");
            ajt.setLayoutX(400);
            ajt.setLayoutY(300);


            // Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);
            ImpleArmesDAO armesDAO = new ImpleArmesDAO();


            pane.getChildren().addAll(oui,qt,quant,non,cal,idTF, b,c,prix,ajt,ident,CAT,tp,pr,nm,cl,red,nom,poing,chasse,assaut,precision);


            ajt.setOnAction(actionEvent -> {

                int quantite=0;

                /**Quantite **/
                do {
                    quantite= Integer.valueOf(quant.getText());

                    armes.setQuantite(quantite);

                } while (quantite <0 );


                armes.setNom( nom.getText());

                armes.setIdentification( String.valueOf(idTF.getText()));

                /**Prix **/
                do {
                    armes.setPrix_unique( Integer.valueOf(prix.getText()));

                } while (armes.getPrix_unique() <=0 );


                /**calibre **/
                do {
                    armes.setCalibre(Integer.valueOf(cal.getText()));

                } while (armes.getCalibre() <=0 );

                //Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);

                //vecarmes.add(armes);

                try {

                    armesDAO.AjouterArme(armes);


                    if (armes != null) {

                        Text supp = new Text("Armes ajouté :\n" + "identification: " + armes.getIndentification() + "\ncategorie: " + armes.getCategorie() + "\ntype: " + armes.getType() + "\nnom: " + armes.getNom()+ "\nquantite: "+ armes.getQuantite() + "\ncalibre: " + armes.getCalibre()+ "\nreduction: " + armes.getReduction()+ "\nprix: " + armes.getPrix_unique() );
                        supp.setLayoutX(90);
                        supp.setLayoutY(600);
                        pane.getChildren().add(supp);



                    }
                } catch (SQLException e) {

                    Text supp = new Text(e.toString());
                    supp.setLayoutX(50);
                    supp.setLayoutY(100);
                    pane.getChildren().add(supp);
                    stage.close();
                }

            });

            Scene scene = new Scene(pane, 520, 520);

            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(scene);
            stage.show();


        }

    /**
     * Fonction affichage du stock d'armes
     * @author Olivia
     * @version 3.0
     */
        public void Armesaffich()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt8 = new Text("Voici les armes :");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            ImpleArmesDAO armesDAO = new ImpleArmesDAO();


            try {

                int decalage=0;

                ArrayList<Armes> ResultatRecherche= (ArrayList<Armes>)armesDAO.ChoisirArmes();


                //Verification : si id existe deja
                for (Armes arm : ResultatRecherche) {

                    Text supp = new Text("Armes :\n" + "identification: " + arm.getIndentification() + "\ncategorie: " + arm.getCategorie() + "\nprix unique: " + arm.getPrix_unique()+ "\ncalibre: " + arm.getCalibre()+ "\nnom: " + arm.getNom()+ "\nreduction: " + arm.getReduction()+ "\nquantite : " + arm.getQuantite() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(300+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+150;
                }
            }
            catch (SQLException e) {


                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }



            pane.getChildren().addAll(txt8);
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }

    /**
     * Fonction de recherche d'armes
     * @author Olivia
     * @version 3.0
     */
    public void RechercherArmes()
    {

        Pane pane = new Pane();
        Stage stage = new Stage();

        Armes armes=new Armes();

        Text txt1 = new Text("Recherche d'une arme : ");
        txt1.setLayoutX(90);
        txt1.setLayoutY(100);


        ImpleArmesDAO armesDAO = new ImpleArmesDAO();

        /**categorie**/
        Text CAT = new Text("Saisir la categorie :  B OU C");
        CAT.setLayoutX(90);
        CAT.setLayoutY(150);


        /**Catégorie Bou C**/
        Button b = new Button("B");
        b.setLayoutX(90);
        b.setLayoutY(160);

        Button c = new Button("C");
        c.setLayoutX(150);
        c.setLayoutY(160);

        b.setOnAction(actionEvent -> {

            armes.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            armes.setCategorie("C");

        });


        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(240);

        pane.getChildren().addAll(txt1,b,c,validation,CAT);



        validation.setOnAction(actionEvent -> {


             try {

                 int decalage=0;

                 ArrayList<Article> ResultatRecherche= (ArrayList<Article>) armesDAO.RechercherArmes("categorie", armes.getCategorie());


                 //Verification : si id existe deja
                 for (Article art : ResultatRecherche) {

                     System.out.println(art.getIndentification()+art.getNom()+art.getCategorie());

                     Text supp = new Text("Armes :\n" + "identification: " + art.getIndentification() + "\ncategorie: " + art.getCategorie() + "\nprix unique: " + art.getPrix_unique()+ "\ncalibre: " + art.getCalibre()+ "\nnom: " + art.getNom()+ "\nreduction: " + art.getReduction()+ "\nquantite : " + art.getQuantite() );
                     supp.setLayoutX(90);
                     supp.setLayoutY(300+decalage);
                     pane.getChildren().add(supp);
                     decalage=decalage+150;
                 }


             } catch (SQLException e) {
             Text supp = new Text(e.toString());
             supp.setLayoutX(50);
             supp.setLayoutY(100);
             pane.getChildren().add(supp);
             stage.close();
             }

        });

        Scene scene = new Scene(pane,520,520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();

    }


    /**
     * Fonction de suppression d'armes
     * @author Olivia
     * @version 3.0
     */
        public  void SupprimerArmes()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt1 = new Text("Supression d'une arme : ");

            ImpleArmesDAO armesDAO = new ImpleArmesDAO();

            Text txt4 = new Text("Saisir l'identification:");
            txt4.setLayoutX(90);
            txt4.setLayoutY(290);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(300);

            Button validation = new Button("Validation");
            validation.setLayoutX(90);
            validation.setLayoutY(400);

            pane.getChildren().addAll(txt1,txt4,idTF,validation);

            validation.setOnAction(actionEvent -> {


                 try {

                 String identification = String.valueOf(idTF.getText());

                     Armesaffich();
                     armesDAO.SupprimerArme(identification);

                     Armesaffich();


                 } catch (SQLException e) {
                 Text supp = new Text(e.toString());
                 supp.setLayoutX(50);
                 supp.setLayoutY(100);
                 pane.getChildren().add(supp);
                 stage.close();
                 }

            });

            Scene scene = new Scene(pane,520,520);

            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(scene);
            stage.show();
        }

    /**
     * Fonction de gestion de munitions
     * @author Olivia
     * @version 3.0
     */
        public  void StockMunitions()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Button ajt = new Button("Ajouter une munition");
            ajt.setLayoutX(90);
            ajt.setLayoutY(300);

            Button sup = new Button("Supprimer une munition");
            sup.setLayoutX(250);
            sup.setLayoutY(300);

            Button aff = new Button("Afficher les munitions");
            aff.setLayoutX(440);
            aff.setLayoutY(300);

            Button re = new Button("Rechercher une munition");
            re.setLayoutX(580);
            re.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutMunitions();

            });

            sup.setOnAction(actionEvent -> {

                SupprimerMunitions();

            });

            aff.setOnAction(actionEvent -> {

                Munitionsaffich();

            });

            re.setOnAction(actionEvent -> {

                RechercherMunitions();
            });


            pane.getChildren().addAll(sup,ajt,aff,re);


            Scene sceene = new Scene(pane, 320, 540);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }

    /**
     * Fonction de recherche de munitions
     * @author Olivia
     * @version 3.0
     */
    public void RechercherMunitions()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Munitions munitions=new Munitions();

        Text txt1 = new Text("Recherche d'une munition : ");
        txt1.setLayoutX(90);
        txt1.setLayoutY(100);

        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        /**categorie**/
        Text CAT = new Text("Saisir la categorie :  B OU C");
        CAT.setLayoutX(90);
        CAT.setLayoutY(150);


        /**Catégorie Bou C**/
        Button b = new Button("B");
        b.setLayoutX(90);
        b.setLayoutY(160);

        Button c = new Button("C");
        c.setLayoutX(150);
        c.setLayoutY(160);

        b.setOnAction(actionEvent -> {

            munitions.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            munitions.setCategorie("C");

        });

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        pane.getChildren().addAll(txt1,b,c,CAT,validation);

        validation.setOnAction(actionEvent -> {



 try {



     ArrayList<Munitions> ResultatRecherche=(ArrayList<Munitions>) munitionsDAO.RechercherMunitions("categorie",munitions.getCategorie());
     int decalage=0;


     //Verification : si id existe deja
     for (Article art : ResultatRecherche) {

         art.getNom();

         System.out.println(art.getIndentification()+art.getNom()+art.getCategorie());

         Text supp = new Text("Armes :\n" + "identification: " + art.getIndentification() + "\ncategorie: " + art.getCategorie() + "\nprix unique: " + art.getPrix_unique()+ "\ncalibre: " + art.getCalibre()+ "\nnom: " + art.getNom()+ "\nreduction: " + art.getReduction()+ "\nquantite : " + art.getQuantite() );
         supp.setLayoutX(90);
         supp.setLayoutY(500+decalage);
         pane.getChildren().add(supp);
         decalage=decalage+150;

     }

 } catch (SQLException e) {
 Text supp = new Text(e.toString());
 supp.setLayoutX(50);
 supp.setLayoutY(100);
 pane.getChildren().add(supp);
 stage.close();
 }

        });

        Scene scene = new Scene(pane,520,520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();

    }


    /**
     * Fonction d'affichage de munitions
     * @author Olivia
     * @version 3.0
     */
        public void Munitionsaffich()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt8 = new Text("Voici les munitions :");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


            try {

                int decalage=0;

                ArrayList<Munitions> ResultatRecherche= (ArrayList<Munitions>)munitionsDAO.ChoisirMunitions();


                /**Affichage**/
                for (Munitions muni : ResultatRecherche) {


                    Text supp = new Text("Munition :\n" + "identification : " + muni.getIndentification() + "\ncategorie : " + muni.getCategorie() + "\nprix unique : " + muni.getPrix_unique()+ "\nprix vrac: " + muni.getPrix_vrac() + "\nreduction : " + muni.getReduction()+ "\ncalibre : " + muni.getCalibre()+ "\nquantite : " + muni.getQuantite()+ "\nnom: " + muni.getNom() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(300+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+150;

                }
            }
            catch (SQLException e) {
                //  System.out.println("Erreur");
                //System.out.println(e);

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }



            pane.getChildren().addAll(txt8);
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }

    /**
     * Fonction d'ajout de munitions
     * @author Olivia
     * @version 3.0
     */
    public  void AjoutMunitions()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();


        Munitions muni=new Munitions();

        Text ident = new Text("Saisir le nom de l'identification:");
        ident.setLayoutX(90);
        ident.setLayoutY(90);

        TextField idTF = new TextField();
        idTF.setLayoutX(90);
        idTF.setLayoutY(100);

        /**categorie**/
        Text CAT = new Text("Saisir la categorie :  B OU C");
        CAT.setLayoutX(90);
        CAT.setLayoutY(150);

        /**Catégorie B ou C**/
        Button b = new Button("B");
        b.setLayoutX(90);
        b.setLayoutY(160);

        Button c = new Button("C");
        c.setLayoutX(150);
        c.setLayoutY(160);

        b.setOnAction(actionEvent -> {

            muni.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            muni.setCategorie("C");

        });


        Text pr = new Text("Saisir le prix unique");
        pr.setLayoutX(90);
        pr.setLayoutY(210);

        TextField prix = new TextField();
        prix.setLayoutX(90);
        prix.setLayoutY(220);

        Text prvc = new Text("Saisir le prix en vrac");
        prvc.setLayoutX(90);
        prvc.setLayoutY(270);

        TextField prixvrac = new TextField();
        prixvrac.setLayoutX(90);
        prixvrac.setLayoutY(280);

        Text nm = new Text("Saisir le nom");
        nm.setLayoutX(90);
        nm.setLayoutY(330);

        TextField no = new TextField();
        no.setLayoutX(90);
        no.setLayoutY(340);


        Text cl = new Text("Saisir le calibre");
        cl.setLayoutX(90);
        cl.setLayoutY(390);

        TextField cal = new TextField();
        cal.setLayoutX(90);
        cal.setLayoutY(400);

        /**Reduction**/
        Text red = new Text("Saisir si une réduction est appliquée :  ");
        red.setLayoutX(90);
        red.setLayoutY(450);


        Button oui = new Button("OUI");
        oui.setLayoutX(90);
        oui.setLayoutY(460);

        Button non = new Button("NON");
        non.setLayoutX(130);
        non.setLayoutY(460);

        oui.setOnAction(actionEvent -> {

            muni.setReduction(true);

        });

        non.setOnAction(actionEvent -> {

            muni.setReduction(false);

        });

        Text qt = new Text("Saisir la quantite");
        qt.setLayoutX(90);
        qt.setLayoutY(510);

        TextField quant = new TextField();
        quant.setLayoutX(90);
        quant.setLayoutY(520);

        Button ajt = new Button("Valider");
        ajt.setLayoutX(400);
        ajt.setLayoutY(300);


        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        pane.getChildren().addAll(cal,idTF,prvc,prixvrac,prix,no,qt,quant,ajt,ident,CAT,pr,nm,cl,red,oui,non,b,c);


        ajt.setOnAction(actionEvent -> {

            String identification,categorie, nom;
            double prix_unique,prix_vrac, calibre;
            int quantite,nb_vente;

            /**Quantite **/
            do {
                quantite= Integer.valueOf(quant.getText());

                muni.setQuantite(quantite);

            } while (quantite <0 );


            muni.setIndentification( String.valueOf(idTF.getText()));


            /**Prix **/
            do {
                prix_unique = Integer.valueOf(prix.getText());
                muni.setPrix_unique(prix_unique);

            } while (prix_unique <=0 );

            /**Prix **/
            do {
                prix_vrac = Integer.valueOf(prixvrac.getText());

                muni.setPrix_vrac(prix_vrac);

            } while (prix_unique <=0 );

            muni.setNom ( no.getText());


            /**calibre **/
            do {
                calibre = Integer.valueOf(cal.getText());
                muni.setCalibre(calibre);

            } while (calibre <=0 );


            try {


                int decalage=0;

                munitionsDAO.ajouter(muni);

                ArrayList<Munitions> munit=(ArrayList<Munitions>)munitionsDAO.ChoisirMunitions();


                for(Munitions u : munit)
                {

                    Text supp = new Text("Munition :\n" + "identification : " + muni.getIndentification() + "\ncategorie : " + muni.getCategorie() + "\nprix unique : " + muni.getPrix_unique()+ "\nprix vrac: " + muni.getPrix_vrac() + "\nreduction : " + muni.getReduction()+ "\ncalibre : " + muni.getCalibre()+ "\nquantite : " + muni.getQuantite()+ "\nnom: " + muni.getNom() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(570+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+150;
                }

            } catch (SQLException e) {

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }

        });


        Scene scene = new Scene(pane, 520, 520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Fonction de suppression de munitions
     * @author Olivia
     * @version 3.0
     */
        public  void SupprimerMunitions()
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt1 = new Text("Supression d'une munition : ");

            ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();

            Text txt4 = new Text("Saisir l'identification:");
            txt4.setLayoutX(90);
            txt4.setLayoutY(290);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(300);

            Button validation = new Button("Validation");
            validation.setLayoutX(90);
            validation.setLayoutY(400);

            pane.getChildren().addAll(txt1,txt4,idTF,validation);

            validation.setOnAction(actionEvent -> {



                 try {


                 String identification =  idTF.getText();
                 int quantite=-1;

                     Munitionsaffich();

                     munitionsDAO.GererStockMunition(identification,quantite);

                     Munitionsaffich();


                 } catch (SQLException e) {
                 Text supp = new Text(e.toString());
                 supp.setLayoutX(50);
                 supp.setLayoutY(100);
                 pane.getChildren().add(supp);
                 stage.close();
                 }
            });

            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }
    }



