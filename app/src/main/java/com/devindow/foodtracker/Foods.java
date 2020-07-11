package com.devindow.foodtracker;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class Foods {

    public static final List<Food> ITEMS = new ArrayList<>();

    //public static final Map<String, Food> ITEM_MAP = new HashMap<>();

    static {
        // Add some sample items.
        for (int i = 1; i <= 25; i++) {
            addItem(createDummyItem(i));
        }


        //Gson gson = new Gson();

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        LocalDate date = LocalDate.now();
        String datejson = gson.toJson(date, LocalDate.class);

        String json = gson.toJson(Foods.ITEMS);

        ArrayList arrayList = gson.fromJson(json, ArrayList.class);

        String json2 = gson.toJson(arrayList);

        if (json.compareTo(json2) != 0)
        {
        }
    }

    private static void addItem(Food item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

    private static Food createDummyItem(int position) {
        return new Food(String.valueOf(position), "Food " + position, LocalDate.now().plusDays(position-2), 1, 0);
    }
}
