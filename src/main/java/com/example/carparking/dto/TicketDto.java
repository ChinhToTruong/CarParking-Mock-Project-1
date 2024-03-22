package com.example.carparking.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "can not be null")
    private Date bookingTime;
    @NotNull(message = "can not be null")
    private String customerName;
    @NotNull(message = "can not be null")
    private String licensePlate;
    @NotNull(message = "can not be null")
    private Long trip;
    @NotNull(message = "can not be null")
    private Long car;
}
