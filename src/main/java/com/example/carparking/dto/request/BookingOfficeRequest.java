package com.example.carparking.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BookingOfficeRequest {
    private Long id;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private Date endContractDeadline;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String officeName;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String officePhone;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String officePlace;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private int officePrice;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private Date startContractDeadline;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private Long tripId;
}
