package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.DAO.ImpleArmesDAO;
import com.example.javarmes.Model.DAO.ImplePanierDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenArticle {

    /**
     * Classe pour le défilement d'objets dans une ArrayList d'articles. Elle est en différentes versions pour
     * l'achat et le panier. Deux versions pour ne pas avoir les mêmes possibilités sur cet écran.
     * Elle est récursive pour plus de simplicité et de scalabilité.
     * @author Maléna et Baptiste
     * @version 3.0
     */
    public void defilementC(AtomicInteger i, ArrayList<Article> armes, Client C){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Article arm;
        int size = armes.size();

        /** Système de controle pour qu'il ne soit pas possible de passer outre les tailles de vecteur**/
        i.compareAndSet(size,0);
        i.compareAndSet(-1,0);

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

        Button downButton = new Button();
        downButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/right.jpg")))));
        downButton.setLayoutX(400);
        downButton.setLayoutY(400);


        Button upButton = new Button();
        upButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/left.jpg")))));
        upButton.setLayoutX(0);
        upButton.setLayoutY(400);


        Button achat = new Button("Achat");
        achat.setLayoutX(100);
        achat.setLayoutY(200);
        arm=armes.get(i.intValue());
        Text txt = new Text(" Nom "+arm.getNom());
        txt.setStyle("-fx-background-color: black; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        txt.setLayoutX(100);
        txt.setLayoutY(290);
        achat.setOnAction(actionEvent ->{
            int quantite = arm.getQuantite();
            if(quantite>0)
            {
                Text panier = new Text("Produit dans le panier");
                panier.setLayoutX(100);
                panier.setLayoutY(340);
                C.addCommandes(arm);
                ImpleArmesDAO impp = new ImpleArmesDAO();
                ImplePanierDAO imp = new ImplePanierDAO();
                try {
                    impp.GererStockArme(arm.getIdentification(),-1);
                    imp.AjouterProduitPanier(arm.getIdentification(),1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                pane.getChildren().add(panier);
            }
        });
        downButton.setOnAction(actionEvent -> {
            i.getAndIncrement();
            defilementC(i,armes,C);
            stage.close();
        });
        upButton.setOnAction(actionEvent -> {
            i.getAndDecrement();
            defilementC(i,armes,C);
            stage.close();
        });

        pane.getChildren().addAll(downButton,upButton,txt,achat,Bande,Bande1);
        Scene scene = new Scene(pane,800,700);
        stage.setScene(scene);
        stage.show();
    }

    public void defilementP(AtomicInteger i, ArrayList<Article> armes, Client C){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Article arm;
        int size = armes.size();

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


        Button downButton = new Button();
        downButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/right.jpg")))));
        downButton.setLayoutX(400);
        downButton.setLayoutY(400);


        Button upButton = new Button();
        upButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/left.jpg")))));
        upButton.setLayoutX(0);
        upButton.setLayoutY(400);


        /// système de controle pour que il ne soit pas possible de passer outre les tailles de vecteur
        i.compareAndSet(size,0);
        i.compareAndSet(-1,0);
        Button retirer = new Button("Retirer");
        retirer.setLayoutX(300);
        retirer.setLayoutY(260);
        arm=armes.get(i.intValue());
        Text txt = new Text(" Nom "+arm.getNom());
        txt.setStyle("-fx-background-color: black; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        txt.setLayoutX(300);
        txt.setLayoutY(330);
        retirer.setOnAction(actionEvent ->{
            Text panier = new Text("Produit dans le panier");
            panier.setLayoutX(300);
            panier.setLayoutY(400);
            C.suppCommandes(arm);
            ImpleArmesDAO impp = new ImpleArmesDAO();
            ImplePanierDAO imp = new ImplePanierDAO();
            try {
                impp.GererStockArme(arm.getIdentification(),1);
                imp.SupprimerProduitPanier(arm.getIdentification());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            pane.getChildren().add(panier);
        });


        downButton.setOnAction(actionEvent -> {
            i.getAndIncrement();
            defilementC(i,armes,C);
            stage.close();
        });


        upButton.setOnAction(actionEvent -> {
            i.getAndDecrement();
            defilementC(i,armes,C);
            stage.close();
        });


        pane.getChildren().addAll(upButton,downButton,txt,retirer,Bande,Bande1);
        Scene scene = new Scene(pane,800,700);
        stage.setScene(scene);

        stage.show();
    }

    public static ImageView DonationImage(){

        StackPane root = new StackPane();
        Stage primarystage = new Stage();
        // Création d'un ImageView pour afficher l'image déposée par l'utilisateur
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        Text text = new Text("Zone de drag and drop pour l'image d'illustration \n ( JPG , png , gif exclusivement )");
        text.setLayoutX(90);
        text.setLayoutY(150);

        root.getChildren().addAll(imageView,text);

        // Définition du comportement de la zone de drop
        root.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != root && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        // Traitement du fichier déposé
        root.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                File file = db.getFiles().get(0);
                String fileName = file.getName().toLowerCase();
                if (fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".gif")) {
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    success = true;
                    primarystage.close();
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        Scene scene = new Scene(root, 400, 400);
        primarystage.setScene(scene);
        primarystage.show();
        return imageView;
    }
}

