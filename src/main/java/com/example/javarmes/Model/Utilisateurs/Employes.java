package com.example.javarmes.Model.Utilisateurs;

public class Employes extends Personnes{
    protected int id;

    protected String motdepasse;

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Employes(String c, String b) {
        this.nom = c;
        this.prenom = b;
    }

    public Employes(int a, String b, String c) {
        this.id = a;
        this.nom = b;
        this.prenom = c;
    }

    public Employes() {
    }

    public Employes(int Id, String Mdp) {
        this.id = Id;
        this.motdepasse = Mdp;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void ToString() {
        System.out.print("Infos employé : id: " + this.id + " nom: " + this.nom+ " prénom: " + this.prenom);
    }
}
