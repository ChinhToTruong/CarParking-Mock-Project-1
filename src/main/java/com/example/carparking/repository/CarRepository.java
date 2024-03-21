package com.example.carparking.repository;

import com.example.carparking.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "select c from Car c where c.id = ?1")
    Collection<Car> findCarById(Long id);
}
