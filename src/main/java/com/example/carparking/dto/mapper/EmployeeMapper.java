package com.example.carparking.dto.mapper;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.model.Employee;

import java.util.stream.Collectors;

public class EmployeeMapper {
    private static EmployeeMapper INSTANCE;
    public static EmployeeMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeMapper();
        }
        return INSTANCE;
    }


    public Employee toEntity(EmployeeRegisterRequest employeeDto) {
        return Employee.builder()
                .fullName(employeeDto.getFullName())
                .sex(employeeDto.getSex())
                .password(employeeDto.getPassword())
                .account(employeeDto.getAccount())
                .address(employeeDto.getAddress())
                .dayOfBirth(employeeDto.getDayOfBirth())
                .phone(employeeDto.getPhone())
                .department(employeeDto.getDepartment())
                .email(employeeDto.getEmail())
                .build();
    }
    public EmployeeDto toDTO(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .sex(employee.getSex())
                .password(employee.getPassword())
                .account(employee.getAccount())
                .address(employee.getAddress())
                .dayOfBirth(employee.getDayOfBirth())
                .phone(employee.getPhone())
                .department(employee.getDepartment())
                .email(employee.getEmail())
                .build();
    }
}
