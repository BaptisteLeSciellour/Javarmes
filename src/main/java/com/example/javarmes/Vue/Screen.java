package com.example.javarmes.Vue;


import java.util.ArrayList;
import java.util.Random;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Utilisateurs.Client;

import  com.example.javarmes.Model.DAO.*;
import com.example.javarmes.Model.Utilisateurs.Employes;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class Screen {


    public void lancement()
    {
        Button inscription = new Button("Nouvelle inscription");
        Stage stage = new Stage();
        inscription.setLayoutX(500);
        inscription.setLayoutY(500);
        Button sortie = new Button("Exit");
        Button image = new Button("Image");
        sortie.setLayoutX(1500);
        inscription.setStyle("-fx-background-color: #3cb371; -fx-text-fill: white; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Pane pane = new Pane();

        pane.getChildren().addAll(inscription,sortie,image);
        inscription.setOnAction(event->{
            menuInscription();
        });

        sortie.setOnAction(actionEvent -> {
            Platform.exit();
        });
        image.setOnAction(ActionEvent->{
            Image();
        });

        stage.setTitle("Page d'acceuil");

        /** ne pas toucher à cela*/
        Scene scene = new Scene(pane, 520, 540);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void menuInscription()
    {
        Pane panne = new Pane();
        Stage settle = new Stage();
        Button client = new Button("client");
        Button employe = new Button("Employe");
        client.setLayoutX(60);
        client.setLayoutY(300);
        client.setOnAction(actionEvent -> {
            InscriptionClient();
            settle.close();
        });
        employe.setLayoutX(150);
        employe.setLayoutY(300);
        employe.setOnAction(actionEvent -> {
            InscriptionEmploye();
            settle.close();
        });
        panne.getChildren().addAll(client,employe);
        Scene sceene = new Scene(panne,320,540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
    public void Image()
    {
        Pane pane = new Pane();
        final String imageURL = new File("C:\\Users\\bapt8\\OneDrive\\Images\\yolooo.png").toURI().toString();
        Image img = new Image(imageURL);
        ImageView imG = new ImageView(img);
        imG.setOnMouseClicked(mouseEvent -> {
                    System.out.print("click"); /// ce qui rend l'image clickable
                }
        );
        pane.getChildren().add(imG);
        Scene sceene = new Scene(pane,1000,1000);
        Stage settle = new Stage();
        settle.setScene(sceene);
        settle.show();
    }

    public void InscriptionClient() /** Nous avons un second écran qui apparait**/
    {

        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("Voulez-vous ajouter un client:");
        txt.setLayoutX(90);
        txt.setLayoutY(290);

        /**creer deux boutons**/
        Button bbtn = new Button("OUI");
        bbtn.setLayoutX(140);
        bbtn.setLayoutY(400);

        Button bbtn2 = new Button("NON");
        bbtn2.setLayoutX(240);
        bbtn2.setLayoutY(400);


        bbtn.setOnAction(actionEvent -> {
            creationClient(); /** ici on appelle l'écran que nous allons utiliser**/
            settle.close();
        });
        pannne.getChildren().addAll(bbtn,bbtn2,txt);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }


    public void creationClient()
    {
        Stage stage = new Stage();
        Text txt1 = new Text("Création du client : ");
        ImpleClientDAO clientDAO = new ImpleClientDAO();
        Text txt4 = new Text("Saisir le mail:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);


        Text txt6 = new Text("Saisir le MDP:");
        txt6.setLayoutX(90);
        txt6.setLayoutY(340);

        TextField mdpTF = new TextField();
        mdpTF.setLayoutX(90); // ici on les décales
        mdpTF.setLayoutY(350); // ici on remonte les cases


        Button saisie = new Button("Saisie des données");

        /**!!!!!!!!!!!!!!!!!!**/

        saisie.setOnAction(event->{
            String mail = mailTF.getText();
            String mdp = mdpTF.getText();
            Pane pane = new Pane();
            Stage stage1 = new Stage();

            Button btn = new Button("Sortie");
            btn.setOnAction(actionEvent -> {
                stage1.close();
            });

            Client client = new Client(mail, mdp);
            try {

                /**ajouter dans la base de donnéé**/
                clientDAO.Ajouter(client);

                if (client != null) {

                    /**Affichage du client**/
                    Text txt8 = new Text("Client ajouté :");
                    txt8.setLayoutX(90);
                    txt8.setLayoutY(90);

                    Text txt2 = new Text("mail : "+mail);
                    txt2.setLayoutX(90);
                    txt2.setLayoutY(150);

                    Text txt3 = new Text("MDP : "+mdp);
                    txt3.setLayoutX(90);
                    txt3.setLayoutY(200);
                    pane.getChildren().addAll(txt8,txt2,txt3);

                } else {
                    Text pas = new Text("Le client n'a pas été créé\n");
                    pas.setLayoutX(90);
                    pas.setLayoutY(290);
                    pane.getChildren().add(pas);
                }
            } catch (SQLException e) {

                Text exception = new Text("Erreur"); /** il va falloir creer un écran d'erreur universel **/
                exception.setLayoutX(90);
                exception.setLayoutY(290);
                pane.getChildren().add(exception);

            }
            ArrayList<Client> vecclient = new ArrayList<Client>();
            vecclient.add(client);

            /**Affichage**/
            for (Client cli : vecclient) {
                cli.ToString();
                System.out.println("\n");
            }
            Scene scene = new Scene(pane,520,520);
            stage1.setScene(scene);
            stage1.show();
            stage.close(); /**ici nous fermons l'écran d'avant**/
        });

        Pane panne = new Pane();
        panne.getChildren().addAll(saisie,mailTF,mdpTF,txt1,txt4,txt6);
        Scene settle = new Scene(panne,520,520);

        stage.setScene(settle);
        stage.show();


    }
    public void InscriptionEmploye() /** Nous avons un second écran qui apparait**/
    {

        Pane panne = new Pane();
        Stage settle = new Stage();

        Text ttxxtt = new Text("Employe");
        ttxxtt.setLayoutX(90);
        ttxxtt.setLayoutY(30);
        Text txt = new Text("Prenom");
        txt.setLayoutX(90);
        txt.setLayoutY(290);
        TextField txtfield = new TextField();
        txtfield.setLayoutX(90);
        txtfield.setLayoutY(300);
        Text txxt = new Text("Nom de famille");
        txxt.setLayoutX(90);
        txxt.setLayoutY(340);
        TextField textField = new TextField();
        textField.setLayoutX(90); // ici on les décales
        textField.setLayoutY(350); // ici on remonte les cases
        Button bbtn = new Button("Prise");
        bbtn.setLayoutX(140);
        bbtn.setLayoutY(400);
        bbtn.setOnAction(event1->{
            String phrase = txtfield.getText();

            System.out.println(phrase);

            String SecondNom = textField.getText();

            System.out.print(SecondNom+"\n");

            Employes empl = new Employes();
            empl.setNom(SecondNom);
            empl.setPrenom(phrase);
            empl.ToString();
        });
        panne.getChildren().addAll(bbtn,txtfield,textField,txt,txxt,ttxxtt);

        Scene sceene = new Scene(panne,320,540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
}
