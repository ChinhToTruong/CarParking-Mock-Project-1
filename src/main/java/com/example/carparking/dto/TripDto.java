package com.example.carparking.dto;

import com.example.carparking.model.BookingOffice;
import com.example.carparking.model.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class TripDto {

    private int bookedTicketNumber;

    private String carType;

    private Date departureDate;

    private Date departureTime;
    private String destination;

    private String driver;
    private int maximumOnlineTicketNumber;

    private List<Long> tickets;

    private List<Long> bookingOffices;
}
