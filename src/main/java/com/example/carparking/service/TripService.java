package com.example.carparking.service;

import com.example.carparking.model.Trip;

import java.util.Collection;
import java.util.Optional;

public interface TripService {

    Optional addTrip(Trip trip);

    Collection<Trip> finAll(int pageNo, int record, String property);
}
