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
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenArticle {
    public void defilement(AtomicInteger i, ArrayList<Article> armes){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Article arm;
        int size = armes.size();

        /// système de controle pour que il ne soit pas possible de passer outre les tailles de vecteur
        i.compareAndSet(size,0);
        i.compareAndSet(-1,0);
            arm=armes.get(i.intValue());
        Text txt = new Text(" nom "+arm.getNom());
        txt.setLayoutX(90);
        txt.setLayoutY(290);
        Button btn = new Button("->");
        btn.setLayoutX(240);
        btn.setLayoutY(400);
        Button btn2 = new Button("<-");
        btn2.setLayoutX(140);
        btn2.setLayoutY(400);

        btn.setOnAction(actionEvent -> {
            i.getAndIncrement();
            txt.setText("hehe"+i);
            defilement(i,armes);
            stage.close();
        });
        btn2.setOnAction(actionEvent -> {
            i.getAndDecrement();
            txt.setText("hehe"+i);
            defilement(i,armes);
            stage.close();
        });

        pane.getChildren().addAll(btn,btn2,txt);
        Scene scene = new Scene(pane,520,520);
        stage.setScene(scene);
        stage.show();
    }

    public void defilementC(AtomicInteger i, ArrayList<Article> armes, Client C){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Article arm;
        int size = armes.size();

        /** Système de controle pour qu'il ne soit pas possible de passer outre les tailles de vecteur**/
        i.compareAndSet(size,0);
        i.compareAndSet(-1,0);

        Button achat = new Button("achat");
        achat.setLayoutX(0);
        achat.setLayoutY(0);
        arm=armes.get(i.intValue());
        Text txt = new Text(" nom "+arm.getNom());
        txt.setLayoutX(90);
        txt.setLayoutY(290);
        Button btn = new Button("->");
        btn.setLayoutX(240);
        btn.setLayoutY(400);
        Button btn2 = new Button("<-");
        btn2.setLayoutX(140);
        btn2.setLayoutY(400);
        achat.setOnAction(actionEvent ->{
            int quantite = arm.getQuantite();
            if(quantite>0)
            {
                Text panier = new Text("Produit dans le panier");
                panier.setLayoutX(100);
                panier.setLayoutY(100);
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
        btn.setOnAction(actionEvent -> {
            i.getAndIncrement();
            defilementC(i,armes,C);
            stage.close();
        });
        btn2.setOnAction(actionEvent -> {
            i.getAndDecrement();
            defilementC(i,armes,C);
            stage.close();
        });

        pane.getChildren().addAll(btn,btn2,txt,achat);
        Scene scene = new Scene(pane,520,520);
        stage.setScene(scene);
        stage.show();
    }

    public void defilementP(AtomicInteger i, ArrayList<Article> armes, Client C){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Article arm;
        int size = armes.size();

        /// système de controle pour que il ne soit pas possible de passer outre les tailles de vecteur
        i.compareAndSet(size,0);
        i.compareAndSet(-1,0);
        Button retirer = new Button("retirer");
        retirer.setLayoutX(260);
        retirer.setLayoutY(260);
        arm=armes.get(i.intValue());
        Text txt = new Text(" nom "+arm.getNom());
        txt.setLayoutX(90);
        txt.setLayoutY(290);
        Button btn = new Button("->");
        btn.setLayoutX(240);
        btn.setLayoutY(400);
        Button btn2 = new Button("<-");
        btn2.setLayoutX(140);
        btn2.setLayoutY(400);
        retirer.setOnAction(actionEvent ->{
            Text panier = new Text("Produit dans le panier");
            panier.setLayoutX(100);
            panier.setLayoutY(100);
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
        btn.setOnAction(actionEvent -> {
            i.getAndIncrement();
            defilementP(i,armes,C);
            stage.close();
        });
        btn2.setOnAction(actionEvent -> {
            i.getAndDecrement();
            defilementC(i,armes,C);
            stage.close();
        });

        pane.getChildren().addAll(btn,btn2,txt,retirer);
        Scene scene = new Scene(pane,520,520);
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

