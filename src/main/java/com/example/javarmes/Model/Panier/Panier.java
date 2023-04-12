package com.example.javarmes.Model.Panier;

public class Panier {
    public int id_panier;
    public int id_client;
    public int id_article;

    public int qte;
    public String nom_article;
    public double prix;
    public String type_article;
    public int reduction;

    /** Getter and Setter **/

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_arme(int is_article) {
        this.id_article = id_article;
    }


    public int getQte_arme() {
        return qte;
    }

    public void setQte_arme(int qte_arme) {
        this.qte = qte;
    }


    public String getNom_arme() {
        return nom_article;
    }

    public void setNom_arme(String nom_arme) {
        this.nom_article = nom_article;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type_article;
    }

    public void setType(String type) {
        this.type_article = type_article;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Panier(int id_panier, int id_article, int qte, String nom_article, double prix, String type, int reduction) {
        this.id_panier = id_panier;
        this.id_article = id_article;
        this.qte = qte;
        this.nom_article = nom_article;
        this.prix = prix ;
        this.type_article = type_article ;
        this.reduction = reduction ;
    }
}
