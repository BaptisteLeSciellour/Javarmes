package com.example.javarmes.Vue;


import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.DAO.ImpleArmesDAO;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {


    public void lancement()
    {
        Button connection = new Button("Connexion");
        Stage stage = new Stage();

        connection.setLayoutX(700);
        connection.setLayoutY(600);
        Button sortie = new Button("Exit");
       /** Button image = new Button("Image");
        Button anim  = new Button("Paiment");
        Button pres = new Button("Armes disponibles");
**/
        Hyperlink hpy = new Hyperlink("Nouveau ?");
        hpy.setFont(new Font("Arial", 12));
        hpy.setStyle("-fx-fill: white;");
        hpy.setLayoutX(690);
        hpy.setLayoutY(700);

        Text menuu = new Text("M E N U");
        menuu.setFont(new Font("Arial", 36));
        menuu.setStyle("-fx-fill: white;");
        menuu.setLayoutX(700);
        menuu.setLayoutY(100);

        Text nomarque = new Text("J A V A R M E S");
        nomarque.setFont(new Font("Arial", 36));
        nomarque.setStyle("-fx-fill: white;");
        nomarque.setLayoutX(650);
        nomarque.setLayoutY(200);
        connection.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        sortie.setLayoutX(1500);
        /**
        pres.setLayoutX(700);
        pres.setLayoutY(400);
        anim.setLayoutX(700);
        anim.setLayoutY(300);

        image.setLayoutX(700);
        image.setLayoutY(500);
        image.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        anim.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        pres.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        **/
        Image armenu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu.png")));
        //Creating a rotated transition
        ImageView Armenu = new ImageView(armenu);
        Armenu.setFitWidth(500);
        Armenu.setFitHeight(400);
        Armenu.setLayoutX(100);
        Armenu.setLayoutY(50);


        Image armenu2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu2.png")));
        //Creating a rotated transition
        ImageView Armenu2 = new ImageView(armenu2);
        Armenu2.setFitWidth(500);
        Armenu2.setFitHeight(400);
        Armenu2.setLayoutX(900);
        Armenu2.setLayoutY(50);

        Pane ppane = new Pane();

        ppane.getChildren().addAll(connection,sortie,/**,image,anim,pres,**/menuu,Armenu,Armenu2,nomarque,hpy);
        connection.setOnAction(event->{
            connection();
        });

        sortie.setOnAction(actionEvent -> {
            Platform.exit();
        });

        hpy.setOnAction(actionEvent -> {
            menuinscription();
        });
        /**
        anim.setOnAction(actionEvent -> {

            coordonees();
        });


        image.setOnAction(ActionEvent->{
            Image();
        });
        pres.setOnAction(actionEvent -> {
            menupresentation();
        });
        **/
        stage.setTitle("Page d'acceuil");

        /** ne pas toucher à cela*/
        Scene scene = new Scene(ppane, 520, 540);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void menuinscription() /** va être utilsé pour l'inscription des nouvelles personnes**/
    {
        Pane panne = new Pane();
        Stage settle = new Stage();

        /** ici les deux vecteurs contenant tout les personnes du sites**/
        Employes empl = new Employes(123,"CC","CC");
        ArrayList<Employes> vecemployes = new ArrayList<Employes>();
        vecemployes.add(empl);

        Client clt = new Client(123,"CC","CC");
        ArrayList<Client>vecclient = new ArrayList<Client>();
        vecclient.add(clt);


        Text typee = new Text("TYPE D'UTILISATEUR");
        typee.setFont(new Font("Arial", 26));
        typee.setStyle("-fx-fill: white;");
        typee.setLayoutX(20);
        typee.setLayoutY(50);

        Button client = new Button("CLIENT");
        client.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Button employe = new Button("EMPLOYE");
        employe.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        client.setLayoutX(100);
        client.setLayoutY(150);
        client.setOnAction(actionEvent -> {
            ScreenCLient scc = new ScreenCLient();
            Text txxt = new Text();
            scc.creationClient(vecclient,txxt);
            settle.close();
        });
        employe.setLayoutX(100);
        employe.setLayoutY(300);
        employe.setOnAction(actionEvent -> {
            ScreenEmploye sce = new ScreenEmploye();
            sce.InscriptionEmploye(vecemployes);
            settle.close();
        });
        panne.getChildren().addAll(client,employe,typee);
        Scene sceene = new Scene(panne,320,540);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
    public void Image()
    {
        Pane pane = new Pane();
        final String imageURL = new File("C:\\Users\\bapt8\\OneDrive\\Images\\yolooo.png").toURI().toString();
        Image img = new Image(imageURL);
        ImageView imG = new ImageView(img);
        imG.setOnMouseClicked(mouseEvent -> {
                    System.out.print("click"); /// ce qui rend l'image clickable
                }
        );
        pane.getChildren().add(imG);
        Scene sceene = new Scene(pane,1000,1000);
        Stage settle = new Stage();
        settle.setScene(sceene);
        settle.show();
    }

    public void menupresentation()
    {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Image assaut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/assaut.png")));
        //Creating a rotated transition
        ImageView Assaut = new ImageView(assaut);
        Assaut.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger();
                    ArrayList<Armes> dassaut = new ArrayList<Armes>();
            try {
                ImpleArmesDAO ae = new ImpleArmesDAO();
                dassaut= (ArrayList<Armes>) ae.RechercherArmes("Assaut"," ");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            scc.defilement(i);/// ce qui rend l'image clickable
            }
        );
        Assaut.setLayoutX(100);
        Assaut.setLayoutY(300);
        Text ass = new Text("Arme d'Assaut");
        ass.setFont(new Font("Arial", 36));
        ass.setStyle("-fx-fill: white;");
        ass.setLayoutX(100);
        ass.setLayoutY(600);

        Image precison = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/precision.jpg")));
        //Creating a rotated transition
        ImageView Precision = new ImageView(precison);
        Precision.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    ImageView imgv = new ImageView();
                    imgv=scc.ImageChosse();
                    imgv.setLayoutX(500);
                    imgv.setLayoutY(100);
                    pane.getChildren().add(imgv);

                }
        );

        Precision.setLayoutY(300);
        Precision.setLayoutX(400);
        Text pre = new Text("Arme de Precision");
        pre.setFont(new Font("Arial", 36));
        pre.setStyle("-fx-fill: white;");
        pre.setLayoutX(400);
        pre.setLayoutY(600);


        Text typee = new Text("TYPES D'ARMES DISPONIBLES");
        typee.setFont(new Font("Arial", 26));
        typee.setStyle("-fx-fill: white;");
        typee.setLayoutX(600);
        typee.setLayoutY(200);

        Image chasse = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/chasse.jpg")));
        //Creating a rotated transition
        ImageView Chasse = new ImageView(chasse);
        Chasse.setLayoutX(800);
        Chasse.setLayoutY(300);
        Text cha = new Text("Arme de Chasse");
        cha.setFont(new Font("Arial", 36));
        cha.setStyle("-fx-fill: white;");
        cha.setLayoutX(800);
        cha.setLayoutY(600);

        Image poing = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/poing.png")));
        //Creating a rotated transition
        ImageView Poing = new ImageView(poing);
        Poing.setLayoutX(1100);
        Poing.setLayoutY(300);
        Text po = new Text("Arme de Poing");
        po.setFont(new Font("Arial", 36));
        po.setStyle("-fx-fill: white;");
        po.setLayoutX(1100);
        po.setLayoutY(600);


        pane.getChildren().addAll(Assaut,Chasse,Poing,Precision,typee,ass,pre,po,cha);

        Scene scene = new Scene(pane, 520, 540);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void coordonees() {  //sous programme permettannt de remplir les coordonnes bancaires

        Pane panne = new Pane();
        Stage stage = new Stage();

        Text coor = new Text("SAISIE DES COORDONNES BANCAIRES ");
        coor.setFont(new Font("Arial", 16));
        coor.setStyle("-fx-fill: white;");

        Text txt1 = new Text("NUMERO DE CARTE DE CREDIT: ");
        txt1.setFont(new Font("Arial", 16));
        txt1.setStyle("-fx-fill: white;");

        Text txt4 = new Text("DATE DE PEREMPTION:");
        txt4.setFont(new Font("Arial", 16));
        txt4.setStyle("-fx-fill: white;");

        Text trois = new Text("CODE AU VERSO:");
        trois.setFont(new Font("Arial", 16));
        trois.setStyle("-fx-fill: white;");

        coor.setLayoutX(140);
        coor.setLayoutY(50);
        txt1.setLayoutX(90);
        txt1.setLayoutY(100);
        txt4.setLayoutX(90);
        txt4.setLayoutY(200);
        trois.setLayoutX(90);
        trois.setLayoutY(300);

        TextField coord = new TextField();
        coord.setLayoutX(90);
        coord.setLayoutY(120);

        TextField date = new TextField();
        date.setLayoutX(90);
        date.setLayoutY(220);

        TextField code = new TextField();
        code.setLayoutX(90);
        code.setLayoutY(320);

        Button valider = new Button("Valider");
        valider.setLayoutX(200);
        valider.setLayoutY(400);
        valider.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 10px; -fx-background-radius: 10px;");

        panne.getChildren().addAll(valider, code, txt1, txt4, coor, date, coord,trois);
        Scene settle = new Scene(panne, 520, 520);

        settle.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond

        stage.setScene(settle);
        stage.show();

          //si on clique sur valider
        valider.setOnAction(actionEvent -> {
            Paiment paiment = new Paiment();
            Stage sttage = new Stage();
            paiment.anim(sttage);
            // changer de page ici on envoit à l'animation puis succès du paiement
        });

    }

    public void triId(int id) throws SQLException {
        ArrayList<Employes> emp;
        ArrayList<Client>cli;
        ImpleEmployeDAO empp = new ImpleEmployeDAO();
        emp = (ArrayList<Employes>)empp.ChoisirEmploye();
        cli = (ArrayList<Client>) empp.ChoisirClient();
        for (Employes emppp : emp) {

            if (Objects.equals(id, emppp.getId())) {
                Image(); /** à bien sur changer**/
            }
        }
        for (Client clii : cli) {

            if (Objects.equals(id, clii.getId())) {
                Paiment pm = new Paiment();
                Stage stage = new Stage();
                pm.anim(stage); /** bien sur à changer**/
            }
        }
        ScreenArticle scc= new ScreenArticle();
        AtomicInteger i = new AtomicInteger();
        scc.defilement(i);
    }

    public void connection(){
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("Connection");
        txt.setLayoutX(90);
        txt.setLayoutY(150);

        Text txt4 = new Text("Saisir l'id:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField idTF = new TextField();
        idTF.setLayoutX(90);
        idTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        validation.setOnAction(actionEvent -> {
           int id = Integer.valueOf(idTF.getText());
            try {
                triId(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        pannne.getChildren().addAll(txt,validation,txt4,idTF);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
}


