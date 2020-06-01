package com.example.cinema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.cinema1.entites.Cinema;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
