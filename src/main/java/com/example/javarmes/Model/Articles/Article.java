package com.example.javarmes.Model.Articles;
import java.lang.*;
public abstract class Article { /** il faut se demander si nous plaçons la class produit comme une abstraite ou non afin d'avoir, si oui,
 une possibilités de crées des catégories une peux plus précise ( alimentaire , santé, ... ) ou alors on place tout dans la même
 classe mais on fait le changement sur la série d'authentification**/
    /**Attributs*/
    protected float prix_unique;
    protected float prix_vrac;
    protected int quantite;

    protected String indentification; /** à savoir comment on la génère **/

    protected float reduction;
    protected String nom;
    protected char categorie ;
    protected double calibre;
    protected char permis;

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

    public char getCategorie() {
        return categorie;
    }

    public void setCategorie(char categorie) {
        this.categorie = categorie;
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


    public int getQuantite() {
        return quantite;
    }

    public float getPrix_unique() {
        return prix_unique;
    }

    public void setPrix_unique(float prix_unique) {
        this.prix_unique = prix_unique;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix_vrac() {
        return prix_vrac;
    }

    public void setPrix_vrac(float prix_vrac) {
        this.prix_vrac = prix_vrac;
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


