package com.devindow.foodtracker;

import androidx.recyclerview.widget.SortedList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Foods {

    public static final SortedList<Food> ITEMS = new SortedList<Food>(Food.class, new SortedList.Callback<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.date.compareTo(o2.date);
        }

        @Override
        public void onChanged(int position, int count) {
        }

        @Override
        public void onChanged(int position, int count, Object payload) {
            super.onChanged(position, count, payload);
        }

        @Override
        public boolean areItemsTheSame(Food item1, Food item2) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(Food oldItem, Food newItem) {
            return false;
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
        }

        @Override
        public void onRemoved(int position, int count) {
        }

        @Override
        public void onInserted(int position, int count) {
        }
    });

    public static final Map<String, Food> ITEM_MAP = new HashMap<>();

    static {
        // Add some sample items.
        for (int i = 1; i <= 25; i++) {
            addItem(createDummyItem(i));
        }


        /*Gson gson = new Gson();

        String json = gson.toJson(Foods.ITEMS);

        ArrayList arrayList = gson.fromJson(json, ArrayList.class);

        String json2 = gson.toJson(arrayList);

        if (json.compareTo(json2) != 0)
        {
        }*/
    }

    private static void addItem(Food item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Food createDummyItem(int position) {
        return new Food(String.valueOf(position), "Food " + position, LocalDate.now()/*.minusDays(position)*/.toString(), 1, 0);
    }
}
