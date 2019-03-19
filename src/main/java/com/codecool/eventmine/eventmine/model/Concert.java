package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concert extends Event {

    private String performer;

    public Concert(String name, String location, Date date, int numOfRemainingTickets, String performer, int price) {
        super(name, location, date, numOfRemainingTickets, price);
        this.performer = performer;
    }

}
