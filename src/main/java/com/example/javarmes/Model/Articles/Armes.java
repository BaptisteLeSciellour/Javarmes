package com.example.javarmes.Model.Articles;

public class Armes extends Article {

    public Armes(String identification, String categorie, String nom, double prix_unique, int quantite, double calibre, boolean reduction) {
        super(identification, categorie, nom, prix_unique, quantite, calibre,reduction);
    }

    public Armes(String identification, String categorie, String nom, double prix_unique, double calibre) {
        super(identification, categorie, nom, prix_unique, calibre);
    }
    @Override
    public String toString(){
        return '\''+"{"+ "identification= " + identification +'\''+ ", categorie= "+categorie+ '\''
                + ", nom= "+nom + '\''+ ", prix unique= "+ prix_unique + '\''+ ", quantite= "+quantite + '\''+ ", calibre= "+calibre + ", reduction= "+reduction + '}'+ '\'';
    }
}
