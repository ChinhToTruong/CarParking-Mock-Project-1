package com.example.carparking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private Date bookingTime;

    private String customerName;

    private String licensePlate;

    private Long trip;

    private Long car;
}
