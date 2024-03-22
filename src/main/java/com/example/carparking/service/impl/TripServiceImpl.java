package com.example.carparking.service.impl;

import com.example.carparking.model.Trip;
import com.example.carparking.repository.TripRepository;
import com.example.carparking.service.TripService;
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
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional addTrip(Trip trip) {
        return Optional.of(tripRepository.save(trip));
    }

    @Override
    public Collection<Trip> finAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        return tripRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
}
