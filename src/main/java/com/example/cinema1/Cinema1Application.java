package com.example.cinema1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cinema1.repositories.SalleRepository;
import com.example.cinema1.service.ICinemaIntService;

@SpringBootApplication
public class Cinema1Application implements CommandLineRunner {
	
	@Autowired
	private ICinemaIntService iCinemaIntService;

	public static void main(String[] args) {
		SpringApplication.run(Cinema1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		iCinemaIntService.initVilles();
		iCinemaIntService.initCinemas();
		iCinemaIntService.initSalles();
		iCinemaIntService.initPalces();
		iCinemaIntService.initSeances();
		iCinemaIntService.initCategory();
		iCinemaIntService.initFilms();
		iCinemaIntService.initProjections();
		iCinemaIntService.initTicketss();;
		
	}

}
