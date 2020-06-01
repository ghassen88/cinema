package com.example.cinema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cinema1.entites.Ville;

@RepositoryRestResource
public interface VilleRepository  extends JpaRepository<Ville, Long>{

}
