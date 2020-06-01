package com.example.cinema1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema1.entites.Film;
import com.example.cinema1.repositories.FilmRepository;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
	
	
	
	@Autowired
	FilmRepository filmRepository;
	
	@GetMapping("/listFilms")
	public List<Film> films(){
		return filmRepository.findAll();
		
	}
	
	
	
	
	

}
