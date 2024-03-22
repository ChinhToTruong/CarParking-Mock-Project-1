package com.example.carparking.service.impl;

import com.example.carparking.dto.TicketDto;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.model.Ticket;
import com.example.carparking.model.Trip;
import com.example.carparking.repository.CarRepository;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.repository.TicketRepository;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.TicketService;
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
    @Override
    public Collection<Ticket> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));
        return repository.findAll(pageable).stream().collect(Collectors.toList());
    }

    @Override
    public Optional addTicket(TicketDto ticketDto) {
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
