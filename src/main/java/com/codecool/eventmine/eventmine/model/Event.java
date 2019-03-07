package com.codecool.eventmine.eventmine.model;

import java.util.Date;

public abstract class Event {

    private static int counter = 1;
    protected String eventId;
    protected String name;
    protected String location;
    protected Date date;
    protected int numOfRemainingTickets;

    public Event() {
    }

    public Event(String name, String location, Date date, int numOfRemainingTickets) {
        this.eventId = name + counter;
        counter++;
        this.name = name;
        this.location = location;
        this.date = date;
        this.numOfRemainingTickets = numOfRemainingTickets;
    }

    public void removeTicket(int amount) {
        this.numOfRemainingTickets -= amount;
    }

    public int getNumOfRemainingTickets() {
        return numOfRemainingTickets;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }
}
