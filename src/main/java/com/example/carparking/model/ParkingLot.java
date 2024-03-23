package com.example.carparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private int parkingArea;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String parkingName;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String parkingPlace;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private int parkingPrice;
    @NotNull(message = "account not null")
    @NotBlank(message = "account not blank")
    private String parkingStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Car> cars;
}
