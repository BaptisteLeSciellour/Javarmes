package com.example.javarmes.Model.Utilisateurs;

public class Employes extends Personnes{
    String prenom;
    String nom;
    int id;

    public Employes(String c, String b) {
        this.nom = c;
        this.prenom = b;
    }

    public Employes(int a, String b, String c) {
        this.id = a;
        this.nom = b;
        this.prenom = c;
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
        System.out.print("Cet employé ce nomme : " + this.nom + " " + this.prenom);
    }
}
