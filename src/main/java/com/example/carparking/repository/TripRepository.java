package com.example.carparking.repository;

import com.example.carparking.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query(value = "select t from Trip t where t.id = ?1")
    Optional<Trip> findTripById(Long id);
}
