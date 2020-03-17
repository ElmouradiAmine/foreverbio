package com.itwins.foreverbio.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name="categorie")
public class Category {

    @Id
    private int id;
    private String nom;

    public Category(){
    }

    public Category(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public Category(Map<String,Object> categoryMap) {
        super();
        if (categoryMap.get("id") != null)

            this.id = (int )categoryMap.get("id");
        this.nom = (String) categoryMap.get("nom");

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


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nom='" + nom +"'" +
                '}';
    }
}
