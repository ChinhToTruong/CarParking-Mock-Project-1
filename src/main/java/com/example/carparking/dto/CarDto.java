package com.example.carparking.dto;

import jakarta.validation.constraints.NotBlank;
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
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String licensePlate;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String carColor;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String carType;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String company;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private Long parkingLot;
    private List<Long> tickets;

}
