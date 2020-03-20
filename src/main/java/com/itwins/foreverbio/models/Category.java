package com.itwins.foreverbio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

@Entity

public class Category implements Serializable {

    @Id @GeneratedValue
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nom='" + nom +"'" +
                '}';
    }
}
