package com.example.pizziepizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Drinkmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkmenu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
