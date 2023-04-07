package com.example.javarmes.Vue;


import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Menu {


    public void lancement()
    {
        Button inscription = new Button("Nouvelle inscription");
        Stage stage = new Stage();

        inscription.setLayoutX(700);
        inscription.setLayoutY(600);
        Button sortie = new Button("Exit");
        Button image = new Button("Image");
        Button anim  = new Button("Paiment");
        Button pres = new Button("Présentation");

        Text menuu = new Text("M E N U");
        menuu.setFont(new Font("Arial", 36));
        menuu.setStyle("-fx-fill: white;");
        menuu.setLayoutX(700);
        menuu.setLayoutY(100);

        Text nomarque = new Text("J A V A R M E S");
        nomarque.setFont(new Font("Arial", 36));
        nomarque.setStyle("-fx-fill: white;");
        nomarque.setLayoutX(650);
        nomarque.setLayoutY(200);

        pres.setLayoutX(700);
        pres.setLayoutY(400);
        anim.setLayoutX(700);
        anim.setLayoutY(300);
        sortie.setLayoutX(1500);
        image.setLayoutX(700);
        image.setLayoutY(500);
        inscription.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        image.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        anim.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        pres.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        Image armenu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu.png")));
        //Creating a rotated transition
        ImageView Armenu = new ImageView(armenu);
        Armenu.setFitWidth(500);
        Armenu.setFitHeight(400);
        Armenu.setLayoutX(100);
        Armenu.setLayoutY(50);


        Image armenu2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu2.png")));
        //Creating a rotated transition
        ImageView Armenu2 = new ImageView(armenu2);
        Armenu2.setFitWidth(500);
        Armenu2.setFitHeight(400);
        Armenu2.setLayoutX(900);
        Armenu2.setLayoutY(50);

        Pane ppane = new Pane();

        ppane.getChildren().addAll(inscription,sortie,image,anim,pres,menuu,Armenu,Armenu2,nomarque);
        inscription.setOnAction(event->{
            menuInscription();
        });

        anim.setOnAction(actionEvent -> {

            coordonees();
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
        Scene scene = new Scene(ppane, 520, 540);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void menuInscription()
    {
        Pane panne = new Pane();
        Stage settle = new Stage();
        /** ici les deux vecteurs contenant tout les personnes du sites**/
        Employes empl = new Employes(123,"CC","CC");
        ArrayList<Employes> vecemployes = new ArrayList<Employes>();
        vecemployes.add(empl);

        Client clt = new Client("CC","CC");
        ArrayList<Client>vecclient = new ArrayList<Client>();
        vecclient.add(clt);

        Button client = new Button("client");
        Button employe = new Button("Employe");
        client.setLayoutX(60);
        client.setLayoutY(300);
        client.setOnAction(actionEvent -> {
            ScreenCLient scc = new ScreenCLient();
            Text txxt = new Text();
            scc.InscriptionClient(txxt,vecclient);
            settle.close();
        });
        employe.setLayoutX(150);
        employe.setLayoutY(300);
        employe.setOnAction(actionEvent -> {
            ScreenEmploye sce = new ScreenEmploye();
            sce.MenuEmploye(vecemployes);
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




    public void coordonees() {  //sous programme permettannt de remplir les coordonnes bancaires

        Pane panne = new Pane();
        Stage stage = new Stage();

        Text coor = new Text("SAISIE DES COORDONNES BANCAIRES");
        coor.setFont(new Font("Arial", 16));
        coor.setStyle("-fx-fill: white;");

        Text txt1 = new Text("NUMERO DE CARTE DE CREDIT: ");
        txt1.setFont(new Font("Arial", 16));
        txt1.setStyle("-fx-fill: white;");

        Text txt4 = new Text("DATE DE PEREMPTION:");
        txt4.setFont(new Font("Arial", 16));
        txt4.setStyle("-fx-fill: white;");

        Text trois = new Text("CODE AU VERSO:");
        trois.setFont(new Font("Arial", 16));
        trois.setStyle("-fx-fill: white;");

        coor.setLayoutX(140);
        coor.setLayoutY(50);
        txt1.setLayoutX(90);
        txt1.setLayoutY(100);
        txt4.setLayoutX(90);
        txt4.setLayoutY(200);
        trois.setLayoutX(90);
        trois.setLayoutY(300);

        TextField coord = new TextField();
        coord.setLayoutX(90);
        coord.setLayoutY(120);

        TextField date = new TextField();
        date.setLayoutX(90);
        date.setLayoutY(220);

        TextField code = new TextField();
        code.setLayoutX(90);
        code.setLayoutY(320);

        Button valider = new Button("Valider");
        valider.setLayoutX(200);
        valider.setLayoutY(400);
        valider.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 10px; -fx-background-radius: 10px;");

        panne.getChildren().addAll(valider, code, txt1, txt4, coor, date, coord,trois);
        Scene settle = new Scene(panne, 520, 520);

        settle.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond

        stage.setScene(settle);
        stage.show();

          //si on clique sur valider
        valider.setOnAction(actionEvent -> {
            Paiment paiment = new Paiment();
            Stage sttage = new Stage();
            paiment.anim(sttage);
            // changer de page ici on envoit à l'animation puis succès du paiement
        });




    }}