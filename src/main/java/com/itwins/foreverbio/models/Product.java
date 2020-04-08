package com.itwins.foreverbio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	int id;
	String nom;
	String description;
	String source;
	String etat;
	double prix;
	int qte;
	int idCat;
	
	public Product() {
		
	}

	public Product(int id, String nom, String description, String source, String etat, double prix, int qte, int idCat) {
		super();
		this.id=id;
		this.setNom(nom);
		this.setDescription(description);
		this.setSource(source);
		this.setEtat(etat);
		this.setPrix(prix);
		this.setQte(qte);
		this.setIdCat(idCat);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", description=" + description + ", source=" + source + ", etat="
				+ etat + ", prix=" + prix + ", qte=" + qte + "]";
	}
	
	
	
	
	

}
