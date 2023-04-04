package com.example.javarmes;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import com.example.javarmes.Vue.*;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {
        Screen screen = new Screen();
        screen.lancement();
    }

    public static void main(String[] args) {
        launch();
    }
}