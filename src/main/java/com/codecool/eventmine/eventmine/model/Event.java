package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {

    private static int counter = 1;
    protected String eventId;
    protected String name;
    protected String location;
    protected Date date;
    protected int numOfRemainingTickets;
    protected int price;


    public Event(String name, String location, Date date, int numOfRemainingTickets, int price) {
        this.eventId = name + counter;
        counter++;
        this.name = name;
        this.location = location;
        this.date = date;
        this.numOfRemainingTickets = numOfRemainingTickets;
        this.price = price;
    }

    public void removeTicket(int amount) {
        this.numOfRemainingTickets -= amount;
    }

}
