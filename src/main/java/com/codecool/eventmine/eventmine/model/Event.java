package com.codecool.eventmine.eventmine.model;

import java.util.Date;

public abstract class Event {

    private static int counter = 1;
    protected String eventId;
    protected String name;
    protected String location;
    protected Date date;

    public Event() {
    }

    public Event(String name, String location, Date date) {
        this.eventId = name + counter;
        counter++;
        this.name = name;
        this.location = location;
        this.date = date;
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
