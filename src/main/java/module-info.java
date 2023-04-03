module com.example.javarmes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javarmes to javafx.fxml;
    exports com.example.javarmes;
}