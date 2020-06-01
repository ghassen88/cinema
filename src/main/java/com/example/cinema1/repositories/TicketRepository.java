package com.example.cinema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cinema1.entites.Ticket;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
