package com.example.carparking.service.impl;

import com.example.carparking.model.ParkingLot;
import com.example.carparking.repository.ParkingLotRepository;
import com.example.carparking.service.ParkingLotService;
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
    @Override
    public Optional addParkingLot(ParkingLot parkingLot) {
        return Optional.of(repository.save(parkingLot));
    }

    @Override
    public Collection<ParkingLot> finAll(int pageNo, int record, String property) {
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));

        return repository.findAll(pageable).stream().collect(Collectors.toList());
    }
}
