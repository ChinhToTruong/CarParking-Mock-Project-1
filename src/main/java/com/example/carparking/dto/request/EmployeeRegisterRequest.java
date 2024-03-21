package com.example.carparking.dto.request;

import com.example.carparking.model.enums.DepartmentType;
import com.example.carparking.model.enums.SexType;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRegisterRequest {
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
