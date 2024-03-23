package com.example.carparking.service.impl;

import com.example.carparking.dto.ParkingLotDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.model.Car;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.service.ParkingLotService;
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
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    private ParkingLotRepository repository;
    @Autowired
    private ObjectValidator<ParkingLot> validator;
    @Override
    public Optional addParkingLot(ParkingLot parkingLot) {
        validator.validate(parkingLot);
        return Optional.of(repository.save(parkingLot));
    }

    @Override
    public Collection<ParkingLotDto> finAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        var list =  repository.findAll(pageable).stream().collect(Collectors.toList());

        var listDto = list.stream()
                .map(pk -> ParkingLotDto.builder()
                        .id(pk.getId())
                        .parkingArea(pk.getParkingArea())
                        .parkingName(pk.getParkingName())
                        .parkingPrice(pk.getParkingPrice())
                        .parkingStatus(pk.getParkingStatus())
                        .parkingPlace(pk.getParkingPlace())
                        .cars(pk.getCars().stream().map(Car::getId).toList())
                        .build())
                .collect(Collectors.toList());

        return listDto;
    }
}
