package com.example.carparking.controller;

import com.example.carparking.dto.ResponseDto;
import com.example.carparking.dto.TicketDto;
import com.example.carparking.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody TicketDto dto){
        return ResponseDto.build()
                .withData(service.addTicket(dto))
                .toEntity();
    }


    @GetMapping("/all")
    public ResponseEntity findAll(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("record") int record,
            @RequestParam(value = "sortBy") String property
    ){
        return ResponseEntity.ok(service.findAll(pageNo, record, property));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.deleteTicket(id);
        return ResponseDto.build()
                .withSuccess(true)
                .withMessage("Deleted id: " + id)
                .toEntity();
    }
}
