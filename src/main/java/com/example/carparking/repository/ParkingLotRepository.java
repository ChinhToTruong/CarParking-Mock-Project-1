package com.example.carparking.repository;

import com.example.carparking.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    @Query(value = "select pl from ParkingLot pl where pl.id = ?1")
    Collection<ParkingLot> findParkingLotById(Long id);
}
