package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



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

//Histogramme
/**Sources : https://java.developpez.com/faq/javafx?page=Graphes-statistiques#:~:text=Pour%20cr%C3%A9er%20un%20histogramme%20empil%C3%A9,contiendront%20les%20valeurs%20%C3%A0%20afficher**/

/**
 * Classe de gestion de l'employee
 * @author Olivia GAAD et Baptiste Le Sciellour
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


        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/majemploye.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(250);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);

        Text txt4 = new Text("Saisir l'id:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
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
                       nvnom.setFont(new Font("Arial", 26));
                       nvnom.setStyle("-fx-fill: white;");
                       nvnom.setLayoutX(90);
                       nvnom.setLayoutY(290);

                       TextField nvxnom = new TextField();
                       nvxnom.setLayoutX(90);
                       nvxnom.setLayoutY(300);

                       Text nvprenom = new Text("Saisir le nouveau prenom:");
                       nvprenom.setFont(new Font("Arial", 26));
                       nvprenom.setStyle("-fx-fill: white;");
                       nvprenom.setLayoutX(90);
                       nvprenom.setLayoutY(340);

                       TextField prenomTF = new TextField();
                       prenomTF.setLayoutX(90); // ici on les décales
                       prenomTF.setLayoutY(350); // ici on remonte les cases


                       Button saisie = new Button("Saisie");
                       saisie.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
                       saisie.setLayoutX(330);
                       saisie.setLayoutY(400);
                       n.getChildren().addAll(nvnom, nvxnom, nvprenom, prenomTF, saisie);

                       saisie.setOnAction(actionEvent1 -> {
                           Pane pane = new Pane();

                           try {
                               String prenom = prenomTF.getText();
                               String nom = nvxnom.getText();


                               Employes empl = new Employes(emp.getId(), prenom, nom);

                               Image bande3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
                               ImageView Bande3 = new ImageView(bande3);
                               Bande3.setFitWidth(800);
                               Bande3.setFitHeight(110);
                               Bande3.setLayoutX(0);
                               Bande3.setLayoutY(0);

                               Image bande4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
                               ImageView Bande4 = new ImageView(bande4);
                               Bande4.setFitWidth(800);
                               Bande4.setFitHeight(90);
                               Bande4.setLayoutX(0);
                               Bande4.setLayoutY(610);


                               Text txt2 = new Text("PRENOM : " + empl.getPrenom());
                               txt2.setFont(new Font("Arial", 26));
                               txt2.setStyle("-fx-fill: white;");
                               txt2.setLayoutX(90);
                               txt2.setLayoutY(150);

                               Text txt3 = new Text("NOM : " + empl.getNom());
                               txt3.setFont(new Font("Arial", 26));
                               txt3.setStyle("-fx-fill: white;");
                               txt3.setLayoutX(90);
                               txt3.setLayoutY(200);

                               Text ID = new Text("ID : " + empl.getId());
                               ID.setFont(new Font("Arial", 26));
                               ID.setStyle("-fx-fill: white;");
                               ID.setLayoutX(90);
                               ID.setLayoutY(250);

                               employeDAO.MettreAJourEmployes(empl);

                               pane.getChildren().addAll(txt2, txt3, ID,Bande3,Bande4);
                               Scene scene = new Scene(pane, 800, 700);


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

                   Scene ssc = new Scene(n, 800, 700);
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

        pannne.getChildren().addAll(Bande,Bande1,validation,txt4,mailTF);

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
     * Menu de l'employee
     * @author Baptiste
     * @version 3.0
     */
    public void MenuEmploye()
    {
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(700);


        Image txt = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/voulez.jpg")));
        ImageView Txt = new ImageView(txt);
        Txt.setFitWidth(600);
        Txt.setFitHeight(50);
        Txt.setLayoutX(100);
        Txt.setLayoutY(130);


        /**creer deux boutons**/
        Button bbtn = new Button("Ajouter ");
      bbtn.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        bbtn.setLayoutX(300);
        bbtn.setLayoutY(250);

        Button bbtn2 = new Button("MAJ");
       bbtn2.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn2.setLayoutX(300);
        bbtn2.setLayoutY(320);

        Button bbtn3 = new Button("Supprimer");
      bbtn3.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn3.setLayoutX(300);
        bbtn3.setLayoutY(390);

        Button bbtn4 = new Button("Gerer les stocks");
        bbtn4.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn4.setLayoutX(300);
        bbtn4.setLayoutY(460);

        Button bbtn5 = new Button("Afficher les employees");
       bbtn5.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn5.setLayoutX(300);
        bbtn5.setLayoutY(530);

        Button bbtn6 = new Button("Statistiques ");
        bbtn6.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn6.setLayoutX(300);
        bbtn6.setLayoutY(600);


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

        bbtn6.setOnAction(actionEvent -> {
            Statistique();

        });


        pannne.getChildren().addAll(bbtn,bbtn2,Txt,bbtn3,bbtn4,Bande,Bande1,bbtn5,bbtn6);

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
     * @author Olivia et Baptiste
     * @version 3.0
     */
    public void SuppresionEmploye() {
        Pane pane = new Pane();
        Stage stage = new Stage();



        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(300);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);

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
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        validation.setLayoutX(90);
        validation.setLayoutY(400);


        pane.getChildren().addAll(txt1,txt4,idTF,validation,Bande,Bande1);

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

        Scene scene = new Scene(pane,800,700);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Classe pour l'écran du menu d'acceuil. Cette fonction va nous servir à donner le choix à l'utilisateur de s'inscrire en tant qu'employé ou client.
     * @author Maléna et Baptiste
     * @version 3.0
     */
    public void Statistique()
    {

        Pane panne = new Pane();
        Stage settle = new Stage();

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/typ2.jpg")));
        //Creating a rotated transition
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(0);
        Loog.setLayoutX(0);
        Loog.setFitWidth(800);
        Loog.setFitHeight(230);

        Image loogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Loogo = new ImageView(loogo);
        Loogo.setLayoutY(550);
        Loogo.setLayoutX(0);
        Loogo.setFitWidth(800);
        Loogo.setFitHeight(150);


        Button camm = new Button("Camembert Munition : ");
        camm.setLayoutX(300);
        camm.setLayoutY(300);

        Button cama = new Button("Camembert Armes : ");
        cama.setLayoutX(300);
        cama.setLayoutY(350);

        Button hista = new Button("Histogramme Armes : ");
        hista.setLayoutX(300);
        hista.setLayoutY(400);

        Button histm = new Button("Histogramme Munitions : ");
        histm.setLayoutX(300);
        histm.setLayoutY(450);

        camm.setOnAction(actionEvent -> {
            ScreenEmploye sc = new ScreenEmploye();

            Stage st = new Stage();

            ImpleMunitionsDAO implm = new ImpleMunitionsDAO();

            List<Munitions> muni;

            try {

                muni=implm.ChoisirMunitions();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            sc.camembertMunition(st,muni);

        });


        cama.setOnAction(actionEvent -> {
            ScreenEmploye sc = new ScreenEmploye();

            Stage staage = new Stage();

            ImpleArmesDAO imple = new ImpleArmesDAO();

            List<Armes> art ;


            try {
                art=imple.ChoisirArmes();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            sc.camembertArme(staage , art);

        });

        hista.setOnAction(actionEvent -> {
            ScreenEmploye sc = new ScreenEmploye();

            Stage primaryStage = new Stage();

            ImpleArmesDAO imple = new ImpleArmesDAO();

            List<Armes> art ;


            try {

                art=imple.ChoisirArmes();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            sc.HistogrammeTauxdereduction_Armes(primaryStage,art);

        });

        histm.setOnAction(actionEvent -> {
            ScreenEmploye sc = new ScreenEmploye();

            Stage pr = new Stage();

            ImpleMunitionsDAO implm = new ImpleMunitionsDAO();

            List<Munitions> muni;

            try {

                muni=implm.ChoisirMunitions();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            sc.HistogrammeTauxdereduction_Munitions(pr,muni);
        });


        panne.getChildren().addAll(hista,histm,cama,camm,Loog,Loogo);

        Scene sceene = new Scene(panne, 800, 700);
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
     * Fonction de production de camembert au bon lait crue pour le nombre de commandes par Clients
     * @author Baptiste
     * @version 3.0
     */
    public void camembertCLient(Stage primaryStage , List<Client> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Achat par client");
        int i =0;
        for(Client B : art)
        {
            System.out.print("/");
            chart.getData().add(new PieChart.Data(B.getMail(),B.getNb_commandes()));
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
     * Fonction de production de camembert au bon lait crue pour le nombre de ventes par armes
     * @author Baptiste
     * @version 3.0
     * @param primaryStage : ecran principal
     * @param art : Liste armes
     */
    public void camembertArme(Stage primaryStage , List<Armes> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Nombre de vente par arme");
        int i =0;
        for(Armes B : art)
        {
            System.out.print("/");
            chart.getData().add(new PieChart.Data(B.getNom(),B.getNb_vente()));
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
     * Fonction de production de camembert au bon lait crue pour le nombre de ventes par armes
     * @author Baptiste
     * @version 3.0
     * @param primaryStage : ecran principal
     * @param art : Liste armes
     */
    public void camembertMunition(Stage primaryStage , List<Munitions> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Nombre de vente par munition");
        int i =0;
        for(Munitions B : art)
        {
            System.out.print("/");
            chart.getData().add(new PieChart.Data(B.getNom(),B.getNb_vente()));
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
     * Fonction histogramme
     * @author Olivia
     * @version 3.0
     * @param primaryStage : ecran principal
     * @param art : Liste armes
     */
    public void HistogrammeTauxdereduction_Armes(Stage primaryStage , List<Armes> art) {

        // Données à utiliser pour l'histogramme
        ObservableList<XYChart.Data<String, Number>> venteData = FXCollections.observableArrayList();
        ObservableList<XYChart.Data<String, Number>> quantiteData = FXCollections.observableArrayList();


        for (Armes a : art) {
            venteData.add(new XYChart.Data<>(a.getIndentification(), a.getNb_vente()));
            quantiteData.add(new XYChart.Data<>(a.getIndentification(), a.getQuantite()));
        }

        // Axe X
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Identification");

        // Axe Y pour la vente
        NumberAxis venteAxis = new NumberAxis();
        venteAxis.setLabel("Vente");

        // Axe Y pour la quantité
        NumberAxis quantiteAxis = new NumberAxis();
        //quantiteAxis.setLabel("Quantité");

        // Création de la série de données pour la vente
        XYChart.Series<String, Number> venteSeries = new XYChart.Series<>();
        venteSeries.setName("Vente");
        venteSeries.setData(venteData);

        // Création de la série de données pour la quantité
        XYChart.Series<String, Number> quantiteSeries = new XYChart.Series<>();
        quantiteSeries.setName("Quantité");
        quantiteSeries.setData(quantiteData);

        // Création de l'histogramme
        BarChart<String, Number> barChart = new BarChart<>(xAxis, quantiteAxis);
        barChart.setTitle("Vente et quantité par arme");
        barChart.getData().addAll(venteSeries, quantiteSeries);

        // Montage de l'IU
        Scene scene = new Scene(barChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Fonction histogramme
     * @author Olivia
     * @version 3.0
     * @param primaryStage : ecran principal
     * @param muni : Liste de munition
     */
    public void HistogrammeTauxdereduction_Munitions(Stage primaryStage , List<Munitions> muni) {

        // Données à utiliser pour l'histogramme
        ObservableList<XYChart.Data<String, Number>> venteData = FXCollections.observableArrayList();
        ObservableList<XYChart.Data<String, Number>> quantiteData = FXCollections.observableArrayList();


        for (Munitions m : muni) {
            venteData.add(new XYChart.Data<>(m.getIndentification(), m.getNb_vente()));
            quantiteData.add(new XYChart.Data<>(m.getIndentification(), m.getQuantite()));
        }

        // Axe X
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Identification");

        // Axe Y pour la vente
        NumberAxis venteAxis = new NumberAxis();
        venteAxis.setLabel("Vente");

        // Axe Y pour la quantité
        NumberAxis quantiteAxis = new NumberAxis();
        //quantiteAxis.setLabel("Quantité");

        // Création de la série de données pour la vente
        XYChart.Series<String, Number> venteSeries = new XYChart.Series<>();
        venteSeries.setName("Vente");
        venteSeries.setData(venteData);

        // Création de la série de données pour la quantité
        XYChart.Series<String, Number> quantiteSeries = new XYChart.Series<>();
        quantiteSeries.setName("Quantité");
        quantiteSeries.setData(quantiteData);

        // Création de l'histogramme
        BarChart<String, Number> barChart = new BarChart<>(xAxis, quantiteAxis);
        barChart.setTitle("Vente et quantité par munition");
        barChart.getData().addAll(venteSeries, quantiteSeries);

        // Montage de l'IU
        Scene scene = new Scene(barChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Fonction d'affichage d'un employee
     * @author Olivia et Baptiste
     * @version 3.0
     */
        public void Employeaffich(String prenom, String nom)
        {
            Pane pane = new Pane();
            Text txt8 = new Text("COORDONNEES ENREGISTREES :");
            txt8.setFont(new Font("Arial", 26));
            txt8.setStyle("-fx-fill: white;");
            txt8.setLayoutX(300);
            txt8.setLayoutY(200);

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);

            Text txt2 = new Text("Prénom : "+prenom);
            txt2.setFont(new Font("Arial", 26));
            txt2.setStyle("-fx-fill: white;");
            txt2.setLayoutX(300);
            txt2.setLayoutY(300);

            Text txt3 = new Text("Nom : "+nom);
            txt3.setFont(new Font("Arial", 26));
            txt3.setStyle("-fx-fill: white;");
            txt3.setLayoutX(300);
            txt3.setLayoutY(400);
            pane.getChildren().addAll(txt8,txt2,txt3,Bande,Bande1);
            Stage stage = new Stage();
            Scene scene = new Scene(pane,800,700);
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


        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);


        Text txt8 = new Text("Identifiant :");
        txt8.setFont(new Font("Arial", 26));
        txt8.setStyle("-fx-fill: white;");
        txt8.setLayoutX(90);
        txt8.setLayoutY(90);

        TextField txtfield = new TextField();
        txtfield.setLayoutX(90);
        txtfield.setLayoutY(200);


        Button re = new Button("Afficher un employee");
        re.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        re.setLayoutX(90);
        re.setLayoutY(300);

        Button de = new Button("Afficher tous les employees");
        de.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        de.setLayoutX(300);
        de.setLayoutY(300);

        pane.getChildren().addAll(txt8,re,de,txtfield,Bande,Bande1);

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

        Scene scene = new Scene(pane,800,700);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Fonction d'inscription d'un employee
     * @author Olivia et Baptiste
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


            Text txt = new Text("Prenom");
            txt.setFont(new Font("Arial", 26));
            txt.setStyle("-fx-fill: white;");
            txt.setLayoutX(300);
            txt.setLayoutY(290);

            TextField pr = new TextField();
            pr.setLayoutX(300);
            pr.setLayoutY(310);

            Text txxt = new Text("Nom");
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

                    boolean verification = true;

                    for(Employes e: emp)
                    {
                        System.out.println(e.getNom() + nom);
                        System.out.println(e.getPrenom() + prenom);

                       if(prenom.equals(e.getPrenom()) && nom.equals(e.getNom()))
                       {
                           verification = false;
                       }
                    }

                   Employes empl = new Employes(id, nom,prenom);


                    if(verification==true)
                    {
                        employeDAO.AjouterEmployes(empl);

                        Employeaffich(prenom, nom);
                    }
                    else
                    {

                        Text sup = new Text("Cet employe existe deja");
                        sup.setLayoutX(90);
                        sup.setLayoutY(300);
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
            Bande.setFitWidth(800);
            Bande.setFitHeight(150);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
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
            muni.setLayoutY(450);




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

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);


            Button ajt = new Button("Ajouter une arme");
            ajt.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            ajt.setLayoutX(300);
            ajt.setLayoutY(190);

            Button sup = new Button("Supprimer une arme");
            sup.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            sup.setLayoutX(300);
            sup.setLayoutY(290);

            Button aff = new Button("Afficher les armes");
            aff.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            aff.setLayoutX(300);
            aff.setLayoutY(390);

            Button re = new Button("Rechercher une armes");
            re.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            re.setLayoutX(300);
            re.setLayoutY(490);

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

            pane.getChildren().addAll(sup,ajt,aff,re,Bande,Bande1);


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
     * Fonction d'ajout d'arme dans le stock
     * @author Olivia
     * @version 3.0
     */
        public  void AjoutArme()
        {  Pane pane = new Pane();
            Stage stage = new Stage();

            Armes armes = new Armes();

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(90);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);


            /**identification de l'arme**/
            Text ident = new Text("Saisir le nom de l'ID:");
            ident.setFont(new Font("Arial", 20));
            ident.setStyle("-fx-fill: white;");
            ident.setLayoutX(100);
            ident.setLayoutY(130);

            TextField idTF = new TextField();
            idTF.setLayoutX(350);
            idTF.setLayoutY(110);

            /**categorie**/
            Text CAT = new Text("Saisir la categorie :  ");
            CAT.setFont(new Font("Arial", 20));
            CAT.setStyle("-fx-fill: white;");
            CAT.setLayoutX(100);
            CAT.setLayoutY(210);


            /**Catégorie Bou C**/
            Button b = new Button("B");
            b.setLayoutX(300);
            b.setLayoutY(190);

            Button c = new Button("C");
            c.setLayoutX(350);
            c.setLayoutY(190);



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
            tp.setFont(new Font("Arial", 20));
            tp.setStyle("-fx-fill: white;");
            tp.setLayoutX(100);
            tp.setLayoutY(270);


            /**Catégorie Bou C**/
            Button poing = new Button("Poing");
            poing.setLayoutX(300);
            poing.setLayoutY(250);

            Button assaut = new Button("Assaut");
            assaut.setLayoutX(400);
            assaut.setLayoutY(250);

            /**Catégorie Bou C**/
            Button chasse = new Button("Chasse");
            chasse.setLayoutX(500);
            chasse.setLayoutY(250);

            Button precision = new Button("Precision");
            precision.setLayoutX(600);
            precision.setLayoutY(250);


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
            pr.setFont(new Font("Arial", 20));
            pr.setStyle("-fx-fill: white;");
            pr.setLayoutX(100);
            pr.setLayoutY(320);

            TextField prix = new TextField();
            prix.setLayoutX(300);
            prix.setLayoutY(300);

            /**nom**/
            Text nm = new Text("Saisir le nom");
            nm.setFont(new Font("Arial", 20));
            nm.setStyle("-fx-fill: white;");
            nm.setLayoutX(100);
            nm.setLayoutY(370);

            TextField nom = new TextField();
            nom.setLayoutX(300);
            nom.setLayoutY(350);

            /**Calibre**/
            Text cl = new Text("Saisir le calibre");
            cl.setFont(new Font("Arial", 20));
            cl.setStyle("-fx-fill: white;");
            cl.setLayoutX(100);
            cl.setLayoutY(420);

            TextField cal = new TextField();
            cal.setLayoutX(300);
            cal.setLayoutY(400);

            /**Reduction**/
            Text red = new Text("Saisir si une réduction est appliquée :  ");
            red.setFont(new Font("Arial", 20));
            red.setStyle("-fx-fill: white;");
            red.setLayoutX(100);
            red.setLayoutY(470);


            Button oui = new Button("OUI");

            oui.setLayoutX(500);
            oui.setLayoutY(450);

            Button non = new Button("NON");

            non.setLayoutX(550);
            non.setLayoutY(450);

            oui.setOnAction(actionEvent -> {

                armes.setReduction(true);

            });

            non.setOnAction(actionEvent -> {

                armes.setReduction(false);

            });

            Text qt = new Text("Saisir la quantite");
            qt.setFont(new Font("Arial", 20));
            qt.setStyle("-fx-fill: white;");
            qt.setLayoutX(100);
            qt.setLayoutY(530);

            TextField quant = new TextField();
            quant.setLayoutX(300);
            quant.setLayoutY(510);

            /**valide les données**/
            Button ajt = new Button("Valider");
            ajt.setFont(new Font("Arial", 25));
            ajt.setStyle("-fx-fill: white;");
            ajt.setLayoutX(500);
            ajt.setLayoutY(550);


            // Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);
            ImpleArmesDAO armesDAO = new ImpleArmesDAO();


            pane.getChildren().addAll(oui,qt,quant,non,cal,idTF, b,c,prix,ajt,ident,CAT,tp,pr,nm,cl,red,nom,poing,chasse,assaut,precision,Bande1,Bande);


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

            Scene scene = new Scene(pane, 800, 700);

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

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);

            Text txt8 = new Text("Voici les armes :");
            txt8.setLayoutX(90);
            txt8.setLayoutY(120);

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



            pane.getChildren().addAll(txt8,Bande1,Bande);
            Scene scene = new Scene(pane,800,700);
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
        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);

        Text txt1 = new Text("Recherche d'une arme : ");
        txt1.setFont(new Font("Arial", 26));
        txt1.setStyle("-fx-fill: white;");
        txt1.setLayoutX(300);
        txt1.setLayoutY(200);


        ImpleArmesDAO armesDAO = new ImpleArmesDAO();

        /**categorie**/
        Text CAT = new Text("Saisir la categorie d'arme :");
        CAT.setFont(new Font("Arial", 26));
        CAT.setStyle("-fx-fill: white;");
        CAT.setLayoutX(300);
        CAT.setLayoutY(280);


        /**Catégorie Bou C**/
        Button b = new Button("B");
        b.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        b.setLayoutX(300);
        b.setLayoutY(320);

        Button c = new Button("C");
        c.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        c.setLayoutX(450);
        c.setLayoutY(320);

        b.setOnAction(actionEvent -> {

            armes.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            armes.setCategorie("C");

        });


        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        validation.setLayoutX(500);
        validation.setLayoutY(480);

        pane.getChildren().addAll(txt1,b,c,validation,CAT,Bande,Bande1);



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

        Scene scene = new Scene(pane,800,700);
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

            Armes armes=new Armes();

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(150);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);

            Text txt1 = new Text("SUPPRESSION D'UNE ARME");
            txt1.setFont(new Font("Arial", 26));
            txt1.setStyle("-fx-fill: white;");
            txt1.setLayoutX(300);
            txt1.setLayoutY(250);
            ImpleArmesDAO armesDAO = new ImpleArmesDAO();

            Text txt4 = new Text("Saisir l'identification:");
            txt4.setFont(new Font("Arial", 26));
            txt4.setStyle("-fx-fill: white;");
            txt4.setLayoutX(300);
            txt4.setLayoutY(300);

            TextField idTF = new TextField();
            idTF.setLayoutX(300);
            idTF.setLayoutY(400);

            Button validation = new Button("Validation");
            validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            validation.setLayoutX(300);
            validation.setLayoutY(500);

            pane.getChildren().addAll(txt1,txt4,idTF,validation,Bande,Bande1);

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

            Scene scene = new Scene(pane,800,700);

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

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);

            Button ajt = new Button("Ajouter une munition");
            ajt.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            ajt.setLayoutX(300);
            ajt.setLayoutY(190);

            Button sup = new Button("Supprimer une munition");
            sup.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            sup.setLayoutX(300);
            sup.setLayoutY(290);

            Button aff = new Button("Afficher les munitions");
            aff.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            aff.setLayoutX(300);
            aff.setLayoutY(390);

            Button re = new Button("Rechercher une munition");
            re.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

            re.setLayoutX(300);
            re.setLayoutY(490);

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


            pane.getChildren().addAll(sup,ajt,aff,re,Bande,Bande1);


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
     * Fonction de recherche de munitions
     * @author Olivia
     * @version 3.0
     */
    public void RechercherMunitions()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Munitions munitions=new Munitions();

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(130);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);

        Text txt1 = new Text("Recherche d'une munition : ");
        txt1.setFont(new Font("Arial", 26));
        txt1.setStyle("-fx-fill: white;");
        txt1.setLayoutX(300);
        txt1.setLayoutY(200);

        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        /**categorie**/
        Text CAT = new Text("Saisir la categorie :");
        CAT.setFont(new Font("Arial", 26));
        CAT.setStyle("-fx-fill: white;");
        CAT.setLayoutX(300);
        CAT.setLayoutY(250);


        /**Catégorie Bou C**/
        Button b = new Button("B");
        b.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        b.setLayoutX(300);
        b.setLayoutY(300);

        Button c = new Button("C");
        c.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        c.setLayoutX(450);
        c.setLayoutY(300);

        b.setOnAction(actionEvent -> {

            munitions.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            munitions.setCategorie("C");

        });

        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        validation.setLayoutX(500);
        validation.setLayoutY(480);

        pane.getChildren().addAll(txt1,b,c,CAT,validation,Bande,Bande1);

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

        Scene scene = new Scene(pane,800,700);
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

            Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
            ImageView Bande = new ImageView(bande);
            Bande.setFitWidth(800);
            Bande.setFitHeight(110);
            Bande.setLayoutX(0);
            Bande.setLayoutY(0);

            Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
            ImageView Bande1 = new ImageView(bande1);
            Bande1.setFitWidth(800);
            Bande1.setFitHeight(90);
            Bande1.setLayoutX(0);
            Bande1.setLayoutY(610);

            Text txt8 = new Text("Voici les munitions :");
            txt8.setLayoutX(300);
            txt8.setLayoutY(250);

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



            pane.getChildren().addAll(txt8,Bande,Bande1);
            Scene scene = new Scene(pane,800,700);
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


        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(800);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image bande1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande1 = new ImageView(bande1);
        Bande1.setFitWidth(800);
        Bande1.setFitHeight(90);
        Bande1.setLayoutX(0);
        Bande1.setLayoutY(610);

        Text ident = new Text("Saisir le nom de l'identification:");
        ident.setFont(new Font("Arial", 20));
        ident.setStyle("-fx-fill: white;");
        ident.setLayoutX(100);
        ident.setLayoutY(150);

        TextField idTF = new TextField();
        idTF.setLayoutX(450);
        idTF.setLayoutY(130);

        /**categorie**/
        Text CAT = new Text("Saisir la categorie : ");
        CAT.setFont(new Font("Arial", 20));
        CAT.setStyle("-fx-fill: white;");
        CAT.setLayoutX(100);
        CAT.setLayoutY(200);

        /**Catégorie B ou C**/
        Button b = new Button("B");
        b.setLayoutX(300);
        b.setLayoutY(180);

        Button c = new Button("C");
        c.setLayoutX(400);
        c.setLayoutY(180);

        b.setOnAction(actionEvent -> {

            muni.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            muni.setCategorie("C");

        });


        Text pr = new Text("Saisir le prix unique : ");
        pr.setFont(new Font("Arial", 20));
        pr.setStyle("-fx-fill: white;");
        pr.setLayoutX(100);
        pr.setLayoutY(250);

        TextField prix = new TextField();
        prix.setLayoutX(300);
        prix.setLayoutY(230);

        Text prvc = new Text("Saisir le prix en vrac : ");
        prvc.setFont(new Font("Arial", 20));
        prvc.setStyle("-fx-fill: white;");
        prvc.setLayoutX(100);
        prvc.setLayoutY(300);

        TextField prixvrac = new TextField();
        prixvrac.setLayoutX(300);
        prixvrac.setLayoutY(280);

        Text nm = new Text("Saisir le nom : ");
        nm.setFont(new Font("Arial", 20));
        nm.setStyle("-fx-fill: white;");
        nm.setLayoutX(100);
        nm.setLayoutY(350);

        TextField no = new TextField();
        no.setLayoutX(300);
        no.setLayoutY(330);


        Text cl = new Text("Saisir le calibre : ");
        cl.setFont(new Font("Arial", 20));
        cl.setStyle("-fx-fill: white;");
        cl.setLayoutX(100);
        cl.setLayoutY(400);

        TextField cal = new TextField();
        cal.setLayoutX(300);
        cal.setLayoutY(380);

        /**Reduction**/
        Text red = new Text("Saisir si une réduction est appliquée :  ");
        red.setFont(new Font("Arial", 20));
        red.setStyle("-fx-fill: white;");
        red.setLayoutX(100);
        red.setLayoutY(450);


        Button oui = new Button("OUI");
        oui.setLayoutX(450);
        oui.setLayoutY(430);

        Button non = new Button("NON");
        non.setLayoutX(550);
        non.setLayoutY(430);

        oui.setOnAction(actionEvent -> {

            muni.setReduction(true);

        });

        non.setOnAction(actionEvent -> {

            muni.setReduction(false);

        });

        Text qt = new Text("Saisir la quantite : ");
        qt.setFont(new Font("Arial", 20));
        qt.setStyle("-fx-fill: white;");
        qt.setLayoutX(100);
        qt.setLayoutY(500);

        TextField quant = new TextField();
        quant.setLayoutX(300);
        quant.setLayoutY(480);

        Button ajt = new Button("Valider");
        ajt.setFont(new Font("Arial", 20));
        ajt.setStyle("-fx-fill: white;");
        ajt.setLayoutX(500);
        ajt.setLayoutY(550);


        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        pane.getChildren().addAll(cal,idTF,prvc,prixvrac,prix,no,qt,quant,ajt,ident,CAT,pr,nm,cl,red,oui,non,b,c,Bande,Bande1);


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


        Scene scene = new Scene(pane, 800, 700);
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



