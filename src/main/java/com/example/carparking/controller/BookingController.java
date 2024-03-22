package com.example.carparking.controller;

import com.example.carparking.dto.BookingOfficeDto;
import com.example.carparking.dto.ResponseDto;
import com.example.carparking.dto.request.BookingOfficeRequest;
import com.example.carparking.service.BookingService;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-office")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllBookingOffices(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("record") int record,
            @RequestParam(value = "sortBy") String property
    ){
        return ResponseEntity.ok(bookingService.findAll(pageNo, record, property));
    }

    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addBookingOffice(@RequestBody BookingOfficeRequest request){
        return ResponseDto.build()
                .withData(bookingService.addBookingOffice(request))
                .withSuccess(true)
                .withCode(200)
                .toEntity();
    }
}
