package com.codecool.eventmine.eventmine.model;

import java.util.Date;

public class Concert extends Event {

    private String performer;

    public Concert(String name, String location, Date date, int numOfRemainingTickets, String performer) {
        super(name, location, date, numOfRemainingTickets);
        this.performer = performer;
    }

    public String getPerformer() {
        return performer;
    }
}
