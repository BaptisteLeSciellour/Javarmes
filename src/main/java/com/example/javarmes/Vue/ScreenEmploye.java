package com.example.javarmes.Vue;

import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.DAO.ImpleClientDAO;
import com.example.javarmes.Model.DAO.ImpleEmployeDAO;
import com.example.javarmes.Model.Utilisateurs.Client;
import com.example.javarmes.Model.Utilisateurs.Employes;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
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
import java.util.*;

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

        Text txt = new Text("Voulez-vous ajouter un employé ?");
        txt.setFont(new Font("Arial", 26));
        txt.setStyle("-fx-fill: white;");
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

        Button bbtn4 = new Button("Gerer les stocks");
        bbtn4.setLayoutX(340);
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

    public void SuppresionEmploye(ArrayList<Employes>vecemployes) {
        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt1 = new Text("Supression de l'employé : ");
        txt1.setFont(new Font("Arial", 26));
        txt1.setStyle("-fx-fill: white;");
        ImpleEmployeDAO clientDAO = new ImpleEmployeDAO();
        Text txt4 = new Text("Saisir l'identifiant de cet employé:");
        txt4.setFont(new Font("Arial", 26));
        txt4.setStyle("-fx-fill: white;");
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
        scene.getRoot().setStyle("-fx-background-color: #4B5320; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-insets: 0px; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0.0, 0, 4);");
        stage.setScene(scene);
        stage.show();
    }

    public void camembertsamere(Stage primaryStage , List<Client> art) {
        final PieChart chart = new PieChart();
        chart.setTitle("Achat par client");
        int i =0;
        for(Client B : art)
        {
            System.out.print("/");
            chart.getData().add(new PieChart.Data(B.getNom(),B.getId()));
            i++;
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
            Text txt8 = new Text("Coordonnées enregistrées :");
            txt8.setFont(new Font("Arial", 26));
            txt8.setStyle("-fx-fill: white;");
            txt8.setLayoutX(90);
            txt8.setLayoutY(90);

            Text txt2 = new Text("Prénom : "+prenom);
            txt2.setFont(new Font("Arial", 26));
            txt2.setStyle("-fx-fill: white;");
            txt2.setLayoutX(90);
            txt2.setLayoutY(150);

            Text txt3 = new Text("Nom : "+nom);
            txt3.setFont(new Font("Arial", 26));
            txt3.setStyle("-fx-fill: white;");
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

            Image txt1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/creapro.jpg")));
            //Creating a rotated transition
            ImageView Txt1 = new ImageView(txt1);
            Txt1.setLayoutY(20);
            Txt1.setLayoutX(100);

            Text txt = new Text("Prénom");
            txt.setFont(new Font("Arial", 26));
            txt.setStyle("-fx-fill: white;");
            txt.setLayoutX(300);
            txt.setLayoutY(290);

            TextField txtfield = new TextField();
            txtfield.setLayoutX(300);
            txtfield.setLayoutY(310);

            Text txxt = new Text("Nom de famille");
            txxt.setFont(new Font("Arial", 26));
            txxt.setStyle("-fx-fill: white;");
            txxt.setLayoutX(300);
            txxt.setLayoutY(380);
            TextField textField = new TextField();
            textField.setLayoutX(300); // ici on les décales
            textField.setLayoutY(400); // ici on remonte les cases

            CheckBox cb1 = new CheckBox("J'atteste ajouter un membre du staff.");
            cb1.setLayoutX(300);
            cb1.setLayoutY(450);
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


            Button bbtn = new Button("Ajouter l'employé(e)");
            bbtn.setLayoutX(300);
            bbtn.setLayoutY(600);
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
            panne.getChildren().addAll(bbtn,txtfield,textField,txt,txxt,Txt1,cb1);

            Scene sceene = new Scene(panne,800,700);

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

            Button re = new Button("Rechercher une armes");
            re.setLayoutX(510);
            re.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutArme(vecarmes);

            });

            sup.setOnAction(actionEvent -> {

                SupprimerArmes(vecarmes);

            });


            aff.setOnAction(actionEvent -> {

                Armesaffich(vecarmes);

            });

            re.setOnAction(actionEvent -> {

                RechercherArmes(vecarmes);

            });

            pane.getChildren().addAll(sup,ajt,aff,re);


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
        {  Pane pane = new Pane();
            Stage stage = new Stage();

            Armes armes = new Armes();

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


            /**Catégorie Bou C**/
            Button b = new Button("B");
            b.setLayoutX(90);
            b.setLayoutY(160);

            Button c = new Button("C");
            c.setLayoutX(150);
            c.setLayoutY(160);



            b.setOnAction(actionEvent -> {

                armes.setCategorie("B");

            });

            c.setOnAction(actionEvent -> {

                armes.setCategorie("C");

            });

            //ImageView imageView = new ImageView();

            //imageView=DonationImage();


            /**type**/
            Text tp = new Text("Saisir le type :");
            tp.setLayoutX(90);
            tp.setLayoutY(210);


            /**Catégorie Bou C**/
            Button poing = new Button("Poing");
            poing.setLayoutX(90);
            poing.setLayoutY(220);

            Button assaut = new Button("Assaut");
            assaut.setLayoutX(150);
            assaut.setLayoutY(220);

            /**Catégorie Bou C**/
            Button chasse = new Button("Chasse");
            chasse.setLayoutX(250);
            chasse.setLayoutY(220);

            Button precision = new Button("Precision");
            precision.setLayoutX(350);
            precision.setLayoutY(220);


            poing.setOnAction(actionEvent -> {

                armes.setType("Poing");

            });

            assaut.setOnAction(actionEvent -> {

                armes.setType("Assaut");

            });

            chasse.setOnAction(actionEvent -> {


                armes.setType("Chasse");

            });

            precision.setOnAction(actionEvent -> {

                armes.setType("Precision");

            });


            /**prix**/
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

            TextField nom = new TextField();
            nom.setLayoutX(90);
            nom.setLayoutY(340);

            /**Calibre**/
            Text cl = new Text("Saisir le calibre");
            cl.setLayoutX(90);
            cl.setLayoutY(390);

            TextField cal = new TextField();
            cal.setLayoutX(90);
            cal.setLayoutY(400);

            /**Reduction**/
            Text red = new Text("Saisir si une réduction est appliquée :  ");
            red.setLayoutX(90);
            red.setLayoutY(450);


            Button oui = new Button("OUI");
            oui.setLayoutX(90);
            oui.setLayoutY(460);

            Button non = new Button("NON");
            non.setLayoutX(130);
            non.setLayoutY(460);

            oui.setOnAction(actionEvent -> {

                armes.setReduction(true);

            });

            non.setOnAction(actionEvent -> {

                armes.setReduction(false);

            });

            Text qt = new Text("Saisir la quantite");
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


            pane.getChildren().addAll(oui,qt,quant,non,cal,idTF, b,c,prix,ajt,ident,CAT,tp,pr,nm,cl,red,nom,poing,chasse,assaut,precision);


            ajt.setOnAction(actionEvent -> {

                int quantite=0;

                /**Quantite **/
                do {
                    quantite= Integer.valueOf(quant.getText());

                    armes.setQuantite(quantite);

                } while (quantite <0 );


                armes.setNom( nom.getText());

                armes.setIdentification( String.valueOf(idTF.getText()));

                /**Prix **/
                do {
                    armes.setPrix_unique( Integer.valueOf(prix.getText()));

                } while (armes.getPrix_unique() <=0 );


                /**calibre **/
                do {
                    armes.setCalibre(Integer.valueOf(cal.getText()));

                } while (armes.getCalibre() <=0 );

                //Armes armes = new Armes(identification,type,categorie,nom,prix_unique,quantite,calibre,reduction);

                vecarmes.add(armes);

                try {

                    armesDAO.AjouterArme(armes);


                    if (armes != null) {

                        Text supp = new Text("Armes ajouté :\n" + "identification: " + armes.getIndentification() + "\ncategorie: " + armes.getCategorie() + "\ntype: " + armes.getType() + "\nnom: " + armes.getNom()+ "\nquantite: "+ armes.getQuantite() + "\ncalibre: " + armes.getCalibre()+ "\nreduction: " + armes.getReduction()+ "\nprix: " + armes.getPrix_unique() );
                        supp.setLayoutX(90);
                        supp.setLayoutY(600);
                        pane.getChildren().add(supp);



                    }
                } catch (SQLException e) {

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

                    Text supp = new Text("Armes :\n" + "identification: " + arm.getIndentification() + "\ncategorie: " + arm.getCategorie() + "\ntype: " + arm.getType() + "\nprix unique: " + arm.getPrix_unique()+ "\ncalibre: " + arm.getCalibre()+ "\nnom: " + arm.getNom()+ "\nreduction: " + arm.getReduction()+ "\nquantite : " + arm.getQuantite() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(300+decalage);
                    pane.getChildren().add(supp);
                    decalage=decalage+150;

                }
            }
            catch (SQLException e) {


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

    public void RechercherArmes(ArrayList<Armes>vecarmes)
    {

        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt1 = new Text("Recherche d'une arme : ");

        ImpleArmesDAO munitionsDAO = new ImpleArmesDAO();


        Text txt4 = new Text("Saisir l'identification: nom || categorie || type");
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


             //Verification : si id existe deja
             for (Armes arm : vecarmes) {

             if (Objects.equals(identification , arm.getIdentification())) {


             ArmesDAO.RechercherArmes(identification,quantite);



             Text supp = new Text("Une arme d'identification : "+identification+" a bien été trouvée");
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

            Button re = new Button("Rechercher une munition");
            re.setLayoutX(580);
            re.setLayoutY(300);

            ajt.setOnAction(actionEvent -> {

                AjoutMunitions(vecmunitions);

            });

            sup.setOnAction(actionEvent -> {

                SupprimerMunitions(vecmunitions);

            });

            aff.setOnAction(actionEvent -> {

                Munitionsaffich(vecmunitions);

            });

            re.setOnAction(actionEvent -> {

                RechercherMunitions(vecmunitions);
            });


            pane.getChildren().addAll(sup,ajt,aff,re);


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
    public void RechercherMunitions(ArrayList<Munitions>vecmunitions)
    {

        Pane pane = new Pane();
        Stage stage = new Stage();

        Text txt1 = new Text("Recherche d'une munition : ");

        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        Text txt4 = new Text("Saisir l'identification: nom || categorie || type");
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


 //Verification : si id existe deja
 for (Munitions muni : vecmunitions) {

 if (Objects.equals(identification , muni.getIdentification())) {


 MunitionsDAO.GererStockMunition(identification,quantite);



 Text supp = new Text("Une munition d'identification : "+identification+" a bien été trouvée");
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


                    Text supp = new Text("Munition :\n" + "identification : " + muni.getIndentification() + "\ncategorie : " + muni.getCategorie() + "\nprix unique : " + muni.getPrix_unique()+ "\nprix vrac: " + muni.getPrix_vrac() + "\nreduction : " + muni.getReduction()+ "\ncalibre : " + muni.getCalibre()+ "\nquantite : " + muni.getQuantite()+ "\nnom: " + muni.getNom() );
                    supp.setLayoutX(90);
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


        Munitions muni=new Munitions();

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

        /**Catégorie Bou C**/
        Button b = new Button("B");
        b.setLayoutX(90);
        b.setLayoutY(160);

        Button c = new Button("C");
        c.setLayoutX(150);
        c.setLayoutY(160);

        b.setOnAction(actionEvent -> {

            muni.setCategorie("B");

        });

        c.setOnAction(actionEvent -> {

            muni.setCategorie("C");

        });


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

        /**Reduction**/
        Text red = new Text("Saisir si une réduction est appliquée :  ");
        red.setLayoutX(90);
        red.setLayoutY(450);


        Button oui = new Button("OUI");
        oui.setLayoutX(90);
        oui.setLayoutY(460);

        Button non = new Button("NON");
        non.setLayoutX(130);
        non.setLayoutY(460);

        oui.setOnAction(actionEvent -> {

            muni.setReduction(true);

        });

        non.setOnAction(actionEvent -> {

            muni.setReduction(false);

        });

        Text qt = new Text("Saisir la quantite");
        qt.setLayoutX(90);
        qt.setLayoutY(510);

        TextField quant = new TextField();
        quant.setLayoutX(90);
        quant.setLayoutY(520);

        Button ajt = new Button("Valider");
        ajt.setLayoutX(400);
        ajt.setLayoutY(300);


        ImpleMunitionsDAO munitionsDAO = new ImpleMunitionsDAO();


        pane.getChildren().addAll(cal,idTF,prvc,prixvrac,prix,no,qt,quant,ajt,ident,CAT,pr,nm,cl,red,oui,non,b,c);


        ajt.setOnAction(actionEvent -> {

            String identification,categorie, nom;
            double prix_unique,prix_vrac, calibre;
            int quantite,nb_vente;

            /**Quantite **/
            do {
                quantite= Integer.valueOf(quant.getText());

                muni.setQuantite(quantite);

            } while (quantite <0 );


            muni.setIndentification( String.valueOf(idTF.getText()));


            /**Prix **/
            do {
                prix_unique = Integer.valueOf(prix.getText());
                muni.setPrix_unique(prix_unique);

            } while (prix_unique <=0 );

            /**Prix **/
            do {
                prix_vrac = Integer.valueOf(prixvrac.getText());

                muni.setPrix_vrac(prix_vrac);

            } while (prix_unique <=0 );

            muni.setNom ( no.getText());


            /**calibre **/
            do {
                calibre = Integer.valueOf(cal.getText());
                muni.setCalibre(calibre);

            } while (calibre <=0 );


            vecmunitions.add(muni);


            try {

                munitionsDAO.ajouter(muni);


                if (muni != null) {

                    Text supp = new Text("Munition :\n" + "identification : " + muni.getIndentification() + "\ncategorie : " + muni.getCategorie() + "\nprix unique : " + muni.getPrix_unique()+ "\nprix vrac: " + muni.getPrix_vrac() + "\nreduction : " + muni.getReduction()+ "\ncalibre : " + muni.getCalibre()+ "\nquantite : " + muni.getQuantite()+ "\nnom: " + muni.getNom() );
                    supp.setLayoutX(90);
                    supp.setLayoutY(300);
                    pane.getChildren().add(supp);


                }

            } catch (SQLException e) {

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



