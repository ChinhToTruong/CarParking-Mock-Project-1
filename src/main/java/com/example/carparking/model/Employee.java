package com.example.carparking.model;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.model.enums.DepartmentType;
import com.example.carparking.model.enums.SexType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(length = 50, nullable = false)
//    @NotBlank(message = "Field over length")
    private String account;

//    @Column(length = 10, nullable = false)
//    @NotBlank(message = "Field over length")

    private DepartmentType department;

//    @Column(length = 50)
//    @NotBlank(message = "Field over length")
    private String address;

    private Date dayOfBirth;

//    @Column(length = 50, nullable = false)
//    @NotBlank(message = "Field over length")
    private String email;

//    @Column(length = 50, nullable = false)
//    @NotBlank(message = "Field over length")
    private String fullName;

//    @Column(length = 10, nullable = false)
//    @NotBlank(message = "Field over length")
    private String phone;

//    @Column(length = 10, nullable = false)
//    @NotBlank(message="Field over length")
    private String password;

    private SexType sex;


}
