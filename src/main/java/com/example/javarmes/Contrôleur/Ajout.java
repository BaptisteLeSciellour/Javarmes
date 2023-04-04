package com.example.javarmes.Contrôleur;
import com.example.javarmes.Model.Articles.Article;
import com.example.javarmes.Model.Articles.CategorieB;
import com.example.javarmes.Model.Articles.CategorieC;


public class Ajout {

    public void AjoutArme(String a)
    {
        switch(a)
        {
            case("Chasse"):
                System.out.print("création d'une arme de chasse");
                Article A = new CategorieC();
                break;

            case("Assaut"):
                System.out.print("création d'une arme d'assaut");
                CategorieB B = new CategorieB();
                break;

            /**case("Poing"):
                System.out.print("création d'une arme de poing");
                Poing C = new Poing();**/

            /** Il faudra surement faire un case d'un mot donnée pour sortir de la fonction et passer toute cette fonction
             en while **/

            default: System.out.print("Nous n'avons pu trouver votre recherche");

        }
    }
}
