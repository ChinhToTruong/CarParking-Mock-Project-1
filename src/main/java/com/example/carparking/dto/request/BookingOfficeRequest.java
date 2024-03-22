package com.example.carparking.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class BookingOfficeRequest {
    private Long id;

    private Date endContractDeadline;

    private String officeName;

    private String officePhone;

    private String officePlace;

    private int officePrice;

    private Date startContractDeadline;

    private Long tripId;
}
