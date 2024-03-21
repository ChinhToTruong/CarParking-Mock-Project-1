package com.example.carparking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date bookingTime;

    private String customerName;

    private String licensePlate;

    @ManyToOne
    private Trip trip;

    @ManyToOne
    private Car car;
}
