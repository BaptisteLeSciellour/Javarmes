package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Armes;
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
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenArticle {
    public void defilement(AtomicInteger i, ArrayList<Armes> armes){
        Pane pane = new Pane();
        Stage stage = new Stage();
        Armes arm = new Armes();
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

    public static ImageView ImageChosse(){

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

