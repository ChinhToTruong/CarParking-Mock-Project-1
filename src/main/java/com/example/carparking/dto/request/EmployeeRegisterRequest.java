package com.example.carparking.dto.request;

import com.example.carparking.model.enums.DepartmentType;
import com.example.carparking.model.enums.SexType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRegisterRequest {

    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String account;

    @NotNull(message = "department not null")
    private DepartmentType department;

    private String address;

    private Date dayOfBirth;

    @NotNull(message = "email not null")
    @NotBlank(message = "email not null")
    private String email;

    @NotNull(message = "name not null")
    @NotBlank(message = "name not null")
    private String fullName;

    @NotNull(message = "phone not null")
    @NotBlank(message = "phone not null")
    private String phone;

    @NotNull(message = "password not null")
    @NotBlank(message = "password not null")
    private String password;

    @NotNull(message = "sex not null")
    private SexType sex;
}
