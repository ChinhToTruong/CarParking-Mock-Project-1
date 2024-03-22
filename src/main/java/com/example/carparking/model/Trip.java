package com.example.carparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Ticket> tickets;

    @JsonIgnore
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<BookingOffice> bookingOffices;

}
