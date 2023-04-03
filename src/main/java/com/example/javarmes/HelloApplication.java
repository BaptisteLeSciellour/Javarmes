package com.example.javarmes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {
        Button inscription = new Button("Nouvelle inscription");
        Button sortie = new Button("Exit");
        Button image = new Button("Image");
        sortie.setLayoutX(1500);
        inscription.setStyle("-fx-background-color: #3cb371; -fx-text-fill: white; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Pane pane = new Pane();

        pane.getChildren().addAll(inscription,sortie,image);

        inscription.setOnAction(event->{
            Inscription();
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

    public void Inscription() /** Nous avons un second écran qui apparait**/
    {
        Pane panne = new Pane();
        Stage settle = new Stage();


        Text txt = new Text("Prenom");
        txt.setLayoutX(150);
        txt.setLayoutY(290);
        TextField txtfield = new TextField();
        txtfield.setLayoutX(150);
        txtfield.setLayoutY(300);
        Text txxt = new Text("Nom de famille");
        txxt.setLayoutX(300);
        txxt.setLayoutY(290);
        TextField textField = new TextField();
        textField.setLayoutX(300);
        textField.setLayoutY(300);
        Button bbtn = new Button("Prise");
        bbtn.setLayoutX(50);
        bbtn.setLayoutY(300);
        bbtn.setOnAction(event1->{
            String phrase = txtfield.getText();
           /// personne.setFirstName(phrase);
            String SecondNom = textField.getText();
            ///personne.setLastName(SecondNom);
            settle.close();
        });
        panne.getChildren().addAll(bbtn,txtfield,textField,txt,txxt);

        Scene sceene = new Scene(panne,520,540);

        settle.setScene(sceene);
        settle.show();
    }

    public void Image()
    {
        Pane pane = new Pane();
        final String imageURL = new File("C:\\Users\\bapt8\\OneDrive\\Images\\yolooo.png").toURI().toString();
        Image img = new Image(imageURL);
        ImageView imG = new ImageView(img);
        pane.getChildren().add(imG);
        Scene sceene = new Scene(pane,1000,1000);
        Stage settle = new Stage();
        settle.setScene(sceene);
        settle.show();
    }

    public static void main(String[] args) {
        launch();
    }
}