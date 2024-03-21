package com.example.carparking.repository;

import com.example.carparking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select t from Ticket t where t.id = ?1")
    Collection<Ticket> findTicketById(Long id);
}
