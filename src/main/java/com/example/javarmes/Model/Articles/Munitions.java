package com.example.javarmes.Model.Articles;
public class Munitions extends Article {
    double prix;
    int quantite;
    String nom;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIndentification() {
        return indentification;
    }

    public void setIndentification(String indentification) {
        this.indentification = indentification;
    }

    String indentification;

    public Munitions(String a , int b , double c) {
        nom = a;
        prix = c;
        quantite = b;
    }
}

