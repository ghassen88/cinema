package com.example.cinema1.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema1.entites.Categorie;
import com.example.cinema1.entites.Cinema;
import com.example.cinema1.entites.Film;
import com.example.cinema1.entites.Place;
import com.example.cinema1.entites.Projection;
import com.example.cinema1.entites.Salle;
import com.example.cinema1.entites.Seance;
import com.example.cinema1.entites.Ticket;
import com.example.cinema1.entites.Ville;
import com.example.cinema1.repositories.CategorieRepository;
import com.example.cinema1.repositories.CinemaRepository;
import com.example.cinema1.repositories.FilmRepository;
import com.example.cinema1.repositories.PlaceRepository;
import com.example.cinema1.repositories.ProjectioRepository;
import com.example.cinema1.repositories.SalleRepository;
import com.example.cinema1.repositories.SeanceRepository;
import com.example.cinema1.repositories.TicketRepository;
import com.example.cinema1.repositories.VilleRepository;

@Service
@Transactional
public class CinemaIntServiceImp implements ICinemaIntService {
	@Autowired
    VilleRepository villeRepository;
	@Autowired
    CinemaRepository cinemaRepository;
	@Autowired
    SalleRepository salleRepository;
	@Autowired
    PlaceRepository placeRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	SeanceRepository seanceRepository;
	
	@Autowired
	ProjectioRepository projectionRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	
	@Override
	public void initVilles() {
    Stream.of("casablanca","marrakech","rabat","tanger").forEach(nameVille->{
    	Ville ville=new Ville();
    	ville.setName(nameVille);
    	villeRepository.save(ville);
    }
    );		
	}

	@Override
	public void initCinemas() {
   villeRepository.findAll().forEach(v->{
   Stream.of("megarama","Imax","founoun","chahrazad").forEach(
		   nameCinema->{
			   Cinema cinema= new Cinema();
			   cinema.setName(nameCinema);
			   cinema.setNombresalles(3+(int)(Math.random()*7));
			   cinema.setVille(v);
			  cinemaRepository.save(cinema);
			   
		   
		   });
  
	});
}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->
		{
			for(int i=0;i<cinema.getNombresalles();i++) {
				Salle salle =new Salle();
				salle.setName("salle" + (i+1));
				salle.setCinema(cinema);
				salle.setNombrePlace(15+(int)(Math.random()*20));
				salleRepository.save(salle);
			}
		});		
	}

	@Override
	public void initPalces() {
		salleRepository.findAll().forEach(salle->{
			for(int i=0;i<salle.getNombrePlace();i++) {
				Place place =new Place();
				place.setNumero(i+1);
				place.setSalle(salle);
				placeRepository.save(place);
				
			}
		});
 		
	}
	
	
	
	
	@Override
	public void initSeances() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.00'Z'");
		Stream.of("2008-01-29 23:15:00.00Z","2008-01-29 22:15:00.00Z","2008-01-29 21:15:00.00Z").forEach(s->{
			Seance seance =new Seance();
			try {
			seance.setHeureDebut(dateFormat.parse(s));
			seanceRepository.save(seance);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
	@Override
	public void initCategory() {
		Stream.of("histoire","action","fiction","drama").forEach(cat->{ 
			
			Categorie categorie =new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
		});
		
	}



	@Override
	public void initFilms() {
		double [] durees= new double[] {1,2,3,4};
		List<Categorie> categories =categorieRepository.findAll();
		Stream.of("game of thrones","space toon","4 seasones","4 womean").forEach(fil->{
			Film film =new Film();
			film.setTitre(fil);
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setPhoto(fil.replaceAll("", ""));
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
			
		});
		
	}

	@Override
	public void initProjections() {
		double [] prices =new double [] {30,50,70,90,100};
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					filmRepository.findAll().forEach(film->{
					seanceRepository.findAll().forEach(seance->{
						Projection projection =new Projection();
						projection.setDateProjection(new Date());
						projection.setFilm(film);
						projection.setPrix(prices[new Random().nextInt(prices.length)]);
						projection.setSalle(salle);
						projectionRepository.save(projection);
						
					
					
					});
			});
		});
		});
	});
	}


	@Override
	public void initTicketss() {
		projectionRepository.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(place->{
				Ticket ticket =new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
			
		});		
		
	}


	
}
