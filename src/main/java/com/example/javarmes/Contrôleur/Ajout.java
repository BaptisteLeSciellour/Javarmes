package com.example.javarmes.Contrôleur;
import org.example.Modèle.Armes.Arme;
import org.example.Modèle.Armes.Assaut;
import org.example.Modèle.Armes.Chasse;
import org.example.Modèle.Armes.Poing;


public class Ajout {

    public void AjoutArme(String a)
    {
        switch(a)
        {
            case("Chasse"):
                System.out.print("création d'une arme de chasse");
                Arme A = new Chasse();
                break;

            case("Assaut"):
                System.out.print("création d'une arme d'assaut");
                Assaut B = new Assaut();
                break;

            case("Poing"):
                System.out.print("création d'une arme de poing");
                Poing C = new Poing();

            /** Il faudra surement faire un case d'un mot donnée pour sortir de la fonction et passer toute cette fonction
             en while **/

            default: System.out.print("Nous n'avons pu trouver votre recherche");

        }
    }
}
