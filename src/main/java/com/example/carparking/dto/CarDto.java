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

    private String licensePlate;

    private String carColor;

    private String carType;

    private String company;

    private Long parkingLot;

}
