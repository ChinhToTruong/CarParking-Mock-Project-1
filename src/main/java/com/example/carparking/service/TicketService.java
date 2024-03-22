package com.example.carparking.service;

import com.example.carparking.dto.TicketDto;
import com.example.carparking.model.ParkingLot;
import com.example.carparking.model.Ticket;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

public interface TicketService {
    Collection<Ticket> findAll(int pageNo, int record, String property);

    Optional addTicket(TicketDto ticketDto);

    void deleteTicket(Long id);

}
