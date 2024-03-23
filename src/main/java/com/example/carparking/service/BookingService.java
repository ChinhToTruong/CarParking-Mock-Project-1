package com.example.carparking.service;

import com.example.carparking.dto.BookingOfficeDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.BookingOffice;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface BookingService {

    @Query(value = "select bo.*, t.* from booking_office bo inner join trip t on t.id = bo.trip_id", nativeQuery = true)
    Collection<BookingOfficeDto> findAll(int pageNo, int record, String property);
    Optional addBookingOffice(BookingOfficeRequest request) throws Exception;
}
