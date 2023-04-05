package com.example.javarmes.Model.Articles;

public class Armes extends Article {

    public Armes(String identification, String categorie, String nom, double prix_unique, int quantite, double calibre) {
        super(identification, categorie, nom, prix_unique, quantite, calibre);
    }

    public Armes(String identification, String categorie, String nom, double prix_unique, double calibre) {
        super(identification, categorie, nom, prix_unique, calibre);
    }
}
