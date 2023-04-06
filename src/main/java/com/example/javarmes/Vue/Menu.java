package com.example.javarmes.Vue;


import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class Menu {


    public void lancement()
    {
        Button inscription = new Button("Nouvelle inscription");
        Stage stage = new Stage();
        inscription.setLayoutX(500);
        inscription.setLayoutY(500);
        Button sortie = new Button("Exit");
        Button image = new Button("Image");
        Button anim  = new Button("Anim");
        anim.setLayoutX(100);
        anim.setLayoutY(100);
        sortie.setLayoutX(1500);
        inscription.setStyle("-fx-background-color: #3cb371; -fx-text-fill: white; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Pane pane = new Pane();

        pane.getChildren().addAll(inscription,sortie,image,anim);
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

}
