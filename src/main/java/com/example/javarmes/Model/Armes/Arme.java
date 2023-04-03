package com.example.javarmes.Model.Armes;
import java.lang.*;
public abstract class Arme { /** il faut se demander si nous plaçons la class produit comme une abstraite ou non afin d'avoir, si oui,
 une possibilités de crées des catégories une peux plus précise ( alimentaire , santé, ... ) ou alors on place tout dans la même
 classe mais on fait le changement sur la série d'authentification**/
double prix;
    int quantite;
    String nom;

    String indentification; /** à savoir comment on la génère **/

    public void creation(String a, int b , double c)
    {

    }
}
