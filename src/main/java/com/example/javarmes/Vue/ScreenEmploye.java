package com.example.javarmes.Vue;

import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScreenEmploye {

    public void Employeaffich(String prenom, String nom)
    {
        Pane pane = new Pane();
        Text txt8 = new Text("Employé ajouté :");
        txt8.setLayoutX(90);
        txt8.setLayoutY(90);

        Text txt2 = new Text("prenom : "+prenom);
        txt2.setLayoutX(90);
        txt2.setLayoutY(150);

        Text txt3 = new Text("nom : "+nom);
        txt3.setLayoutX(90);
        txt3.setLayoutY(200);
        pane.getChildren().addAll(txt8,txt2,txt3);
        Stage stage = new Stage();
        Scene scene = new Scene(pane,520,520);
        stage.setScene(scene);
        stage.show();
    }
    public void InscriptionEmploye() /** Nous avons un second écran qui apparait**/
    {
        Pane panne = new Pane();
        Stage settle = new Stage();

        Text ttxxtt = new Text("Employe");
        ttxxtt.setLayoutX(90);
        ttxxtt.setLayoutY(30);
        Text txt = new Text("Prenom");
        txt.setLayoutX(90);
        txt.setLayoutY(290);
        TextField txtfield = new TextField();
        txtfield.setLayoutX(90);
        txtfield.setLayoutY(300);
        Text txxt = new Text("Nom de famille");
        txxt.setLayoutX(90);
        txxt.setLayoutY(340);
        TextField textField = new TextField();
        textField.setLayoutX(90); // ici on les décales
        textField.setLayoutY(350); // ici on remonte les cases
        Button bbtn = new Button("Prise");
        bbtn.setLayoutX(140);
        bbtn.setLayoutY(400);
        bbtn.setOnAction(event1->{
            String phrase = txtfield.getText();

            System.out.println(phrase);

            String SecondNom = textField.getText();

            System.out.print(SecondNom+"\n");

            Employes empl = new Employes();
            empl.setNom(SecondNom);
            empl.setPrenom(phrase);
            empl.ToString();
            Employeaffich(phrase,SecondNom);
            settle.close();
        });
        panne.getChildren().addAll(bbtn,txtfield,textField,txt,txxt,ttxxtt);

        Scene sceene = new Scene(panne,320,540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
}
