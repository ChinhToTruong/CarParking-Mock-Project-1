package com.example.carparking.controller;

import com.example.carparking.dto.ResponseDto;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.service.ParkingLotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    @Autowired
    private ParkingLotService service;
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody ParkingLot parkingLot){
        return ResponseDto.build()
                .withData(service.addParkingLot(parkingLot))
                .withSuccess(true)
                .withCode(200)
                .toEntity();
    }

    @GetMapping("/all")
    public ResponseEntity findAll(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("record") int record,
            @RequestParam(value = "sortBy") String property
    ){
        return ResponseEntity.ok(service.finAll(pageNo, record, property));
    }
}
