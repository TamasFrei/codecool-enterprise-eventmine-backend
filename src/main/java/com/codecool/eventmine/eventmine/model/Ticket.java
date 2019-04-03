package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Currency;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ticket {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    protected Integer id;

    @Column(nullable = false)
    protected double price;

    protected String place;

    @ManyToOne
    protected Event event;

    public Ticket(double price, String place, Event event) {
        this.price = price;
        this.place = place;
        this.event = event;
    }
}
