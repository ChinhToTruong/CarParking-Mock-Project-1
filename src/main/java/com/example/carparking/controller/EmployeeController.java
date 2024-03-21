package com.example.carparking.controller;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.dto.response.EmployeeResponseDto;
import com.example.carparking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody EmployeeRegisterRequest request) {
        var employee = employeeService.addEmployee(request);
        return EmployeeResponseDto.build()
                .withHttpStatus(HttpStatus.OK)
                .withCode(200)
                .withData(employee)
                .toEntity();
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<EmployeeDto>> allEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
        var id = employeeDto.getId();
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
