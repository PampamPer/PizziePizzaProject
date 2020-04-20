package com.example.pizziepizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Others extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Button btnpasta;
    private Button btnchick;
    private Button btnfries;
    private Button btndrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Mainmenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.order:
                        startActivity(new Intent(getApplicationContext(),ListOrder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(),MyHistory.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        btnpasta = findViewById(R.id.bt_pasta);
        btnpasta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(getApplicationContext(), Pastamenu.class);
                startActivity(intent1);
            }
        });

        btnchick = findViewById(R.id.bt_chicken);
        btnchick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(getApplicationContext(), Chickenmenu.class);
                startActivity(intent2);
            }
        });

        btnfries = findViewById(R.id.bt_fries);
        btnfries.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent3 = new Intent(getApplicationContext(), FrenchFries.class);
                startActivity(intent3);
            }
        });

        btndrink = findViewById(R.id.bt_drink);
        btndrink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent4 = new Intent(getApplicationContext(), Drinkmenu.class);
                startActivity(intent4);
            }
        });

    }
}
