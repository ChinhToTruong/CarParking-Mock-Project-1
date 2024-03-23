package com.example.carparking.service.impl;

import com.example.carparking.dto.CarDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.model.Ticket;
import com.example.carparking.repository.CarRepository;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.service.CarService;
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
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ObjectValidator<CarDto> validator;

    @Override
    public Optional addCar(CarDto carDto) {
        validator.validate(carDto);
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
    public Collection<CarDto> findAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));
        var carList = repository.findAll(pageable).stream().collect(Collectors.toList());
        Collection<CarDto> carDtoList = carList.stream().map(car ->
             CarDto.builder()
                    .carType(car.getCarType())
                            .tickets(car.getTickets().stream().map(Ticket::getId).toList())
                    .carColor(car.getCarColor())
                    .licensePlate(car.getLicensePlate())
                    .company(car.getCompany())
                    .parkingLot(car.getParkingLot().getId())
                    .build()
        ).collect(Collectors.toList());

        return carDtoList;
    }
}
