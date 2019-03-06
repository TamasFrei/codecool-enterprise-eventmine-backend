package com.codecool.eventmine.eventmine.model;

import java.util.Date;

public class Concert extends Event {

    protected String performer;

    public Concert(String name, String location, Date date, String performer) {
        super(name, location, date);
        this.performer = performer;
    }

    public String getPerformer() {
        return performer;
    }
}
