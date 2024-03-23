package com.example.carparking.service.impl;

import com.example.carparking.dto.TicketDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.model.Ticket;
import com.example.carparking.model.Trip;
import com.example.carparking.repository.CarRepository;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.repository.TicketRepository;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.TicketService;
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
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository repository;

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private ObjectValidator<TicketDto> validator;
    @Override
    public Collection<TicketDto> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));
        var ticketList = repository.findAll(pageable).stream().collect(Collectors.toList());

        var ticketDtoList = ticketList.stream()
                .map(ticket -> TicketDto.builder()
                        .customerName(ticket.getCustomerName())
                        .bookingTime(ticket.getBookingTime())
                        .licensePlate(ticket.getLicensePlate())
                        .car(ticket.getCar().getId())
                        .trip(ticket.getTrip().getId())
                        .build())
                .toList();

        return ticketDtoList;
    }

    @Override
    public Optional addTicket(TicketDto ticketDto) {
        validator.validate(ticketDto);

        var car = carRepository.findCarById(ticketDto.getCar()).orElseThrow();
        var trip = tripRepository.findTripById(ticketDto.getTrip()).orElseThrow();

        var ticket =  Ticket.builder()
                .bookingTime(ticketDto.getBookingTime())
                .car(car)
                .trip(trip)
                .customerName(ticketDto.getCustomerName())
                .licensePlate(ticketDto.getLicensePlate())
                .bookingTime(ticketDto.getBookingTime())
                .build();

        return Optional.of(repository.save(ticket));
    }

    @Override
    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }
}
