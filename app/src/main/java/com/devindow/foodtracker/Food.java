package com.devindow.foodtracker;

import java.time.LocalDate;
import java.time.Period;

public class Food {

    // Fields
    public final String id;
    public final String name;
    public final String date;
    public final int quantityFridge;
    public final int quantityFreezer;

    // Properties
    public int getDays() {
        Period period = Period.between(LocalDate.now(), LocalDate.parse(date));
        return period.getDays();
    }

    public String getDaysString() {
        return String.format("%d days", getDays());
    }

    // Constructor
    public Food(String id, String name, String date, int quantityFridge, int quantityFreezer) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantityFridge = quantityFridge;
        this.quantityFreezer = quantityFreezer;
    }

    @Override
    public String toString() {
        return name + " " + date + " " + id;
    }
}
