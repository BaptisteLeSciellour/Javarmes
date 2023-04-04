package com.example.javarmes.Model.Utilisateurs;

public class Client extends Personnes {

    /**Attributs correspondant au client*/
    protected int nb_article;

    protected String mail;

    protected String mdp;
    protected int id;

    protected int nb_commandes;

    public Client() {}
    public Client(String a , String b){
        this.mail=a;
        this.mdp=b;
    }

    public Client(int a, String b, String c){
        this.id=a;
        this.mail=b;
        this.mdp=c;
    }

    public Client(int a, String b, String c, int d){
        this.id=a;
        this.mail=b;
        this.mdp=c;
        this.nb_commandes=d;
    }

    public int getNb_article() {
        return nb_article;
    }

    public void setNb_article(int nb_article) {
        this.nb_article = nb_article;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getNb_commandes() {
        return nb_commandes;
    }

    public void setNb_commandes(int nb_commande) {
        this.nb_commandes = nb_commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void ToString(){System.out.print("Ce client se nomme : "+this.mail+" "+this.mdp);}
}
