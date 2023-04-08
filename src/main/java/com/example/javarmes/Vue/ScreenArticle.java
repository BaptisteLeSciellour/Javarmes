package com.example.javarmes.Vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class ScreenArticle {
    public void defilement(AtomicInteger i){
        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt = new Text(" hehe "+i);
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
            defilement(i);
            stage.close();
        });
        btn2.setOnAction(actionEvent -> {
            i.getAndDecrement();
            txt.setText("hehe"+i);
            defilement(i);
            stage.close();
        });
        pane.getChildren().addAll(btn,btn2,txt);
        Scene scene = new Scene(pane,520,520);
        stage.setScene(scene);
        stage.show();
    }
}
