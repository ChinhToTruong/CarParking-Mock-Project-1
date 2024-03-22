package com.example.carparking.service.impl;

import com.example.carparking.dto.BookingOfficeDto;
import com.example.carparking.dto.mapper.ObjectMapper;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.BookingOffice;
import com.example.carparking.model.Trip;
import com.example.carparking.repository.BookingOfficeRepository;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingOfficeRepository bookingOfficeRepository;
    private final TripRepository tripRepository;

    private ObjectMapper<BookingOffice, BookingOfficeDto> bookingOfficeMapper;



    @Autowired
    public void setFeatures(ObjectMapper<BookingOffice, BookingOfficeDto> bookingOfficeMapper){
        this.bookingOfficeMapper = bookingOfficeMapper;
    }

    @Autowired
    public BookingServiceImpl(BookingOfficeRepository bookingOfficeRepository, TripRepository tripRepository){
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripRepository = tripRepository;
    }
    @Override
    public Collection<BookingOffice> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        var bookingOffices = bookingOfficeRepository.findAll(pageable);
        return bookingOffices.stream()
                .collect(Collectors.toList());
    }

    @Override
    public Optional addBookingOffice(BookingOfficeRequest request) throws Exception {
        Trip trip = tripRepository.findTripById(request.getTripId()).orElseThrow();

        var bookingOffice = BookingOffice.builder()
                .officeName(request.getOfficeName())
                .officePhone(request.getOfficePhone())
                .officePlace(request.getOfficePlace())
                .officePrice(request.getOfficePrice())
                .startContractDeadline(request.getStartContractDeadline())
                .endContractDeadline(request.getEndContractDeadline())
                .trip(trip)
                .build();
        return Optional.of(bookingOfficeRepository.save(bookingOffice));
    }
}
