package com.example.carparking.controller;

import com.example.carparking.dto.CarDto;
import com.example.carparking.dto.ResponseDto;
import com.example.carparking.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody CarDto carDto){
        return ResponseDto.build()
                .withData(carService.addCar(carDto))
                .toEntity();
    }


    @GetMapping("/all")
    public ResponseEntity getAll(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("record") int record,
            @RequestParam(value = "sortBy") String property
    ){
        return ResponseEntity.ok(carService.findAll(pageNo, record, property));
    }
}
