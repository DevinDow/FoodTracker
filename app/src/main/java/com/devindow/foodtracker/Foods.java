package com.devindow.foodtracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Foods {

    public static final List<Food> ITEMS = new ArrayList<>();

    public static final Map<String, Food> ITEM_MAP = new HashMap<>();

    static {
        // Add some sample items.
        for (int i = 1; i <= 25; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Food item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Food createDummyItem(int position) {
        return new Food(String.valueOf(position), "Food " + position, LocalDate.now().plusDays(position-2), 1, 0);
    }
}
