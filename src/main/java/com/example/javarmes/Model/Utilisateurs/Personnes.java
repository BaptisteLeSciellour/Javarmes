package com.example.javarmes.Model.Utilisateurs;

public abstract  class Personnes {
    protected String nom;
    protected String prenom;
    protected int immatriculation;
    protected String DateDeNaissance;

    ///int NombreDeVente;

    public Personnes(String a , String b)
    {
        prenom = a;
        nom = b;
    }

    public Personnes()
    {

    }

    public void setNom(String a) {
        this.nom = a;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getDateDeNaissance() {
        return DateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        DateDeNaissance = dateDeNaissance;
    }

    public void setPrenom(String a){
        this.prenom = a;
    }
     public void ToString(){}
}
