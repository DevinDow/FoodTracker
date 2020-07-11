package com.devindow.foodtracker;

import java.time.LocalDate;
import java.time.Period;

public class Food {

    // Fields
    public final String id;
    public final String name;
    public final LocalDate date;
    public final int quantityFridge;
    public final int quantityFreezer;

    // Properties
    public int getDays() {
        Period period = Period.between(LocalDate.now(), date);
        return period.getDays();
    }

    public String getDaysString() {
        return String.format("%d days", getDays());
    }

    // Constructor
    public Food(String id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return name + " " + date.toString() + " " + id;
    }
}
