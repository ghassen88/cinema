package com.example.cinema1.entites;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "categorie")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Film> films;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String name, Collection<Film> films) {
		super();
		this.name = name;
		this.films = films;
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
	public Collection<Film> getFilms() {
		return films;
	}
	public void setFilms(Collection<Film> films) {
		this.films = films;
	}
	

}
