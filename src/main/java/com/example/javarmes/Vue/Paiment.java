package com.example.javarmes.Vue;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        /**
        final String imageURL = new File("src\\main\\resources\\Images\\Bretagne.png").toURI().toString();
        Image img = new Image(imageURL);
        ImageView imG = new ImageView(img);
        **/

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/MontSaintMichel.jpg")));
        //Creating a rotated transition
        ImageView imG = new ImageView(image);

        RotateTransition rotateTransition = new RotateTransition();

        //Setting the duration for the transition
        rotateTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        rotateTransition.setNode(imG);

        //Setting the angle of the rotation
        rotateTransition.setByAngle(360);

        //Setting the cycle count for the transition
        rotateTransition.setCycleCount(2);

        //Setting auto reverse value to false
        rotateTransition.setAutoReverse(false);

        //Playing the animation
        rotateTransition.play();

        rotateTransition.setOnFinished(actionEvent -> {stage.close();});

        //Creating a Group object
        Group root = new Group(imG);

        //Creating a scene object
        Scene scene = new Scene(root, 1000, 1000);

        //Setting title to the Stage
        stage.setTitle("Rotate transition example ");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

}
