package com.example.cinema1.entites;

import java.util.Collection;

import javax.persistence.*;

import lombok.*;


@Entity


public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude,latitude,altitude;
	private int nombresalles;
	@OneToMany(mappedBy = "cinema")
	private Collection<Salle> salles;
	@ManyToOne
	private Ville ville;
	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cinema(String name, double longitude, double latitude, double altitude, int nombresalles,
			Collection<Salle> salles, Ville ville) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.nombresalles = nombresalles;
		this.salles = salles;
		this.ville = ville;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public int getNombresalles() {
		return nombresalles;
	}
	public void setNombresalles(int nombresalles) {
		this.nombresalles = nombresalles;
	}
	public Collection<Salle> getSalles() {
		return salles;
	}
	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	

}
