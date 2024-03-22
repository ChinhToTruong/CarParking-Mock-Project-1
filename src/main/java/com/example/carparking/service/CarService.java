package com.example.carparking.service;

import com.example.carparking.dto.CarDto;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;

import java.util.Collection;
import java.util.Optional;

public interface CarService {
    Optional addCar(CarDto carDto);
    Collection<Car> findAll(int pageNo, int record, String property);

}
