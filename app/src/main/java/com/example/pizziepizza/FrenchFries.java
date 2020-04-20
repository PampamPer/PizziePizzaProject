package com.example.pizziepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FrenchFries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_fries);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
