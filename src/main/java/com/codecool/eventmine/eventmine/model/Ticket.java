package com.codecool.eventmine.eventmine.model;

import java.util.Currency;

public abstract class Ticket {

    private int counter = 1;
    protected int id;
    protected double price;
    protected Currency currency;
    protected String place;


    public Ticket() {
    }

    public Ticket(double price, Currency currency, String place) {
        this.price = price;
        this.currency = currency;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getPlace() {
        return place;
    }
}
