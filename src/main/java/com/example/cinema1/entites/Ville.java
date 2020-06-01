package com.example.cinema1.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


@Entity
public class Ville implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double logitude,altitude,latidude;
	@OneToMany(mappedBy = "ville")
	private Collection<Cinema> cinemas;
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(Long id, String name, double logitude, double altitude, double latidude, Collection<Cinema> cinemas) {
		super();
		this.id = id;
		this.name = name;
		this.logitude = logitude;
		this.altitude = altitude;
		this.latidude = latidude;
		this.cinemas = cinemas;
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
	public double getLogitude() {
		return logitude;
	}
	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getLatidude() {
		return latidude;
	}
	public void setLatidude(double latidude) {
		this.latidude = latidude;
	}
	public Collection<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(Collection<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	
	
	

}
