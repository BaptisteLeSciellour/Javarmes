package com.example.javarmes.Contrôleur;

import com.example.javarmes.Model.Armes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Depart {
    public void lancement()
    {
        System.out.println("Bonjour, bienvenue sur Javarme\n");
        ArrayList<Arme> vec = new ArrayList<Arme>();

        boolean passage=false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Que souhaitez-vous faire sur notre site : \n");
            System.out.print("1-Chasse : Création d'une arme de chasse\n");
            System.out.print("2-Assaut : Création d'une arme d'assaut\n");
            System.out.print("3-Poing : Création d'une arme de poing\n");
            System.out.println("4-Precision : Creation d'une arme de précision\n");
            System.out.println("Sortie\n");

            String str = sc.nextLine();
            switch(str)
            {
                case("Chasse"):
                    System.out.print("création d'une arme de chasse");
                    Arme A = new Chasse();
                    vec.add(A);
                    break;

                case("Assaut"):
                    System.out.print("création d'une arme d'assaut");
                    Assaut B = new Assaut();
                    vec.add(B);
                    break;

                /**case("Poing"):
                    System.out.print("création d'une arme de poing");
                    Poing C = new Poing();
                    vec.add(C);

                case("Precision"):
                    System.out.println("Creation d'une arme de précision");
                    Precision D = new Precision();
                    vec.add(D);

                    /** Il faudra surement faire un case d'un mot donnée pour sortir de la fonction et passer toute cette fonction
                     en while **/

                case("Sortie"):
                {
                    System.out.println("Vous sortez de la boucle");
                    passage = true;
                }

                default: System.out.print("Nous n'avons pu accèder à votre recherche    ");
          }

        }while(!passage);

        for ( Arme a : vec)
        {
            a.ToString();
            System.out.println("\n");
        }
    }

}
