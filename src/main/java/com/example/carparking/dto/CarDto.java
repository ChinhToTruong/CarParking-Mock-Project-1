package com.example.carparking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    @NotNull(message = "can not be null")
    private String licensePlate;
    @NotNull(message = "can not be null")
    private String carColor;
    @NotNull(message = "can not be null")
    private String carType;
    @NotNull(message = "can not be null")
    private String company;
    @NotNull(message = "can not be null")
    private Long parkingLot;

}
