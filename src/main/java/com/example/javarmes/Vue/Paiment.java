package com.example.javarmes.Vue;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.animation.RotateTransition;

import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.io.File;
import java.util.Objects;

public class Paiment {
    //Creating a hexagon
    public void anim(Stage stage)
    {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/chargement.png")));
        //Creating a rotated transition
        ImageView imG = new ImageView(image);

        imG.setLayoutX(300);
        imG.setLayoutY(300);

        RotateTransition rotateTransition = new RotateTransition();

        Text texte = new Text("Nous procédons au paiment");
        texte.setLayoutY(300);
        texte.setLayoutX(400);

        //Setting the duration for the transition
        rotateTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        rotateTransition.setNode(imG);

        //Setting the angle of the rotation
        rotateTransition.setByAngle(360);

        //Setting the cycle count for the transition
        rotateTransition.setCycleCount(3);

        //Setting auto reverse value to false
        rotateTransition.setAutoReverse(false);

        //Playing the animation
        rotateTransition.play();

        rotateTransition.setOnFinished(actionEvent -> {
            stage.close();
            Text txt = new Text("Transaction réussie mercie d'être passé par notre site");
            txt.setLayoutX(50);
            txt.setLayoutY(300);
            Pane pane = new Pane(txt);

            Stage sttage = new Stage();
            Scene sc = new Scene(pane,520,520);
            sttage.setScene(sc);
            sttage.show();
        });

        //Creating a Group object
        Group root = new Group(imG,texte);

        //Creating a scene object
        Scene scene = new Scene(root, 1000, 1000);

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

}
