package com.example.carparking.service.impl;

import com.example.carparking.dto.TripDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.BookingOffice;
import com.example.carparking.model.Ticket;
import com.example.carparking.model.Trip;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.TripService;
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
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    @Autowired
    private ObjectValidator<Trip> validator;
    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional addTrip(Trip trip) {
        validator.validate(trip);
        return Optional.of(tripRepository.save(trip));
    }

    @Override
    public Collection<TripDto> finAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        var tripList = tripRepository.findAll(pageable).stream().toList();

        var tripDtoList = tripList.stream().map(
                trip -> TripDto.builder()
                        .bookedTicketNumber(trip.getBookedTicketNumber())
                        .driver(trip.getDriver())
                        .destination(trip.getDestination())
                        .carType(trip.getCarType())
                        .maximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber())
                        .departureDate(trip.getDepartureDate())
                        .departureTime(trip.getDepartureTime())
                        .tickets(trip.getTickets().stream().map(Ticket::getId).toList())
                        .bookingOffices(trip.getBookingOffices().stream().map(BookingOffice::getId).toList())
                        .build()
        ).collect(Collectors.toList());

        return tripDtoList;
    }
}
