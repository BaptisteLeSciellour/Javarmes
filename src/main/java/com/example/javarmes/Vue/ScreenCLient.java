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
import java.util.Objects;
import java.util.Random;


public class ScreenCLient {
    public void creationClient(ArrayList<Client>vecclient,Text txxt)
    {
        Stage stage = new Stage();
        Pane panne = new Pane();

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

        if(txxt!=null)
        {
            txxt.setLayoutX(90);
            txxt.setLayoutY(100);
            panne.getChildren().add(txxt);
        }

        mailTF.clear();
        mdpTF.clear();

        Button saisie = new Button("Saisie des données");

        /**!!!!!!!!!!!!!!!!!!**/

        saisie.setOnAction(event->{
            boolean verif = true;
            String mail;
            String mdp;
            int id;
            boolean pass3;
            do {
                 pass3=true;
                 mail = mailTF.getText();
                 mdp = mdpTF.getText();

                    for (Client cli : vecclient) {
                        System.out.println(cli.getMail()+"//"+mail);
                        System.out.println("///");

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
                    txt8.setLayoutX(90);
                    txt8.setLayoutY(90);

                    Text txt2 = new Text("mail : "+mail);
                    txt2.setLayoutX(90);
                    txt2.setLayoutY(150);

                    Text txt3 = new Text("MDP : "+mdp);
                    txt3.setLayoutX(90);
                    txt3.setLayoutY(200);

                    Text ID = new Text("ID : "+id);
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

                Text exception = new Text("Erreur"); /** il va falloir creer un écran d'erreur universel **/
                exception.setLayoutX(90);
                exception.setLayoutY(290);
                pane.getChildren().add(exception);

            }
            ///ArrayList<Client> vecclient = new ArrayList<Client>();
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

        panne.getChildren().addAll(saisie,mailTF,mdpTF,txt1,txt4,txt6);
        Scene settle = new Scene(panne,520,520);

        stage.setScene(settle);
        stage.show();

    }

    public void InscriptionClient(Text txxt,ArrayList<Client>vecclient) /** Nous avons un second écran qui apparait**/
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

        Button bbtn2 = new Button("MAJ");
        bbtn2.setLayoutX(240);
        bbtn2.setLayoutY(400);

        bbtn.setOnAction(actionEvent -> {
            creationClient(vecclient,txxt); /** ici on appelle l'écran que nous allons utiliser**/
            settle.close();
        });

        bbtn2.setOnAction(actionEvent -> {
            MAJClient(vecclient);
        });
        pannne.getChildren().addAll(bbtn,bbtn2,txt);

        Scene sceene = new Scene(pannne, 320, 540);

        settle.setScene(sceene);
        settle.setX(0);
        settle.setY(0);
        settle.show();
    }

    public void MAJClient(ArrayList<Client>vecclient){
        Pane pannne = new Pane();
        Stage settle = new Stage();

        Text txt = new Text("MAJ client");
        txt.setLayoutX(90);
        txt.setLayoutY(150);

        Text txt4 = new Text("Saisir le mail:");
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

            for(Client e : vecclient)
            {
                if(Objects.equals(e.getMail(),mail))
                {
                    Text txt1 = new Text("Création du client : ");
                    ImpleClientDAO clientDAO = new ImpleClientDAO();
                    Text nvmail = new Text("Saisir le nouveau mail:");
                    nvmail.setLayoutX(90);
                    nvmail.setLayoutY(290);

                    TextField nvxmailTF = new TextField();
                    nvxmailTF.setLayoutX(90);
                    nvxmailTF.setLayoutY(300);

                    Text nvmdp = new Text("Saisir le nouveau MDP:");
                    nvmdp.setLayoutX(90);
                    nvmdp.setLayoutY(340);

                    TextField mdpTF = new TextField();
                    mdpTF.setLayoutX(90); // ici on les décales
                    mdpTF.setLayoutY(350); // ici on remonte les cases


                    Button saisie = new Button("Saisie");
                    saisie.setLayoutX(330);
                    saisie.setLayoutY(400);
                    n.getChildren().addAll(nvmdp,nvmail,nvxmailTF,mdpTF,saisie);

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

}
