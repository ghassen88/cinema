package com.example.cinema1.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Seance {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date heureDebut;
	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seance(Date heureDebut) {
		super();
		this.heureDebut = heureDebut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	
	
	
	

}
