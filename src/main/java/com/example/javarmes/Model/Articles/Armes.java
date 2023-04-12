package com.example.javarmes.Model.Articles;

public class Armes extends Article {

    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Armes(String identification,String type, String categorie, String nom, double prix_unique, int quantite, double calibre, boolean reduction, int nb_vente) {
        super(identification, categorie, nom, prix_unique, quantite, calibre,reduction, nb_vente);
        this.type = type;
    }
    public Armes(String identification,String type, String categorie, String nom, double prix_unique, int quantite, double calibre, boolean reduction) {
        super(identification, categorie, nom, prix_unique, quantite, calibre,reduction);
        this.type = type;
    }
    public Armes(){}

    public Armes(String identification, String categorie, String nom, double prix_unique, double calibre) {
        super(identification, categorie, nom, prix_unique, calibre);
    }
    @Override
    public String toString(){
        return '\''+"{"+ "identification= " + identification +'\''+ ", categorie= "+categorie+ '\''
                + ", nom= "+nom + '\''+ ", prix unique= "+ prix_unique + '\''+ ", quantite= "+quantite + '\''+ ", calibre= "+calibre + ", reduction= "+reduction + ", nombre de ventes = "+ nb_vente + '}'+ '\'';
    }
}