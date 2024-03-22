package com.example.carparking.service;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.request.EmployeeRegisterRequest;

import java.util.Collection;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeRegisterRequest request) throws Exception;
    Collection<EmployeeDto> getAllEmployees(int pageNo, int record, String property);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id) throws Exception;

    EmployeeDto findEmployeeById(Long id);
}
