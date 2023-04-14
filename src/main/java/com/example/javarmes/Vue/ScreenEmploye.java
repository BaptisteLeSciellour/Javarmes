package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import com.example.javarmes.Model.Articles.Armes;
import com.example.javarmes.Model.Articles.Munitions;
import  com.example.javarmes.Model.DAO.*;
import com.example.javarmes.Model.Utilisateurs.Employes;
import com.example.javarmes.Model.Articles.*;
import com.example.javarmes.Model.Articles.Armes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ScreenEmploye {

    public void InscriptionEmploye(ArrayList<Employes>vecemployes) /** Nous avons un second écran qui apparait**/
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
        boolean pass2;
        int id;
        do {
            pass2=true;

            /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
            Random rand = new Random();
            id = rand.nextInt(4500 + 14500); /** generation aléatoire**/

            /***on verifie que l'identifiant n'existe pas deja**/
            for (Employes emp : vecemployes) {

                if (id == emp.getId()) {
                    System.out.println("L'identifiant est deja pris par un autre employee");
                    pass2=false;
                }
                break;
            }
        } while (!pass2);


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

    public void MAJEmploye(ArrayList<Employes>vecemployes){
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("MAJ employe");
        txt.setLayoutX(90);
        txt.setLayoutY(150);

        Text txt4 = new Text("Saisir l'id:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField mailTF = new TextField();
        mailTF.setLayoutX(90);
        mailTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        validation.setOnAction(actionEvent -> {
            Pane n = new Pane();
            Stage stage = new Stage();

                String mail = mailTF.getText();
            int id= Integer.valueOf(mail);


            for(Employes e : vecemployes)
            {
                if(e.getId()==id)
                {
                    ImpleClientDAO clientDAO = new ImpleClientDAO();
                    Text nvnom = new Text("Saisir le nouveau nom:");
                    nvnom.setLayoutX(90);
                    nvnom.setLayoutY(290);

                    TextField nvxnom = new TextField();
                    nvxnom.setLayoutX(90);
                    nvxnom.setLayoutY(300);

                    Text nvprenom = new Text("Saisir le nouveau prenom:");
                    nvprenom.setLayoutX(90);
                    nvprenom.setLayoutY(340);

                    TextField prenomTF = new TextField();
                    prenomTF.setLayoutX(90); // ici on les décales
                    prenomTF.setLayoutY(350); // ici on remonte les cases


                    Button saisie = new Button("Saisie");
                    saisie.setLayoutX(330);
                    saisie.setLayoutY(400);
                    n.getChildren().addAll(nvnom,nvxnom,nvprenom,prenomTF,saisie);

                    saisie.setOnAction(actionEvent1 -> {
                        Pane pane = new Pane();

                        String prenom = prenomTF.getText();
                        String nom = nvxnom.getText();
                        e.setNom(nom);
                        e.setPrenom(prenom);

                        Text txt2 = new Text("prenom : "+e.getPrenom());
                        txt2.setLayoutX(90);
                        txt2.setLayoutY(150);

                        Text txt3 = new Text("nom : "+e.getNom());
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
                    erreur.setLayoutX(90);
                    erreur.setLayoutY(150);
                    n.getChildren().add(erreur);
                }
                Scene ssc = new Scene(n,520,520);
                stage.setScene(ssc);
                stage.show();

            }
            settle.close();
        });

        pannne.getChildren().addAll(txt,validation,txt4,mailTF);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    public void MenuEmploye(ArrayList<Employes> vecemployes)
    {
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("Voulez-vous ajouter un Employe:");
        txt.setLayoutX(90);
        txt.setLayoutY(290);

        /**creer deux boutons**/
        Button bbtn = new Button("OUI");
        bbtn.setLayoutX(140);
        bbtn.setLayoutY(400);

        Button bbtn2 = new Button("MAJ");
        bbtn2.setLayoutX(240);
        bbtn2.setLayoutY(400);

        Button bbtn3 = new Button("Supp");
        bbtn3.setLayoutX(40);
        bbtn3.setLayoutY(400);

        bbtn.setOnAction(actionEvent -> {
            InscriptionEmploye(vecemployes); /** ici on appelle l'écran que nous allons utiliser**/
            settle.close();
        });

        bbtn2.setOnAction(actionEvent -> {
            MAJEmploye(vecemployes);
        });
        bbtn3.setOnAction(actionEvent -> {
            SuppresionEmploye(vecemployes);
        });
        pannne.getChildren().addAll(bbtn,bbtn2,txt,bbtn3);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    public void SuppresionEmploye(ArrayList<Employes>vecemployes) {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt1 = new Text("Supression de l'employe : ");
        ImpleEmployeDAO clientDAO = new ImpleEmployeDAO();
        Text txt4 = new Text("Saisir l'id de cette employe:");
        txt4.setLayoutX(90);
        txt4.setLayoutY(290);

        TextField idTF = new TextField();
        idTF.setLayoutX(90);
        idTF.setLayoutY(300);

        Button validation = new Button("Validation");
        validation.setLayoutX(90);
        validation.setLayoutY(400);

        pane.getChildren().addAll(txt1,idTF,validation);

        validation.setOnAction(actionEvent -> {

            try {

                int id = Integer.valueOf(idTF.getText());

                /**Verification : si id existe deja **/
                for (Employes cli : vecemployes) {

                    if (id == cli.getId()) {

                        clientDAO.SupprimerEmployes(id);
                        Text supp = new Text("Le profil d'id : "+id+" a bien été supprimer");
                        supp.setLayoutX(50);
                        supp.setLayoutY(100);
                        pane.getChildren().add(supp);
                        ///stage.close();
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
        stage.setScene(scene);
        stage.show();
    }

    public void camembertsamere(Stage primaryStage , ArrayList<Employes> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Stock de fruits");
        /**chart.getData().setAll(new PieChart.Data("Pommes", 50), new PieChart.Data("Oranges", 30),
                new PieChart.Data("Poires", 25), new PieChart.Data("Pêches", 42),
                new PieChart.Data("Citrons", 5), new PieChart.Data("Kiwis", 19)
        );**/


        for(Employes B : art)
        {

            double a = Double.valueOf(B.getId());
            chart.getData().setAll(
                    new PieChart.Data(" ", 00),new PieChart.Data(B.getNom(), a)
            );
        }

        // Montage de l'IU.
        final StackPane root = new StackPane();
        root.getChildren().add(chart);
        final Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Test de PieChart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


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
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }
        public void InscriptionEmploye(ArrayList<Employes>vecemployes,ArrayList<Armes>vecarmes,ArrayList<Munitions>vecmunitions) /** Nous avons un second écran qui apparait**/
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
            boolean pass2;
            int id;
            do {
                pass2=true;

                /**Génération de l'ID : ALEATOIRE entre 4 500 20 000 **/
                Random rand = new Random();
                id = rand.nextInt(4500 + 14500); /** generation aléatoire**/

                /***on verifie que l'identifiant n'existe pas deja**/
                for (Employes emp : vecemployes) {

                    if (id == emp.getId()) {
                        System.out.println("L'identifiant est deja pris par un autre employee");
                        pass2=false;
                    }
                    break;
                }
            } while (!pass2);


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
                MenuEmploye(vecemployes,vecarmes,vecmunitions);
                settle.close();
            });
            panne.getChildren().addAll(bbtn,txtfield,textField,txt,txxt,ttxxtt);

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


        public void MenuEmploye(ArrayList<Employes> vecemployes,ArrayList<Armes>vecarmes,ArrayList<Munitions>vecmunitions)
        {
            Pane pannne = new Pane();
            Stage settle = new Stage();

            Text txt = new Text("Employe: Que voulez-vous faire?");
            txt.setLayoutX(90);
            txt.setLayoutY(200);

            /**creer deux boutons**/
            Button bbtn = new Button("Ajouter un employee");
            bbtn.setLayoutX(140);
            bbtn.setLayoutY(400);

            Button bbtn2 = new Button("MAJ un employee");
            bbtn2.setLayoutX(340);
            bbtn2.setLayoutY(400);

            Button bbtn3 = new Button("Supprimer un employee");
            bbtn3.setLayoutX(540);
            bbtn3.setLayoutY(400);

            Button bbtn4 = new Button("Gerer les stocks");
            bbtn4.setLayoutX(740);
            bbtn4.setLayoutY(400);



            bbtn.setOnAction(actionEvent -> {
                InscriptionEmploye(vecemployes,vecarmes,vecmunitions); /** ici on appelle l'écran que nous allons utiliser**/
                settle.close();
            });

            bbtn2.setOnAction(actionEvent -> {
                MAJEmploye(vecemployes);
            });
            bbtn3.setOnAction(actionEvent -> {
                SuppresionEmploye(vecemployes);
            });
            bbtn4.setOnAction(actionEvent -> {

                Stock(vecarmes,vecmunitions);

            });
            pannne.getChildren().addAll(bbtn,bbtn2,txt,bbtn3,bbtn4);

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

        public  void Stock(ArrayList<Armes>vecarmes,ArrayList<Munitions>vecmunitions)
        {

            Pane pane = new Pane();
            Stage stage = new Stage();

            Button arme = new Button("Armes");
            arme.setLayoutX(90);
            arme.setLayoutY(300);

            Button muni = new Button("Munuitions");
            muni.setLayoutX(190);
            muni.setLayoutY(300);

            arme.setOnAction(actionEvent -> {

                StockArmes(vecarmes);

            });

            muni.setOnAction(actionEvent -> {

                StockMunitions(vecmunitions);
            });

            pane.getChildren().addAll(muni,arme);


            Scene sceene = new Scene(pane, 320, 540);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }


        public void StockArmes(ArrayList<Armes>vecarmes)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Button ajt = new Button("Ajouter une arme");
            ajt.setLayoutX(90);
            ajt.setLayoutY(300);

            Button sup = new Button("Supprimer une arme");
            sup.setLayoutX(210);
            sup.setLayoutY(300);

            Button aff = new Button("Afficher les armes");
            aff.setLayoutX(370);
            aff.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutArme(vecarmes);

            });

            sup.setOnAction(actionEvent -> {

                SupprimerArmes(vecarmes);

            });


            aff.setOnAction(actionEvent -> {

                Armesaffich(vecarmes);

            });



            pane.getChildren().addAll(sup,ajt,aff);


            Scene sceene = new Scene(pane, 320, 540);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }


        public  void AjoutArme(ArrayList<Armes> vecarmes)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();


            /**identification de l'arme**/
            Text ident = new Text("Saisir le nom de l'identification:");
            ident.setLayoutX(90);
            ident.setLayoutY(90);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(100);

            /**categorie**/
            Text CAT = new Text("Saisir la categorie :  B OU C");
            CAT.setLayoutX(90);
            CAT.setLayoutY(150);

            TextField cat = new TextField();
            cat.setLayoutX(90);
            cat.setLayoutY(160);

            /**type**/
            Text tp = new Text("Saisir le type : Poing || Assaut || Chasse || Precision");
            tp.setLayoutX(90);
            tp.setLayoutY(210);

            TextField typ = new TextField();
            typ.setLayoutX(90);
            typ.setLayoutY(220);

            /**type**/
            Text pr = new Text("Saisir le prix");
            pr.setLayoutX(90);
            pr.setLayoutY(270);

            TextField prix = new TextField();
            prix.setLayoutX(90);
            prix.setLayoutY(280);

            /**nom**/
            Text nm = new Text("Saisir le nom");
            nm.setLayoutX(90);
            nm.setLayoutY(330);

            TextField no = new TextField();
            no.setLayoutX(90);
            no.setLayoutY(340);

            /**Calibre**/
            Text cl = new Text("Saisir le calibre");
            cl.setLayoutX(90);
            cl.setLayoutY(390);

            TextField cal = new TextField();
            cal.setLayoutX(90);
            cal.setLayoutY(400);

            /**Reduction**/
            Text red = new Text("Saisir si une réduction est appliquée: 1-Oui 2-Non ");
            red.setLayoutX(90);
            red.setLayoutY(450);

            TextField reduc = new TextField();
            reduc.setLayoutX(90);
            reduc.setLayoutY(460);

            /**Calibre**/
            Text qt = new Text("Quantité : ");
            qt.setLayoutX(90);
            qt.setLayoutY(510);

            TextField quant = new TextField();
            quant.setLayoutX(90);
            quant.setLayoutY(520);

            /**valide les données**/
            Button ajt = new Button("Valider");
            ajt.setLayoutX(400);
            ajt.setLayoutY(300);


            // Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);
            ImpleArmesDAO armesDAO = new ImpleArmesDAO();


            pane.getChildren().addAll(reduc,quant,cal,idTF, cat,typ,prix,no,ajt,ident,CAT,tp,pr,nm,cl,red,qt);


            ajt.setOnAction(actionEvent -> {

                String identification,categorie, nom,type;
                double prix_unique, calibre, temp;
                int quantite;
                // boolean pass3=true;
                boolean reduction=false;

                identification = String.valueOf(idTF.getText());


                do {

                    categorie = cat.getText();

                } while (categorie == "B" && categorie == "C");


                // categorie = String.valueOf(cat.getText());

                do {

                    type = typ.getText();

                } while (type == "Poing" && type == "Assaut" && type == "Precision" && type == "Chasse");

                /**Prix **/
                do {
                    prix_unique = Integer.valueOf(prix.getText());

                } while (prix_unique <=0 );

                nom = no.getText();


                /**calibre **/
                do {
                    calibre = Integer.valueOf(cal.getText());

                } while (calibre <=0 );

                /**reduction **/
                do {

                    temp = Integer.valueOf(reduc.getText());

                } while (temp != 1 && temp != 2);

                if(temp==1)
                {
                    reduction=true;

                }
                if(temp==2)
                {
                    reduction=false;
                }

                /**Quantité**/
                do {
                    quantite = Integer.valueOf(quant.getText());

                } while (quantite <0 );

                Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);

                vecarmes.add(armes);

                try {

                    armesDAO.AjouterArme(armes);


                    if (armes != null) {

                        Text supp = new Text("Armes ajouté :\n" + "identification: " + armes.getIndentification() + "\ncategorie: " + armes.getCategorie() + "\ntype: " + armes.getType() + "\nnnom: " + armes.getNom() );
                        supp.setLayoutX(300);
                        supp.setLayoutY(300);
                        pane.getChildren().add(supp);


                        //System.out.println("Armes ajouté :" + "\nidentification: " + armes.getIndentification() + "\ncategorie: " + armes.getCategorie() + "\ntype: " + armes.getType() + "\nnom: " + armes.getNom() + " \n");
                    } else {
                        //System.out.println("L'arme n'a pas été créé\n");
                    }
                } catch (SQLException e) {
                    //  System.out.println("Erreur");
                    //System.out.println(e);

                    Text supp = new Text(e.toString());
                    supp.setLayoutX(50);
                    supp.setLayoutY(100);
                    pane.getChildren().add(supp);
                    stage.close();
                }

            });


            Scene scene = new Scene(pane, 520, 520);

            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(scene);
            stage.show();

        }

        public void Armesaffich(ArrayList<Armes>vecarmes)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt8 = new Text("Voici les armes :");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            ImpleArmesDAO armesDAO = new ImpleArmesDAO();

            int decalage=0;

            try {

                armesDAO.ChoisirArmes();


                /**Affichage**/
                for (Armes arm : vecarmes) {

                    Text supp = new Text("Armes :\n" + "identification: " + arm.getIndentification() + "\ncategorie: " + arm.getCategorie() + "\ntype: " + arm.getType() + "\nnnom: " + arm.getNom() );
                    supp.setLayoutX(300);
                    supp.setLayoutY(300+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+100;

                }
            }
            catch (SQLException e) {
                //  System.out.println("Erreur");
                //System.out.println(e);

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }



            pane.getChildren().addAll(txt8);
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }



        public  void SupprimerArmes(ArrayList<Armes>vecarmes)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt1 = new Text("Supression d'une arme : ");

            ImpleArmesDAO armesDAO = new ImpleArmesDAO();

            Text txt4 = new Text("Saisir l'identification:");
            txt4.setLayoutX(90);
            txt4.setLayoutY(290);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(300);

            Button validation = new Button("Validation");
            validation.setLayoutX(90);
            validation.setLayoutY(400);

            pane.getChildren().addAll(txt1,txt4,idTF,validation);

            validation.setOnAction(actionEvent -> {

                /**
                 try {


                 String identification =  idTF.getText();
                 int quantite=-1;


                 //Verification : si id existe deja
                 for (Armes arm : vecarmes) {

                 if (Objects.equals(identification , arm.getIdentification())) {


                 //ArmesDAO.GererStockArme(identification,quantite);



                 Text supp = new Text("Une arme d'identification : "+identification+" a bien été supprimee");
                 supp.setLayoutX(50);
                 supp.setLayoutY(100);
                 pane.getChildren().add(supp);

                 vecarmes.remove(arm);

                 ///stage.close();
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
                 **/
            });

            Scene scene = new Scene(pane,520,520);

            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(scene);
            stage.show();
        }

        public  void StockMunitions(ArrayList<Munitions>vecmunitions)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Button ajt = new Button("Ajouter une munition");
            ajt.setLayoutX(90);
            ajt.setLayoutY(300);

            Button sup = new Button("Supprimer une munition");
            sup.setLayoutX(250);
            sup.setLayoutY(300);

            Button aff = new Button("Afficher les munitions");
            aff.setLayoutX(440);
            aff.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutMunitions(vecmunitions);

            });

            sup.setOnAction(actionEvent -> {

                SupprimerMunitions(vecmunitions);

            });

            aff.setOnAction(actionEvent -> {

                Munitionsaffich(vecmunitions);

            });



            pane.getChildren().addAll(sup,ajt,aff);


            Scene sceene = new Scene(pane, 320, 540);

            sceene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");

            stage.setScene(sceene);
            stage.setX(0);
            stage.setY(0);
            stage.show();

        }


        public void Munitionsaffich(ArrayList<Munitions>vecmunitions)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt8 = new Text("Voici les munitions :");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();

            int decalage=0;

            try {

                munitionsDAO.ChoisirMunitions();


                /**Affichage**/
                for (Munitions muni : vecmunitions) {

                    Text supp = new Text("Armes :\n" + "identification: " + muni.getIndentification() + "\ncategorie: " + muni.getCategorie() + "\nprix : " + muni.getPrix_unique() + "\nnnom: " + muni.getNom() );
                    supp.setLayoutX(300);
                    supp.setLayoutY(300+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+100;

                }
            }
            catch (SQLException e) {
                //  System.out.println("Erreur");
                //System.out.println(e);

                Text supp = new Text(e.toString());
                supp.setLayoutX(50);
                supp.setLayoutY(100);
                pane.getChildren().add(supp);
                stage.close();
            }



            pane.getChildren().addAll(txt8);
            Scene scene = new Scene(pane,520,520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();
        }


        public  void AjoutMunitions(ArrayList<Munitions> vecmunitions)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            //int nb_vente


            Text ident = new Text("Saisir le nom de l'identification:");
            ident.setLayoutX(90);
            ident.setLayoutY(90);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(100);


            Text CAT = new Text("Saisir la categorie :  B OU C");
            CAT.setLayoutX(90);
            CAT.setLayoutY(150);

            TextField cat = new TextField();
            cat.setLayoutX(90);
            cat.setLayoutY(160);


            Text pr = new Text("Saisir le prix unique");
            pr.setLayoutX(90);
            pr.setLayoutY(210);

            TextField prix = new TextField();
            prix.setLayoutX(90);
            prix.setLayoutY(220);

            Text prvc = new Text("Saisir le prix en vrac");
            prvc.setLayoutX(90);
            prvc.setLayoutY(270);

            TextField prixvrac = new TextField();
            prixvrac.setLayoutX(90);
            prixvrac.setLayoutY(280);

            Text nm = new Text("Saisir le nom");
            nm.setLayoutX(90);
            nm.setLayoutY(330);

            TextField no = new TextField();
            no.setLayoutX(90);
            no.setLayoutY(340);


            Text cl = new Text("Saisir le calibre");
            cl.setLayoutX(90);
            cl.setLayoutY(390);

            TextField cal = new TextField();
            cal.setLayoutX(90);
            cal.setLayoutY(400);


            Text red = new Text("Saisir si une réduction est appliquée: 1-Oui 2-Non ");
            red.setLayoutX(90);
            red.setLayoutY(450);

            TextField reduc = new TextField();
            reduc.setLayoutX(90);
            reduc.setLayoutY(460);


            Text qt = new Text("Quantité : ");
            qt.setLayoutX(90);
            qt.setLayoutY(510);

            TextField quant = new TextField();
            quant.setLayoutX(90);
            quant.setLayoutY(520);

            Text vt = new Text("Nombre de vente: ");
            vt.setLayoutX(90);
            vt.setLayoutY(570);

            TextField vente = new TextField();
            vente.setLayoutX(90);
            vente.setLayoutY(580);



            Button ajt = new Button("Valider");
            ajt.setLayoutX(400);
            ajt.setLayoutY(300);



            // Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);
            ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


            pane.getChildren().addAll(reduc,quant,cal,idTF, cat,prvc,prixvrac,vente,vt,prix,no,ajt,ident,CAT,pr,nm,cl,red,qt);


            ajt.setOnAction(actionEvent -> {

                String identification,categorie, nom;
                double prix_unique,prix_vrac, calibre, temp;
                int quantite,nb_vente;
                // boolean pass3=true;
                boolean reduction=false;

                identification = String.valueOf(idTF.getText());


                do {

                    categorie = cat.getText();

                } while (categorie == "B" && categorie == "C");


                // categorie = String.valueOf(cat.getText());

                do {

                    nb_vente = Integer.valueOf(vente.getText());

                } while (nb_vente <0 );

                /**Prix **/
                do {
                    prix_unique = Integer.valueOf(prix.getText());

                } while (prix_unique <=0 );

                /**Prix **/
                do {
                    prix_vrac = Integer.valueOf(prixvrac.getText());

                } while (prix_unique <=0 );

                nom = no.getText();


                /**calibre **/
                do {
                    calibre = Integer.valueOf(cal.getText());

                } while (calibre <=0 );

                /**reduction **/
                do {

                    temp = Integer.valueOf(reduc.getText());

                } while (temp != 1 && temp != 2);

                if(temp==1)
                {
                    reduction=true;

                }
                if(temp==2)
                {
                    reduction=false;
                }

                /**Quantité**/
                do {
                    quantite = Integer.valueOf(quant.getText());

                } while (quantite <0 );



                Munitions munition = new Munitions(identification, categorie,  nom, prix_unique,quantite, calibre, reduction,  prix_vrac, nb_vente);

                vecmunitions.add(munition);


                try {

                    munitionsDAO.ajouter(munition);


                    if (munition != null) {

                        Text supp = new Text("Armes ajouté :\n" + "identification: " + munition.getIndentification() + "\ncategorie: " + munition.getCategorie() + "\nnnom: " + munition.getNom() );
                        supp.setLayoutX(300);
                        supp.setLayoutY(300);
                        pane.getChildren().add(supp);


                        //System.out.println("Armes ajouté :" + "\nidentification: " + armes.getIndentification() + "\ncategorie: " + armes.getCategorie() + "\ntype: " + armes.getType() + "\nnom: " + armes.getNom() + " \n");
                    }

                } catch (SQLException e) {
                    //  System.out.println("Erreur");
                    //System.out.println(e);

                    Text supp = new Text(e.toString());
                    supp.setLayoutX(50);
                    supp.setLayoutY(100);
                    pane.getChildren().add(supp);
                    stage.close();
                }

            });




            Scene scene = new Scene(pane, 520, 520);
            scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                    + "-fx-background-radius: 5px; "
                    + "-fx-background-insets: 0px; "
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
            stage.setScene(scene);
            stage.show();

        }



        public  void SupprimerMunitions(ArrayList<Munitions>vecmunitions)
        {
            Pane pane = new Pane();
            Stage stage = new Stage();

            Text txt1 = new Text("Supression d'une munition : ");

            ImpleArmesDAO armesDAO = new ImpleArmesDAO();

            Text txt4 = new Text("Saisir l'identification:");
            txt4.setLayoutX(90);
            txt4.setLayoutY(290);

            TextField idTF = new TextField();
            idTF.setLayoutX(90);
            idTF.setLayoutY(300);

            Button validation = new Button("Validation");
            validation.setLayoutX(90);
            validation.setLayoutY(400);

            pane.getChildren().addAll(txt1,txt4,idTF,validation);

            validation.setOnAction(actionEvent -> {

                /**

                 try {


                 String identification =  idTF.getText();
                 int quantite=-1;


                 //Verification : si id existe deja
                 for (Munitions muni : vecmunitions) {

                 if (Objects.equals(identification , muni.getIdentification())) {


                 MunitionsDAO.GererStockMunition(identification,quantite);



                 Text supp = new Text("Une munition d'identification : "+identification+" a bien été supprimee");
                 supp.setLayoutX(50);
                 supp.setLayoutY(100);
                 pane.getChildren().add(supp);

                 vecmunitions.remove(muni);

                 ///stage.close();
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
                 **/
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



