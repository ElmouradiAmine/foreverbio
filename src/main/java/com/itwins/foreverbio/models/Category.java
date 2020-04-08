package com.itwins.foreverbio.models;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="categorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String image;
    private String description;


    public Category(){
    }

    public Category(String nom, String image, String description) {
        this.nom = nom;
        this.image = image;
        this.description = description;

    }

    public Category(Map<String,Object> categoryMap) {
        super();
        if (categoryMap.get("id") != null)

            this.id = Integer.parseInt((String )categoryMap.get("id"));
            this.nom = (String) categoryMap.get("nom");
            this.image = (String) categoryMap.get("image");
            this.description = (String) categoryMap.get("description");

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

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }
     public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nom='" + nom +"'" +
                '}';
    }
}
