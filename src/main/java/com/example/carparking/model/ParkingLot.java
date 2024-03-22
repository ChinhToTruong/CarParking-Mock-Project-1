package com.example.carparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "can not be null")
    private int parkingArea;
    @NotNull(message = "can not be null")
    private String parkingName;
    @NotNull(message = "can not be null")
    private String parkingPlace;
    @NotNull(message = "can not be null")
    private int parkingPrice;
    @NotNull(message = "can not be null")
    private String parkingStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Car> cars;
}
