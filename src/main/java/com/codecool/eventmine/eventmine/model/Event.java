package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {


    protected String id;

    protected String name;
    protected String location;
    protected LocalDate date;
    protected List<Ticket> availableTickets;

}
