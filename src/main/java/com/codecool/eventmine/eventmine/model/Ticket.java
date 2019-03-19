package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Ticket {

    private int counter = 1;
    protected int id;
    protected double price;
    protected Currency currency;
    protected String place;



    public Ticket(double price, Currency currency, String place) {
        this.id = counter;
        counter++;
        this.price = price;
        this.currency = currency;
        this.place = place;
    }

}
