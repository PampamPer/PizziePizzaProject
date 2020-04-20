package com.example.pizziepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Familymenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familymenu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
