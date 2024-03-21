package com.example.carparking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int parkingArea;

    private String parkingName;

    private String parkingPlace;

    private int parkingPrice;

    private String parkingStatus;

    @OneToMany(mappedBy = "parkingLot")
    private Collection<Car> cars;
}
