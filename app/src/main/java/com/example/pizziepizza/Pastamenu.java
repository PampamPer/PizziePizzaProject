package com.example.pizziepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Pastamenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastamenu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
