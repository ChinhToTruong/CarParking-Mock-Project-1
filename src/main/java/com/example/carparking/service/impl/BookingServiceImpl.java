package com.example.carparking.service.impl;

import com.example.carparking.dto.BookingOfficeDto;
import com.example.carparking.dto.mapper.ObjectMapper;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.model.BookingOffice;
import com.example.carparking.model.Trip;
import com.example.carparking.repository.BookingOfficeRepository;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.BookingService;
import com.example.carparking.validator.ObjectValidator;
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

    private ObjectValidator<BookingOfficeRequest> validator;



    @Autowired
    public void setFeatures(ObjectValidator<BookingOfficeRequest> validator){
        this.validator = validator;
    }

    @Autowired
    public BookingServiceImpl(BookingOfficeRepository bookingOfficeRepository, TripRepository tripRepository){
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripRepository = tripRepository;
    }
    @Override
    public Collection<BookingOfficeDto> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        var bookingOffices = bookingOfficeRepository.findAll(pageable);
        return bookingOffices.stream()
                .map(bo -> BookingOfficeDto.builder()
                        .officePlace(bo.getOfficePlace())
                        .officePrice(bo.getOfficePrice())
                        .officePhone(bo.getOfficePhone())
                        .startContractDeadline(bo.getStartContractDeadline())
                        .endContractDeadline(bo.getEndContractDeadline())
                        .trip(bo.getTrip().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Optional addBookingOffice(BookingOfficeRequest request) throws Exception {
        validator.validate(request);

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
