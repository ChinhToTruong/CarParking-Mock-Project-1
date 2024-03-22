package com.example.carparking.service;

import com.example.carparking.model.ParkingLot;

import java.util.Collection;
import java.util.Optional;

public interface ParkingLotService {
    Optional addParkingLot(ParkingLot parkingLot);
    Collection<ParkingLot> finAll(int pageNo, int record, String property);
}
