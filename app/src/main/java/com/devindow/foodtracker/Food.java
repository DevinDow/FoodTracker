package com.devindow.foodtracker;

import java.time.LocalDate;

public class Food {

    // Fields
    public final String id;
    public final String name;
    public final LocalDate date;

    // Properties
    public int getDays() { return }

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
