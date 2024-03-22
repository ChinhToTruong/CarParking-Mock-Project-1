package com.example.carparking.dto;

import com.example.carparking.model.Employee;
import com.example.carparking.model.enums.DepartmentType;
import com.example.carparking.model.enums.SexType;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    private String account;
    private DepartmentType department;
    private String address;
    private Date dayOfBirth;
    private String email;
    private String fullName;
    private String phone;
    private String password;
    private SexType sex;
}
