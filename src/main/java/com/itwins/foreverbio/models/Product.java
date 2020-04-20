package com.itwins.foreverbio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	private int id;
	@Column(name = "id_cat")
	private int idCat;
	private String nom;
	private String description;
	private String unit;
	String source;
	String etat;
	double prix;
	int qte;
	int nbVentes;
	String url;

	public Product() {
	}

	public Product(int idCat, String nom, String description, String unit, String source, String etat, double prix,
			int qte, int nbVentes, String url) {
		super();
		this.setId(id);
		this.setIdCat(idCat);
		this.setNom(nom);
		this.setDescription(description);
		this.setUnit(unit);
		this.setSource(source);
		this.setEtat(etat);
		this.setPrix(prix);
		this.setQte(qte);
		this.setNbVentes(nbVentes);
		this.setUrl(url);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	

	public int getNbVentes() {
		return nbVentes;
	}

	public void setNbVentes(int nbVentes) {
		this.nbVentes = nbVentes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", idCat=" + idCat + ", nom=" + nom + ", description=" + description + ", unit="
				+ unit + ", source=" + source + ", etat=" + etat + ", prix=" + prix + ", qte=" + qte + ", nbVentes="
				+ nbVentes + ", url=" + url + "]";

	}

}
