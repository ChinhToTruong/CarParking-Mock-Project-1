package com.example.carparking.controller;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.dto.ResponseDto;
import com.example.carparking.service.EmployeeService;
import jakarta.validation.Valid;
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
    public ResponseEntity addEmployee(@RequestBody @Valid EmployeeRegisterRequest request) throws Exception {
        var employee = employeeService.addEmployee(request);
        return ResponseDto.build()
                .withHttpStatus(HttpStatus.OK)
                .withCode(200)
                .withData(employee)
                .toEntity();
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<EmployeeDto>> allEmployees(@RequestParam(name = "pageNo") int pageNo, @RequestParam(name = "record") int record, @RequestParam(name = "sortBy") String property){
        return ResponseEntity.ok(employeeService.getAllEmployees(pageNo, record, property));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
        var id = employeeDto.getId();
        employeeService.deleteEmployee(id);
        return ResponseDto.build()
                .withSuccess(true)
                .withCode(200)
                .withMessage("Delete successfully employee id: " + id)
                .toEntity();

    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseDto.build()
                .withSuccess(true)
                .withCode(200)
                .withData(employeeService.updateEmployee(employeeDto))
                .withMessage("Update successfully!")
                .toEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity findEmployeeById(@PathVariable(name = "id") Long id){
        return ResponseDto.build()
                .withSuccess(true)
                .withData(employeeService.findEmployeeById(id))
                .toEntity();
    }
}
