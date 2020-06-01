package com.example.cinema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema1.entites.Film;

@RepositoryRestResource
@CrossOrigin("*")

public interface FilmRepository extends JpaRepository<Film, Long>{

}
