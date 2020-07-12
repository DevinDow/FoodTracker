package com.devindow.foodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;

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
                final EditText editName = (EditText) findViewById(R.id.editName);
                food.name = editName.getText().toString();
            }
        });
    }
}