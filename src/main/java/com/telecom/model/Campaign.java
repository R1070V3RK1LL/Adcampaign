package com.telecom.model;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
public class Campaign {
    private @Id
    @GeneratedValue long id;
private LocalDate starting_date;
private LocalDate ending_date;
    @ManyToOne
    @ToString.Exclude
    private Product product;

    public Campaign(){

    }

    public void setEndingDate(LocalDate ending_date) {
        this.ending_date = ending_date;
    }

    public void setStartingDate(LocalDate starting_date) {
        this.starting_date = starting_date;
    }
}
