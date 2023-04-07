package com.example.javarmes.Model.Articles;
public class Munitions extends Article {

    protected double prix_vrac;

    public Munitions(String identification, String categorie, String nom, double prix_unique,int quantite, double calibre,boolean reduction, double prix_vrac) {
        super(identification, categorie, nom, prix_unique, quantite, calibre, reduction);
        this.prix_vrac = prix_vrac;
    }

    public double getPrix_vrac() {
        return prix_vrac;
    }

    public void setPrix_vrac(double prix_vrac) {
        this.prix_vrac = prix_vrac;
    }

    @Override
    public String toString(){
        return '\''+"{"+ "identification= " + identification +'\''+ ", categorie= "+categorie+ '\''
                + ", nom= "+nom + '\''+ ", prix unique= "+ prix_unique + '\''+ ", quantite= "+quantite + '\''+ ", calibre= "+calibre + ", reduction= "+reduction + ", prix_vrac= "+prix_vrac + '}' + '\'';
    }
}

