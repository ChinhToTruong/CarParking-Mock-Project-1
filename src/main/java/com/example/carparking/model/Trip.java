package com.example.carparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "can not be null")
    private int bookedTicketNumber;
    @NotNull(message = "can not be null")
    private String carType;
    @NotNull(message = "can not be null")
    private Date departureDate;
    @NotNull(message = "can not be null")
    private Date departureTime;
    @NotNull(message = "can not be null")
    private String destination;
    @NotNull(message = "can not be null")
    private String driver;
    @NotNull(message = "can not be null")
    private int maximumOnlineTicketNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Ticket> tickets;

    @JsonIgnore
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<BookingOffice> bookingOffices;

}
