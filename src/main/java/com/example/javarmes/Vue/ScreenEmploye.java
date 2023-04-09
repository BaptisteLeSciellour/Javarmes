package com.example.javarmes.Vue;

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

    public void SuppresionEmploye(ArrayList<Employes>vecemployes)
    {
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

}
