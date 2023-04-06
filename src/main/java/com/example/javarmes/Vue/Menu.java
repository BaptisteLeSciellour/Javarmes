package com.example.javarmes.Vue;


import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Menu {


    public void lancement()
    {
        Button inscription = new Button("Nouvelle inscription");
        Stage stage = new Stage();
        inscription.setLayoutX(500);
        inscription.setLayoutY(500);
        Button sortie = new Button("Exit");
        Button image = new Button("Image");
        Button anim  = new Button("Paiment");
        Button pres = new Button("Présentation");
        pres.setLayoutX(200);
        pres.setLayoutY(200);
        anim.setLayoutX(100);
        anim.setLayoutY(100);
        sortie.setLayoutX(1500);
        inscription.setStyle("-fx-background-color: #3cb371; -fx-text-fill: white; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Pane pane = new Pane();

        pane.getChildren().addAll(inscription,sortie,image,anim,pres);
        inscription.setOnAction(event->{
            menuInscription();
        });

        anim.setOnAction(actionEvent -> {
            Paiment paiment = new Paiment();
            Stage sttage = new Stage();
            paiment.anim(sttage);
        });

        sortie.setOnAction(actionEvent -> {
            Platform.exit();
        });
        image.setOnAction(ActionEvent->{
            Image();
        });
        pres.setOnAction(actionEvent -> {
            menupresentation();
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
            ScreenCLient scc = new ScreenCLient();
            scc.InscriptionClient();
            settle.close();
        });
        employe.setLayoutX(150);
        employe.setLayoutY(300);
        employe.setOnAction(actionEvent -> {
            ScreenEmploye sce = new ScreenEmploye();
            sce.InscriptionEmploye();
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

    public void menupresentation()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Image assaut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/assaut.png")));
        //Creating a rotated transition
        ImageView Assaut = new ImageView(assaut);

        Assaut.setLayoutX(0);
        Assaut.setLayoutY(0);

        Image precison = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/precision.jpg")));
        //Creating a rotated transition
        ImageView Precision = new ImageView(precison);

        Precision.setLayoutY(200);
        Precision.setLayoutX(0);

        Image chasse = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/chasse.jpg")));
        //Creating a rotated transition
        ImageView Chasse = new ImageView(chasse);

        Chasse.setLayoutX(200);
        Chasse.setLayoutY(0);

        Image poing = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/poing.png")));
        //Creating a rotated transition
        ImageView Poing = new ImageView(poing);

        Poing.setLayoutX(200);
        Poing.setLayoutY(200);

        pane.getChildren().addAll(Assaut,Chasse,Poing,Precision);

        Scene scene = new Scene(pane, 520, 540);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

}
