package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Articles.Munitions;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.DAO.ImplePanierDAO;
import com.example.javarmes.Model.Panier.Panier;
import com.example.javarmes.Model.Utilisateurs.Client;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class ScreenCLient {
    /**
     * Classe pour l'écran client. Fonction de création d'un client et de son ajout dans la base de données avec
     * ses blindages.
     * @author Maléna et Baptiste
     * @version 3.0
     */
    public void creationClient(Text txxt){
        Stage stage = new Stage();
        Pane panne = new Pane();

        Image loog = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/bande2.jpg")));
        ImageView Loog = new ImageView(loog);
        Loog.setLayoutY(1);
        Loog.setFitWidth(800);
        Loog.setFitHeight(130);
        Loog.setLayoutX(1);

        Image txt1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/crrea.jpg")));
        ImageView Txt1 = new ImageView(txt1);
        Txt1.setLayoutY(120);
        Txt1.setLayoutX(50);
        Txt1.setFitWidth(700);
        Txt1.setFitHeight(100);

        ImpleClientDAO clientDAO = new ImpleClientDAO();
        Text txt4 = new Text("Entrez votre e-mail:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
        txt4.setLayoutX(300);
        txt4.setLayoutY(250);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(300);
        mailTF.setLayoutY(270);

        Text txt6 = new Text("Créez votre mot de passe:");
        txt6.setFont(new Font("Arial", 26));
        txt6.setStyle("-fx-fill: white;");
        txt6.setLayoutX(300);
        txt6.setLayoutY(330);

        Text txt67 = new Text("Confirmez votre mot de passe:");
        txt67.setFont(new Font("Arial", 26));
        txt67.setStyle("-fx-fill: white;");
        txt67.setLayoutX(300);
        txt67.setLayoutY(410);

        TextField mdpTF = new TextField();
        mdpTF.setLayoutX(300);
        mdpTF.setLayoutY(350);

        TextField mdpTF2 = new TextField();
        mdpTF2.setLayoutX(300);
        mdpTF2.setLayoutY(430);
        //A checkbox without a caption
        CheckBox cb1 = new CheckBox("J'accepte les conditions d'utilisation.");
        CheckBox cb2 = new CheckBox("Je ne suis pas un robot.");

        cb1.setLayoutX(300);
        cb1.setLayoutY(510);
        cb2.setLayoutX(300);
        cb2.setLayoutY(530);


        if(txxt!=null)
        {
            txxt.setLayoutX(90);
            txxt.setLayoutY(100);
            panne.getChildren().add(txxt);
        }

        mailTF.clear();
        mdpTF.clear();

        Button saisie = new Button("Valider les données");
        saisie.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        saisie.setLayoutY(600);
        saisie.setLayoutX(550);

        saisie.setOnAction(event->{
            ImpleEmployeDAO empl = new ImpleEmployeDAO();
            ArrayList<Client> vecclient = new ArrayList<>();
            try {
                vecclient = (ArrayList<Client>) empl.ChoisirClient(); /** Acquisition de toute la liste des clients présents dans notre base de données**/
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String mail;
            String mdp;
            int id;
            boolean pass3;
            /** Blindage pour la saisie du mail, outil majeur de notre connexion**/
            do {
                 pass3=true;
                 mail = mailTF.getText();
                 mdp = mdpTF.getText();

                    for (Client cli : vecclient) {

                        if (Objects.equals(mail, cli.getMail())) {

                            txxt.setText("Le mail existe deja");
                            panne.getChildren().add(txxt);
                            stage.close();
                            pass3=false;
                            break;
                        }
                    }
                } while (!pass3);
            boolean pass2;

            do {

                pass2=true;

                /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
                Random rand = new Random();

                id=rand.nextInt(4500 + 14500); /** generation aléatoire**/

                /***on verifie que l'identifiant n'existe pas deja**/
                for (Client cli : vecclient) {

                    if (id == cli.getId()) {
                        System.out.println("L'identifiant est deja pris par un autre client");
                        pass2=false;
                    }
                    break;
                }

            }while(!pass2);

            Pane pane = new Pane();
            Stage stage1 = new Stage();

            Button btn = new Button("Sortie");

            btn.setOnAction(actionEvent -> {
                stage1.close();
            });

            Client client = new Client(id,mail, mdp);

            try {

                /**ajouter dans la base de donnéé**/
                clientDAO.Ajouter(client);

                if (client != null) {

                    /**Affichage du client**/
                    Text txt8 = new Text("Client ajouté :");
                    txt8.setFont(new Font("Arial", 26));
                    txt8.setStyle("-fx-fill: white;");
                    txt8.setLayoutX(90);
                    txt8.setLayoutY(90);

                    Text txt2 = new Text("mail : "+mail);
                    txt2.setFont(new Font("Arial", 26));
                    txt2.setStyle("-fx-fill: white;");
                    txt2.setLayoutX(90);
                    txt2.setLayoutY(150);

                    Text txt3 = new Text("MDP : "+mdp);
                    txt3.setFont(new Font("Arial", 26));
                    txt3.setStyle("-fx-fill: white;");
                    txt3.setLayoutX(90);
                    txt3.setLayoutY(200);

                    Text ID = new Text("ID : "+id);
                    ID.setFont(new Font("Arial", 26));
                    ID.setStyle("-fx-fill: white;");
                    ID.setLayoutX(90);
                    ID.setLayoutY(250);

                    pane.getChildren().addAll(txt8,txt2,txt3,ID);

                } else {
                    Text pas = new Text("Le client n'a pas été créé\n");
                    pas.setLayoutX(90);
                    pas.setLayoutY(290);
                    pane.getChildren().add(pas);
                }
            } catch (SQLException e) {

                Text exception = new Text("Erreur");
                exception.setLayoutX(90);
                exception.setLayoutY(290);
                pane.getChildren().add(exception);

            }
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage1.setScene(scene);
            stage1.show();
            stage.close();
        });

        panne.getChildren().addAll(saisie,mailTF,mdpTF,txt4,txt6,txt67,mdpTF2,Txt1,cb1,cb2,Loog);
        Scene settle = new Scene(panne,800,700);
        settle.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(settle);
        stage.show();

    }

    /**
     * Classe pour l'écran client. Fonction pour l'affichage du panier d'un client.
     * @author Baptiste
     * @version 3.0
     */
    public void affichagePanier(Client C) throws SQLException {
        ArrayList<Panier> artt ;
        ArrayList<Article> armme = new ArrayList<>();
        ImplePanierDAO panier = new ImplePanierDAO();
        artt = (ArrayList<Panier>) panier.AffichePanier(C.getId()); /** Obtention de toutes les commandes pour ce client**/
        ScreenArticle sc = new ScreenArticle();
        AtomicInteger i = new AtomicInteger(0); /** Atomic Integer pour pouvoir utiliser cette variable dans un ActionEvent.**/
        for( Panier e : artt)
        {
            if(Objects.equals(e.type_article,"Arme"))
            {
                System.out.println("*");
                Armes temp = new Armes();
                temp.setNom(e.nom_article);
                armme.add(temp);
            }
            else
            {
                System.out.println("/");
                Munitions mun = new Munitions();
                mun.setNom(e.nom_article);
                armme.add(mun);
            }
        }
        sc.defilementP(i,armme,C); /** Appel d'une version spécial de la fonction défilement dotée d'un bouton effacer. **/
    }
    /**
     * Classe pour l'écran client. Affichage des possibilités du client, la mise à jour de son profil, la visualisation de son panier ou encore la suppression
     * de son compte.
     * @author Maléna et Baptiste
     * @version 3.0
     */
    public void DetailClient(Client C) throws SQLException {
        Pane pannne = new Pane();
        Stage settle = new Stage();
        Button panier = new Button("Panier de "+C.getMail());
        Text renfo = new Text();
        ImplePanierDAO pannnnn = new ImplePanierDAO();
        renfo.setLayoutX(0);
        renfo.setLayoutY(100);
        renfo.setText(pannnnn.ResumePaiement(C.getId()));
        renfo.setStyle("-fx-background-color: white; -fx-text-fill: white; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        panier.setLayoutX(0);
        panier.setLayoutY(0);
        Text txt = new Text("Que voulez vous faire?");
        txt.setFont(new Font("Arial", 26));
        txt.setStyle("-fx-fill: white;");
        txt.setLayoutX(20);
        txt.setLayoutY(150);

        Button bbtn2 = new Button("MAJ du client");
        bbtn2.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn2.setLayoutX(70);
        bbtn2.setLayoutY(300);

        Button bbtn3 = new Button("Supprimer votre profil");
        bbtn3.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn3.setLayoutX(70);
        bbtn3.setLayoutY(400);

        Button bbtn4 = new Button("Payer");
        bbtn4.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        bbtn4.setLayoutX(70);
        bbtn4.setLayoutY(200);

        panier.setOnAction(actionEvent -> {
            try {
                affichagePanier(C);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        bbtn2.setOnAction(actionEvent -> {
            try {
                MAJClient();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        bbtn3.setOnAction(actionEvent -> {
            try {
                suppressionClient(C);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        bbtn4.setOnAction(actionEvent -> {
            ImplePanierDAO pann = new ImplePanierDAO();
            try {
                pann.Payer(C.getId());
                Menu scc = new Menu();
                scc.coordonees();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        pannne.getChildren().addAll(bbtn2,txt,bbtn3,bbtn4,panier,renfo);

        Scene sceene = new Scene(pannne, 950, 540);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }
    /**
     * Classe pour l'écran client. Mise à jour du client.
     * @author Maléna et Baptiste
     * @version 3.0
     */

    public void MAJClient() throws SQLException {
        Pane pannne = new Pane();
        Stage settle = new Stage();
        ArrayList<Client> arr ;
        ImpleEmployeDAO clii = new ImpleEmployeDAO();
        arr = (ArrayList<Client>) clii.ChoisirClient();
        Text txt = new Text("MAJ client");
        txt.setFont(new Font("Arial", 26));
        txt.setStyle("-fx-fill: white;");
        txt.setLayoutX(90);
        txt.setLayoutY(150);

        Text txt4 = new Text("Saisir le mail:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setFont(new Font("Arial", 26));
        mailTF.setStyle("-fx-fill: white;");
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        validation.setOnAction(actionEvent -> {
            Pane n = new Pane();
            Stage stage = new Stage();

            String mail = mailTF.getText();

            for(Client e : arr)
            {
                if(Objects.equals(e.getMail(),mail))
                {
                    Text txt1 = new Text("Création du client : ");
                    txt1.setFont(new Font("Arial", 26));
                    txt1.setStyle("-fx-fill: white;");

                    Text nvmail = new Text("Saisir le nouveau mail:");
                    nvmail.setFont(new Font("Arial", 20));
                    nvmail.setStyle("-fx-fill: white;");
                    nvmail.setLayoutX(90);
                    nvmail.setLayoutY(290);

                    TextField nvxmailTF = new TextField();
                    nvxmailTF.setLayoutX(90);
                    nvxmailTF.setLayoutY(300);

                    Text nvmdp = new Text("Saisir un mot de passe :");
                    nvmdp.setFont(new Font("Arial", 20));
                    nvmdp.setStyle("-fx-fill: white;");
                    nvmdp.setLayoutX(90);
                    nvmdp.setLayoutY(340);

                    Text nvmdp2 = new Text("Confirmez votre mot de passe:");
                    nvmdp2.setFont(new Font("Arial", 20));
                    nvmdp2.setStyle("-fx-fill: white;");
                    nvmdp2.setLayoutX(90);
                    nvmdp2.setLayoutY(3780);

                    TextField mdp2 = new TextField();
                    mdp2.setLayoutX(90);
                    mdp2.setLayoutY(460);


                    TextField mdpTF = new TextField();
                    mdpTF.setLayoutX(90);
                    mdpTF.setLayoutY(350);


                    Button saisie = new Button("Saisie");
                    saisie.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");

                    saisie.setLayoutX(330);
                    saisie.setLayoutY(400);
                    n.getChildren().addAll(nvmdp,nvmdp2,nvmail,nvxmailTF,mdpTF,saisie,mdp2);

                    saisie.setOnAction(actionEvent1 -> {
                        Pane pane = new Pane();

                        String nvxmail = nvxmailTF.getText();
                        String nvxmdp = nvxmailTF.getText();
                        e.setMail(nvxmail);
                        e.setMdp(nvxmdp);

                        Text txt2 = new Text("mail : "+e.getMail());
                        txt2.setLayoutX(90);
                        txt2.setLayoutY(150);

                        Text txt3 = new Text("MDP : "+e.getMdp());
                        txt3.setLayoutX(90);
                        txt3.setLayoutY(200);

                        Text ID = new Text("ID : "+e.getId());
                        ID.setLayoutX(90);
                        ID.setLayoutY(250);
                        pane.getChildren().addAll(txt2,txt3,ID);
                        Scene scene = new Scene(pane,520,520);
                        stage.setScene(scene);
                        stage.show();
                    });
                }
                else
                {
                    Text erreur = new Text("pas de personne ce ce nom la ici");
                    erreur.setFont(new Font("Arial", 26));
                    erreur.setStyle("-fx-fill: white;");
                    erreur.setLayoutX(90);
                    erreur.setLayoutY(150);
                    n.getChildren().add(erreur);
                }
                Scene ssc = new Scene(n,520,520);
                ssc.getRoot().setStyle("-fx-background-color: #4B5320; "
                        + "-fx-background-radius: 5px; "
                        + "-fx-background-insets: 0px; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
                stage.setScene(ssc);
                stage.show();

            }
            settle.close();
        });

        pannne.getChildren().addAll(txt,validation,txt4,mailTF);

        Scene sceene = new Scene(pannne, 320, 540);
        sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    /**
     * Classe pour l'écran client. Suppression du client.
     * @author Maléna et Baptiste
     * @version 3.0
     */
    public void suppressionClient(Client C) throws SQLException {

            Pane pane = new Pane();
            Stage stage = new Stage();

                Text txt1 = new Text("Supression du client : ");
                txt1.setFont(new Font("Arial", 26));
                txt1.setStyle("-fx-fill: white;");
                ImpleClientDAO clientDAO = new ImpleClientDAO();
                ArrayList<Client> arr ;
                ImpleEmployeDAO clii = new ImpleEmployeDAO();
                arr = (ArrayList<Client>) clii.ChoisirClient();
                Text txt4 = new Text("Saisir l'id de ce client:");
                txt4.setFont(new Font("Arial", 26));
                txt4.setStyle("-fx-fill: white;");
                txt4.setLayoutX(90);
                txt4.setLayoutY(290);

                TextField idTF = new TextField();
                idTF.setLayoutX(90);
                idTF.setLayoutY(300);

                Button validation = new Button("Validation");
                validation.setStyle("-fx-background-color: white; -fx-text-fill: #4B5320; -fx-font-size: 16pt; -fx-padding: 10px 20px; -fx-background-radius: 10px;");
                validation.setLayoutX(90);
                validation.setLayoutY(400);

                pane.getChildren().addAll(txt1,idTF,validation);

                validation.setOnAction(actionEvent -> {

                    try {

                        int id = Integer.valueOf(idTF.getText());

                        /**Verification : si id existe deja **/
                        for (Client cli : arr) {

                            if (id == cli.getId()) {

                                clientDAO.Supprimer(id);
                                Text supp = new Text("Le profil d'id : "+id+" a bien été supprimer");
                                supp.setLayoutX(50);
                                supp.setLayoutY(100);
                                pane.getChildren().add(supp);
                                break;
                            }
                        }

                    } catch (SQLException e) {
                        Text supp = new Text(e.toString());
                        supp.setLayoutX(50);
                        supp.setLayoutY(100);
                        pane.getChildren().add(supp);
                        stage.close();
                    }
                });

         Scene scene = new Scene(pane,520,520);
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
         stage.setScene(scene);
         stage.show();
    }
}