package com.example.javarmes.Model.Panier;

public class Panier {
    public int id_panier; /**clé primaire**/
    public String id_arme;/**clé étrangère pour arme**/
    public String id_munition; /** clé étrangère pour munition**/

    public int qte;
    public String nom_article;
    public double prix_unique;
    public double prix_total;
    public String type_article;
    public int reduction;
    /** Getter and Setter **/

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public String getId_arme() {
        return id_arme;
    }

    public void setId_arme(String id_arme) {
        this.id_arme = id_arme;
    }

    public String getId_munition() {
        return id_munition;
    }

    public void setId_munition(String id_munition) {
        this.id_munition = id_munition;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNom_article() {
        return nom_article;
    }

    public double getPrix_unique() {
        return prix_unique;
    }

    public void setPrix_unique(double prix_unique) {
        this.prix_unique = prix_unique;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getType_article() {
        return type_article;
    }

    public void setType_article(String type_article) {
        this.type_article = type_article;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Panier(int id_panier,String type_article, String id_arme, String id_munition, int qte, String nom_article, double prix_unique, double prix_total, int reduction) {
        this.id_panier = id_panier;
        this.type_article = type_article ;
        this.id_arme= id_arme;
        this.id_munition=id_munition;
        this.qte = qte;
        this.nom_article = nom_article;
        this.prix_unique = prix_unique ;
        this.prix_total=prix_total;
        this.reduction = reduction ;
    }
}
