package com.example.javarmes.Model.Articles;

public class CategorieC extends Article {

    public CategorieC(char categorie, String nom, float prix_unique, double calibre) {
        super(categorie, nom, prix_unique, calibre);
    }

    public void creation(String a, int b , double c)
    {
        System.out.println("Vous achetez une arme de chasse ");
    }
}
