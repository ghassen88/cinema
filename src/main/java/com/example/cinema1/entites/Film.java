package com.example.cinema1.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titre;
	private String description ;
	private String realisateur;
	private Date datesortie;
	private double duree;
	private String photo;
	@OneToMany(mappedBy = "film")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Projection> projections;
	@ManyToOne
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Categorie categorie;
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Film(String titre, String description, String realisateur, Date datesortie, double duree, String photo,
			Collection<Projection> projections, Categorie categorie) {
		super();
		this.titre = titre;
		this.description = description;
		this.realisateur = realisateur;
		this.datesortie = datesortie;
		this.duree = duree;
		this.photo = photo;
		this.projections = projections;
		this.categorie = categorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public Date getDatesortie() {
		return datesortie;
	}
	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Collection<Projection> getProjections() {
		return projections;
	}
	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	

}
