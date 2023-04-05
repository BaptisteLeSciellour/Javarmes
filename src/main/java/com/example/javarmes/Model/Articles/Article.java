package com.example.javarmes.Model.Articles;
import java.lang.*;
public abstract class Article { /** il faut se demander si nous plaçons la class produit comme une abstraite ou non afin d'avoir, si oui,
 une possibilités de crées des catégories une peux plus précise ( alimentaire , santé, ... ) ou alors on place tout dans la même
 classe mais on fait le changement sur la série d'authentification**/
    /**Attributs*/
    protected double prix_unique;
    protected int quantite;
    protected String identification; /** à savoir comment on la génère **/

    protected float reduction;
    protected String nom;
    protected String categorie ;
    protected double calibre;
    protected char permis;

    /**Constructeur article pour client**/
    public Article(String identification, String categorie, String nom, double prix_unique, double calibre )
    {
        this.identification = identification;
        this.categorie = categorie;
        this.nom= nom;
        this.prix_unique = prix_unique;
        this.quantite = quantite;
        this.calibre = calibre;
    }
    /** Constructeur Article pour employé **/
    public Article(String identification, String categorie, String nom, double prix_unique,int quantite, double calibre ) {
        this.identification = identification;
        this.categorie = categorie;
        this.nom= nom;
        this.prix_unique = prix_unique;
        this.quantite = quantite;
        this.calibre = calibre;
    }


    public char getPermis() {
        return permis;
    }

    public void setPermis(char permis) {
        this.permis = permis;
    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIndentification() {
        return identification;
    }

    public void setIndentification(String indentification) {
        this.identification = indentification;
    }


    public int getQuantite() {
        return quantite;
    }

    public double getPrix_unique() {
        return prix_unique;
    }

    public void setPrix_unique(double prix_unique) {
        this.prix_unique = prix_unique;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public Article() {
    }

    public void ToString() {}
    } /** à savoir comment on la génère **/


