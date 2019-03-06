package com.codecool.eventmine.eventmine.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Event {

    private static int counter = 1;
    protected String eventId;
    protected String name;
    protected String location;
    protected Date date;
    private List<Ticket> remainingTickets = new LinkedList<>();

    public Event() {
    }

    public Event(String name, String location, Date date) {
        this.eventId = name + counter;
        counter++;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public Ticket addTicket(Ticket ticket) {
        remainingTickets.add(ticket);
        return ticket;
    }

    public void removeTicket(Ticket ticket) {
        remainingTickets.remove(ticket);
    }

    public Ticket getById(int ticketId) {
        for (Ticket ticket: remainingTickets) {
            if(ticket.getId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getRemainingTickets() {
        return remainingTickets;
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
