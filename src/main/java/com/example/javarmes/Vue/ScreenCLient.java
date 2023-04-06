package com.example.javarmes.Vue;

import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;



public class ScreenCLient {
    public void creationClient()
    {
        Stage stage = new Stage();
        Text txt1 = new Text("Création du client : ");
        ImpleClientDAO clientDAO = new ImpleClientDAO();
        Text txt4 = new Text("Saisir le mail:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);


        Text txt6 = new Text("Saisir le MDP:");
        txt6.setLayoutX(90);
        txt6.setLayoutY(340);

        TextField mdpTF = new TextField();
        mdpTF.setLayoutX(90); // ici on les décales
        mdpTF.setLayoutY(350); // ici on remonte les cases


        Button saisie = new Button("Saisie des données");

        /**!!!!!!!!!!!!!!!!!!**/

        saisie.setOnAction(event->{
            String mail = mailTF.getText();
            String mdp = mdpTF.getText();
            Pane pane = new Pane();
            Stage stage1 = new Stage();

            Button btn = new Button("Sortie");
            btn.setOnAction(actionEvent -> {
                stage1.close();
            });

            Client client = new Client(mail, mdp);
            try {

                /**ajouter dans la base de donnéé**/
                clientDAO.Ajouter(client);

                if (client != null) {

                    /**Affichage du client**/
                    Text txt8 = new Text("Client ajouté :");
                    txt8.setLayoutX(90);
                    txt8.setLayoutY(90);

                    Text txt2 = new Text("mail : "+mail);
                    txt2.setLayoutX(90);
                    txt2.setLayoutY(150);

                    Text txt3 = new Text("MDP : "+mdp);
                    txt3.setLayoutX(90);
                    txt3.setLayoutY(200);
                    pane.getChildren().addAll(txt8,txt2,txt3);

                } else {
                    Text pas = new Text("Le client n'a pas été créé\n");
                    pas.setLayoutX(90);
                    pas.setLayoutY(290);
                    pane.getChildren().add(pas);
                }
            } catch (SQLException e) {

                Text exception = new Text("Erreur"); /** il va falloir creer un écran d'erreur universel **/
                exception.setLayoutX(90);
                exception.setLayoutY(290);
                pane.getChildren().add(exception);

            }
            ArrayList<Client> vecclient = new ArrayList<Client>();
            vecclient.add(client);

            /**Affichage**/
            for (Client cli : vecclient) {
                cli.ToString();
                System.out.println("\n");
            }
            Scene scene = new Scene(pane,520,520);
            stage1.setScene(scene);
            stage1.show();
            stage.close(); /**ici nous fermons l'écran d'avant**/
        });

        Pane panne = new Pane();
        panne.getChildren().addAll(saisie,mailTF,mdpTF,txt1,txt4,txt6);
        Scene settle = new Scene(panne,520,520);

        stage.setScene(settle);
        stage.show();


    }

    public void InscriptionClient() /** Nous avons un second écran qui apparait**/
    {

        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("Voulez-vous ajouter un client:");
        txt.setLayoutX(90);
        txt.setLayoutY(290);

        /**creer deux boutons**/
        Button bbtn = new Button("OUI");
        bbtn.setLayoutX(140);
        bbtn.setLayoutY(400);

        Button bbtn2 = new Button("NON");
        bbtn2.setLayoutX(240);
        bbtn2.setLayoutY(400);

        bbtn.setOnAction(actionEvent -> {
            creationClient(); /** ici on appelle l'écran que nous allons utiliser**/
            settle.close();
        });
        pannne.getChildren().addAll(bbtn,bbtn2,txt);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

}
