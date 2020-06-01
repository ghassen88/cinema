package com.example.cinema1.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Place implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double logitude,latidude,altidude;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy = "place")
	private Collection<Ticket> tickets;
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Place(int numero, double logitude, double latidude, double altidude, Salle salle,
			Collection<Ticket> tickets) {
		super();
		this.numero = numero;
		this.logitude = logitude;
		this.latidude = latidude;
		this.altidude = altidude;
		this.salle = salle;
		this.tickets = tickets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getLogitude() {
		return logitude;
	}
	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}
	public double getLatidude() {
		return latidude;
	}
	public void setLatidude(double latidude) {
		this.latidude = latidude;
	}
	public double getAltidude() {
		return altidude;
	}
	public void setAltidude(double altidude) {
		this.altidude = altidude;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Collection<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
	

}
