package com.example.carparking.controller;

import com.example.carparking.dto.ResponseDto;
import com.example.carparking.model.Trip;
import com.example.carparking.service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService service;

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Trip trip){
        return ResponseDto.build()
                .withSuccess(true)
                .withCode(200)
                .withData(service.addTrip(trip))
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
