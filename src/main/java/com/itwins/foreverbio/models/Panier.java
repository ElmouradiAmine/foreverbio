package com.itwins.foreverbio.models;


import javax.persistence.*;

@Entity
@Table(name="panier")
public class Panier {
    @Id
    private int idUser;
    private int id;
    private String nom;
    private double prix;
    private int quantite;

    public Panier() {

    }

    public Panier(int idUser,int id, String nom, int prix, int quantite) {
        this.idUser = idUser;
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    public int getidUser() {
        return idUser;
    }

    public void setidUser(int idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getQuantite() { return quantite; }

    public void setQuantite(int quantite) { this.quantite = quantite; }

    @Override
    public String toString() {
        return "Panier{" +
                "idUser=" + idUser +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }


}
