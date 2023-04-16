package com.example.javarmes.Vue;


import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Articles.Munitions;
import com.example.javarmes.Model.DAO.ImpleArmesDAO;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    public void lancement() {
        Button connection = new Button("Connexion");
        Stage stage = new Stage();

        connection.setLayoutX(700);
        connection.setLayoutY(440);
        Button sortie = new Button("Exit");
        /** Button image = new Button("Image");
         Button anim  = new Button("Paiment");
         **/
        Button pres = new Button("Parcourir le site");

       /* Hyperlink hpy = new Hyperlink("Nouveau ?");
        hpy.setFont(new Font("Arial", 12));
        hpy.setStyle("-fx-fill: white;");
        hpy.setLayoutX(690);
        hpy.setLayoutY(700);*/


        Button hpy = new Button("Créer un compte");
        hpy.setLayoutX(700);
        hpy.setLayoutY(520);
        hpy.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

        Button contact = new Button("Nous contacter");
        contact.setLayoutX(700);
        contact.setLayoutY(600);
        contact.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");


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

        pres.setLayoutX(700);
        pres.setLayoutY(360);

        pres.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Image armenu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu.png")));

        ImageView Armenu = new ImageView(armenu);
        Armenu.setFitWidth(500);
        Armenu.setFitHeight(400);
        Armenu.setLayoutX(1);
        Armenu.setLayoutY(50);

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(1600);
        Bande.setFitHeight(200);
        Bande.setLayoutX(1);
        Bande.setLayoutY(700);

        Button test = new Button("test");
        test.setLayoutX(200);
        test.setLayoutY(300);

        test.setOnAction(actionEvent -> {
            ScreenEmploye sc = new ScreenEmploye();
            Stage staaage = new Stage();
            ImpleEmployeDAO impl = new ImpleEmployeDAO();
            List<Client> arr ;
            try {
                arr=impl.ChoisirClient();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            sc.camembertsamere(staaage,arr);
        });

        Image armenu2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/armemenu2.png")));
        //Creating a rotated transition
        ImageView Armenu2 = new ImageView(armenu2);
        Armenu2.setFitWidth(500);
        Armenu2.setFitHeight(400);
        Armenu2.setLayoutX(1050);
        Armenu2.setLayoutY(50);

        Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/logo.png")));
        //Creating a rotated transition
        ImageView Logo = new ImageView(logo);
        Logo.setFitWidth(600);
        Logo.setFitHeight(300);
        Logo.setLayoutX(500);
        Logo.setLayoutY(50);

        Pane ppane = new Pane();

        ppane.getChildren().addAll(connection, sortie,/**,image,anim,**/pres, menuu, Armenu, Armenu2, nomarque, hpy,Logo,test,contact,Bande);
        connection.setOnAction(event -> {
            menuconnexion();
        });

        sortie.setOnAction(actionEvent -> {
            Platform.exit();
        });

        contact.setOnAction(actionEvent -> {
            contact();
        });

        hpy.setOnAction(actionEvent -> {
            menuinscription();
        });

        pres.setOnAction(actionEvent -> {
            menupresentation();
        });
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
        Employes empl = new Employes(123, "CC", "CC");
        ArrayList<Employes> vecemployes = new ArrayList<Employes>();
        vecemployes.add(empl);

        Client clt = new Client(123, "CC", "CC");
        ArrayList<Client> vecclient = new ArrayList<Client>();
        vecclient.add(clt);

        /** Armes **/
        //String identification,String type, String categorie, String nom, double prix_unique, int quantite, double calibre, boolean reduction, int nb_vente
        Armes armes = new Armes("ID456","Precision","B","Bambi",3.14,5,9,false,5);
        ArrayList<Armes> vecarmes = new ArrayList<Armes>();
        vecarmes.add(armes);

        /** Munitions **/
        //String identification, String categorie, String nom, double prix_unique,int quantite, double calibre,boolean reduction, double prix_vrac, int nb_vente
        Munitions munitions = new Munitions("ID333","B","BOUM",45,7,8,false,30,6);
        ArrayList<Munitions> vecmunitions = new ArrayList<Munitions>();
        vecmunitions.add(munitions);


       /* Text typee = new Text("TYPE D'UTILISATEUR");
        typee.setFont(new Font("Arial", 26));
        typee.setStyle("-fx-fill: white;");
        typee.setLayoutX(20);
        typee.setLayoutY(50);*/

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/typ2.jpg")));
        //Creating a rotated transition
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(0);
        Loog.setLayoutX(0);
        Loog.setFitWidth(800);
        Loog.setFitHeight(230);

        Image loogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        //Creating a rotated transition
        ImageView Loogo = new ImageView(loogo);
        Loogo.setLayoutY(550);
        Loogo.setLayoutX(0);
        Loogo.setFitWidth(800);
        Loogo.setFitHeight(150);

        Button client = new Button("CLIENT");
        client.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Button employe = new Button("EMPLOYE");
        employe.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        client.setLayoutX(300);
        client.setLayoutY(440);
        client.setOnAction(actionEvent -> {
            ScreenCLient scc = new ScreenCLient();
            Text txxt = new Text();
            scc.creationClient(vecclient, txxt);
            settle.close();
        });
        employe.setLayoutX(300);
        employe.setLayoutY(360);
        employe.setOnAction(actionEvent -> {
            ScreenEmploye sce = new ScreenEmploye();
            sce.InscriptionEmploye();
            settle.close();
        });
        panne.getChildren().addAll(client, employe, Loog,Loogo);
        Scene sceene = new Scene(panne, 800, 700);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    public void menuconnexion() /** va être utilsé pour l'inscription des nouvelles personnes**/
    {
        Pane panne = new Pane();
        Stage settle = new Stage();

        /** ici les deux vecteurs contenant tout les personnes du sites**/
        Employes empl = new Employes(123, "CC", "CC");
        ArrayList<Employes> vecemployes = new ArrayList<Employes>();
        vecemployes.add(empl);

        Client clt = new Client(123, "CC", "CC");
        ArrayList<Client> vecclient = new ArrayList<Client>();
        vecclient.add(clt);


     /*   Text typee = new Text("TYPE D'UTILISATEUR");
        typee.setFont(new Font("Arial", 26));
        typee.setStyle("-fx-fill: white;");
        typee.setLayoutX(20);
        typee.setLayoutY(50);*/

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/typ2.jpg")));
        //Creating a rotated transition
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(0);
        Loog.setLayoutX(0);
        Loog.setFitWidth(800);
        Loog.setFitHeight(200);

        Image loogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        //Creating a rotated transition
        ImageView Loogo = new ImageView(loogo);
        Loogo.setLayoutY(550);
        Loogo.setLayoutX(0);
        Loogo.setFitWidth(800);
        Loogo.setFitHeight(150);

        Button client = new Button("CLIENT");
        client.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        Button employe = new Button("EMPLOYE");
        employe.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        client.setLayoutX(300);
        client.setLayoutY(440);
        client.setOnAction(actionEvent -> {
            try {
                connectionClient(settle);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        employe.setLayoutX(300);
        employe.setLayoutY(360);
        employe.setOnAction(actionEvent -> {
            try {
                connectionEmploye(settle);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        panne.getChildren().addAll(client, employe, Loog,Loogo);
        Scene sceene = new Scene(panne, 800, 700);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
    public void Image() {
        Pane pane = new Pane();
        final String imageURL = new File("C:\\Users\\bapt8\\OneDrive\\Images\\yolooo.png").toURI().toString();
        Image img = new Image(imageURL);
        ImageView imG = new ImageView(img);
        imG.setOnMouseClicked(mouseEvent -> {
                    System.out.print("click"); /// ce qui rend l'image clickable
                }
        );
        pane.getChildren().add(imG);
        Scene sceene = new Scene(pane, 1000, 1000);
        Stage settle = new Stage();
        settle.setScene(sceene);
        settle.show();
    }

    public void menupresentation() {
        Pane pane = new Pane();
        Stage stage = new Stage();
        Button connection = new Button("Connection");



        Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/dispo.jpg")));
        //Creating a rotated transition
        ImageView Logo = new ImageView(logo);
        Logo.setFitWidth(1550);
        Logo.setFitHeight(300);
        Logo.setLayoutX(0);
        Logo.setLayoutY(0);

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(1600);
        Bande.setFitHeight(200);
        Bande.setLayoutX(1);
        Bande.setLayoutY(700);

        Image assaut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/assaut.png")));
        //Creating a rotated transition
        ImageView Assaut = new ImageView(assaut);
        Assaut.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> dassaut;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        dassaut = (ArrayList<Article>) ae.RechercherArmes("type", "assaut");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    if(dassaut==null)
                    {
                        Image();
                    }
                    else {
                        scc.defilement(i, dassaut);
                        }

                }
        );
        Assaut.setLayoutX(100);
        Assaut.setLayoutY(300);
        Text ass = new Text("Arme d'Assaut");
        ass.setFont(new Font("Arial", 36));
        ass.setStyle("-fx-fill: white;");
        ass.setLayoutX(100);
        ass.setLayoutY(600);

        connection.setOnAction(actionEvent -> {
            try {
                connectionClient(stage);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        Image precison = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/precision.jpg")));
        //Creating a rotated transition
        ImageView Precision = new ImageView(precison);
        Precision.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> precisionn;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        precisionn = (ArrayList<Article>) ae.RechercherArmes("type", "precision");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilement(i, precisionn);
                }
        );

        Precision.setFitWidth(350);
        Precision.setFitHeight(200);
        Precision.setLayoutY(350);
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
        Chasse.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> chasses;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        chasses = (ArrayList<Article>) ae.RechercherArmes("type", "chasse");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilement(i, chasses);
                }
        );
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
        Poing.setOnMouseClicked(mouseEvent -> {
                  /*  ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> poingg;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        poingg = (ArrayList<Article>) ae.RechercherArmes("type", "poing");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilement(i, poingg);*/
            poing();
                }
        );
        Poing.setLayoutX(1100);
        Poing.setLayoutY(300);
        Text po = new Text("Arme de Poing");
        po.setFont(new Font("Arial", 36));
        po.setStyle("-fx-fill: white;");
        po.setLayoutX(1100);
        po.setLayoutY(600);


        pane.getChildren().addAll(Assaut, Chasse, Poing, Precision, typee, ass, pre, po, cha, Logo,connection,Bande);

        Scene scene = new Scene(pane, 520, 540);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }




    public void poing() {
        Pane panne = new Pane();
        Stage staage = new Stage();

        Image bande = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Bande = new ImageView(bande);
        Bande.setFitWidth(710);
        Bande.setFitHeight(110);
        Bande.setLayoutX(0);
        Bande.setLayoutY(0);

        Image poing1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/poing1.jpg")));
        ImageView Poing1 = new ImageView(poing1);
        Poing1.setFitWidth(450);
        Poing1.setFitHeight(500);
        Poing1.setLayoutX(50);
        Poing1.setLayoutY(200);

        Image poing2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/poing2.jpg")));
        ImageView Poing2 = new ImageView(poing2);
        Poing2.setFitWidth(450);
        Poing2.setFitHeight(500);
        Poing2.setLayoutX(50);
        Poing2.setLayoutY(800);


       Button downButton = new Button();
        downButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/up_arrow.png")))));
        downButton.setLayoutX(710);
        downButton.setLayoutY(0);
        downButton.setOnAction(event -> {
            Poing1.setLayoutY(Poing1.getLayoutY() + 100);
            Poing2.setLayoutY(Poing2.getLayoutY() + 100);

        });

        Button upButton = new Button();
        upButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/do.png")))));
        upButton.setLayoutX(710);
        upButton.setLayoutY(600);
        upButton.setOnAction(event -> {
            Poing1.setLayoutY(Poing1.getLayoutY() - 100);
            Poing2.setLayoutY(Poing2.getLayoutY() - 100);
        });

        panne.getChildren().addAll(Poing1, Poing2,downButton,upButton,Bande);
        Scene settle = new Scene(panne, 800, 700);

        settle.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond

        staage.setScene(settle);
        staage.show();

    }






    public void menupresentationC(Client C) {
        Pane pane = new Pane();
        Stage staage = new Stage();
        Button detail = new Button("Detail");
        Image assaut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/assaut.png")));
        //Creating a rotated transition
        ImageView Assaut = new ImageView(assaut);
        Assaut.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> dassaut;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        dassaut = (ArrayList<Article>) ae.RechercherArmes("type", "assaut");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilementC(i, dassaut,C);
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
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> precisionn;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        precisionn = (ArrayList<Article>) ae.RechercherArmes("type", "precision");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilementC(i, precisionn,C);
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
        Chasse.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> chasses;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        chasses = (ArrayList<Article>) ae.RechercherArmes("type", "chasse");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilementC(i, chasses,C);
                }
        );
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
        Poing.setOnMouseClicked(mouseEvent -> {
                    ScreenArticle scc = new ScreenArticle();
                    AtomicInteger i = new AtomicInteger(0);
                    ArrayList<Article> poingg;
                    try {
                        ImpleArmesDAO ae = new ImpleArmesDAO();
                        poingg = (ArrayList<Article>) ae.RechercherArmes("type", "poing");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    scc.defilementC(i, poingg,C);
                }
        );
        Poing.setLayoutX(1100);
        Poing.setLayoutY(300);
        Text po = new Text("Arme de Poing");
        po.setFont(new Font("Arial", 36));
        po.setStyle("-fx-fill: white;");
        po.setLayoutX(1100);
        po.setLayoutY(600);

        detail.setOnAction(actionEvent -> {
            ScreenCLient sc = new ScreenCLient();
            sc.DetailClient(C);
        });

        pane.getChildren().addAll(Assaut, Chasse, Poing, Precision, typee, ass, pre, po, cha, detail);

        Scene scene = new Scene(pane, 520, 540);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        staage.setScene(scene);
        staage.setMaximized(true);
        staage.show();
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

        panne.getChildren().addAll(valider, code, txt1, txt4, coor, date, coord, trois);
        Scene settle = new Scene(panne, 800, 700);

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

    public void connectionClient(Stage stage) throws SQLException {
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/connexion.jpg")));
        //Creating a rotated transition
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(0);
        Loog.setLayoutX(0);
        Loog.setFitWidth(800);
        Loog.setFitHeight(200);

        Text txt4 = new Text("Saisir le mail:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
        txt4.setLayoutX(300);
        txt4.setLayoutY(260);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(300);
        mailTF.setLayoutY(280);

        Text idT = new Text("Saisir le ID:");
        idT.setFont(new Font("Arial", 26));
        idT.setStyle("-fx-fill: white;");
        idT.setLayoutX(300);
        idT.setLayoutY(350);

        TextField idTF = new TextField();
        idTF.setLayoutX(300);
        idTF.setLayoutY(370);

        Text mdpT = new Text("Saisir le motdepasse:");
        mdpT.setFont(new Font("Arial", 26));
        mdpT.setStyle("-fx-fill: white;");
        mdpT.setLayoutX(300);
        mdpT.setLayoutY(450);

        final PasswordField mdpTF = new PasswordField();
        mdpTF.setLayoutX(300);
        mdpTF.setLayoutY(470);

        Image loog2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        //Creating a rotated transition
        ImageView Loog2 = new ImageView(loog2);
        Loog2.setLayoutY(590);
        Loog2.setLayoutX(0);
        Loog2.setFitWidth(800);
        Loog2.setFitHeight(110);

        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        validation.setLayoutX(550);
        validation.setLayoutY(520);

        validation.setOnAction(actionEvent -> {
            String mail = mailTF.getText();
            String idS = idTF.getText();
            String motdepasse = mdpTF.getText();
            int id=Integer.valueOf(idS);
            ImpleClientDAO imp = new ImpleClientDAO();
            try {
                Client client = imp.connexionClient(id,mail,motdepasse);
                if(client != null)
                {
                    ArrayList<Article> rl = new ArrayList<>();
                    client.setCommandes(rl);
                    menupresentationC(client);
                }
                else{
                    Text nop = new Text("Error");
                    pannne.getChildren().add(nop);
                    nop.setLayoutX(90);
                    nop.setLayoutY(480);
                }
            } catch (SQLException e) {}
        });

        pannne.getChildren().addAll(validation, txt4, idTF,idT,mailTF,mdpTF,mdpT,Loog,Loog2);

        Scene sceene = new Scene(pannne, 800, 700);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    public void connectionEmploye(Stage stage) throws SQLException {
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text idT = new Text("Saisir le ID:");
        idT.setFont(new Font("Arial", 26));
        idT.setStyle("-fx-fill: white;");
        idT.setLayoutX(300);
        idT.setLayoutY(350);

        TextField idTF = new TextField();
        idTF.setLayoutX(300);
        idTF.setLayoutY(370);

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/connexion.jpg")));
        //Creating a rotated transition
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(0);
        Loog.setLayoutX(0);
        Loog.setFitWidth(800);
        Loog.setFitHeight(200);

        Image loog2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande.jpg")));
        //Creating a rotated transition
        ImageView Loog2 = new ImageView(loog2);
        Loog2.setLayoutY(590);
        Loog2.setLayoutX(0);
        Loog2.setFitWidth(800);
        Loog2.setFitHeight(110);

        Text mdpT = new Text("Saisir le motdepasse:");
        mdpT.setFont(new Font("Arial", 26));
        mdpT.setStyle("-fx-fill: white;");
        mdpT.setLayoutX(300);
        mdpT.setLayoutY(450);

        final PasswordField mdpTF = new PasswordField();
        mdpTF.setLayoutX(300);
        mdpTF.setLayoutY(470);

        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        validation.setLayoutX(550);
        validation.setLayoutY(520);

        validation.setOnAction(actionEvent -> {
            String idS = idTF.getText();
            String motdepasse = mdpTF.getText();
            int id=Integer.valueOf(idS);
            ImpleEmployeDAO imp = new ImpleEmployeDAO();
            try {
                Employes employes = imp.    connexionemployes(id,motdepasse);
                if(employes != null)
                {
                    Image();
                }
                else{
                    Text nop = new Text("Error");
                    pannne.getChildren().add(nop);
                    nop.setLayoutX(90);
                    nop.setLayoutY(480);
                }
            } catch (SQLException e) {}
        });

        pannne.getChildren().addAll(Loog, validation, idTF,idT,mdpTF,mdpT,Loog2);

        Scene sceene = new Scene(pannne, 800, 700);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }




public void contact()
{
    Pane pannne = new Pane();
    Stage settle = new Stage();


    Image contact = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/contact.jpg")));
    //Creating a rotated transition
    ImageView Contact = new ImageView(contact);
    Contact.setLayoutY(1);
    Contact.setLayoutX(1);
    Contact.setFitHeight(700);
    Contact.setFitWidth(800);

    pannne.getChildren().addAll(Contact);

    Scene sceene = new Scene(pannne, 800, 700);
    sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
            + "-fx-background-radius: 5px; "
            + "-fx-background-insets: 0px; "
            + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);"); //le code couleur pour le fond

    settle.setScene(sceene);
    settle.setX(0);
    settle.setY(0);
    settle.show();
}


}