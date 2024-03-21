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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    private String carColor;

    private String carType;

    private String company;

    @ManyToOne
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "car")
    private Collection<Ticket> tickets;
}
