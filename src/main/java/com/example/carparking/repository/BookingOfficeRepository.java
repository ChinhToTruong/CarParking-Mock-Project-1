package com.example.carparking.repository;

import com.example.carparking.model.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
    @Query(value = "select bo from BookingOffice bo where bo.id = ?1")
    Collection<BookingOffice> findBookingOfficeById(Long id);
}
