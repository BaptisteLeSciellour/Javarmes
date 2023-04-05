package com.example.javarmes.Model.Articles;
public class Munitions extends Article {

    protected double prix_vrac;

    public Munitions(String identification, String categorie, String nom, float prix_unique, double calibre, double prix_vrac) {
        super(identification, categorie, nom, prix_unique, calibre);
        this.prix_vrac = prix_vrac;
    }

    public double getPrix_vrac() {
        return prix_vrac;
    }

    public void setPrix_vrac(double prix_vrac) {
        this.prix_vrac = prix_vrac;
    }
}

