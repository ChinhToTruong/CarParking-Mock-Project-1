package com.example.carparking.service.impl;

import com.example.carparking.dto.CarDto;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.repository.CarRepository;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public Optional addCar(CarDto carDto) {
        var parkingLot = parkingLotRepository.findParkingLotById(carDto.getParkingLot()).orElseThrow();

        var car = Car.builder()
                .carColor(carDto.getCarColor())
                .carType(carDto.getCarType())
                .licensePlate(carDto.getLicensePlate())
                .company(carDto.getCompany())
                .parkingLot(parkingLot)
                .build();
        return Optional.of(repository.save(car));
    }

    @Override
    public Collection<Car> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));
        return repository.findAll(pageable).stream().collect(Collectors.toList());
    }
}
