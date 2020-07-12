package com.devindow.foodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.Date;

public class FoodActivity extends AppCompatActivity {

    // Public Fields
    public Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // get Food passed in by Intent
        Intent intent = getIntent();
        String foodID = (String)intent.getSerializableExtra("foodID");
        food = Foods.ITEM_MAP.get(foodID);

        // Save
        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editName = (EditText)findViewById(R.id.editName);
                food.name = editName.getText().toString();

                final CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);
                Long msec = calendarView.getDate();
                Date date = new Date(msec);
                food.date = DateFormat.format("yyyy-MM-dd", date).toString();

                final EditText editFridge = (EditText)findViewById(R.id.editFridge);
                food.quantityFridge = Integer.parseInt(editFridge.getText().toString());

                final EditText editFreezer = (EditText)findViewById(R.id.editFreezer);
                food.quantityFreezer = Integer.parseInt(editFreezer.getText().toString());
            }
        });
    }
}