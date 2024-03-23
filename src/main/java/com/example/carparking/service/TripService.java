package com.example.carparking.service;

import com.example.carparking.dto.TripDto;
import com.example.carparking.model.Trip;

import java.util.Collection;
import java.util.Optional;

public interface TripService {

    Optional addTrip(Trip trip);

    Collection<TripDto> finAll(int pageNo, int record, String property);
}
