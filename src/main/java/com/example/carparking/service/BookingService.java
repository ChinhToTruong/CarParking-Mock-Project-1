package com.example.carparking.service;

import com.example.carparking.dto.BookingOfficeDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.BookingOffice;

import java.util.Collection;
import java.util.Optional;

public interface BookingService {
    Collection<BookingOffice> findAll(int pageNo, int record, String property);
    Optional addBookingOffice(BookingOfficeRequest request) throws Exception;
}
