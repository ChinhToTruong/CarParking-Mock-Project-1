package com.example.carparking.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ParkingLotDto {
    private Long id;
    private int parkingArea;
    private String parkingName;
    private String parkingPlace;
    private int parkingPrice;
    private String parkingStatus;
    private List<Long> cars;
}
