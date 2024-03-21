package com.example.carparking.service;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.request.EmployeeRegisterRequest;

import java.util.Collection;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeRegisterRequest request);
    Collection<EmployeeDto> getAllEmployees();

    void deleteEmployee(Long id) throws Exception;
}
