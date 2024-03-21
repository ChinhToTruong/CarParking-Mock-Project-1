package com.example.carparking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bookedTicketNumber;

    private String carType;

    private Date departureDate;

    private Date departureTime;

    private String destination;

    private String driver;

    private int maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip")
    private Collection<Ticket> tickets;

    @OneToMany(mappedBy = "trip")
    private Collection<BookingOffice> bookingOffices;

}
