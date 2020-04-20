package com.example.pizziepizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mainmenu extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Button btncombo;
    private Button btnfamily;
    private Button btnpizza;
    private Button btnothers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
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

        btncombo = findViewById(R.id.bt_combo);
        btncombo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(getApplicationContext(), Combomenu.class);
                startActivity(intent1);
            }
        });

        btnfamily = findViewById(R.id.bt_family);
        btnfamily.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(getApplicationContext(), Familymenu.class);
                startActivity(intent2);
            }
        });

        btnpizza = findViewById(R.id.bt_pizza);
        btnpizza.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent3 = new Intent(getApplicationContext(), Pizzamenu.class);
                startActivity(intent3);
            }
        });

        btnothers = findViewById(R.id.bt_other);
        btnothers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent4 = new Intent(getApplicationContext(), Others.class);
                startActivity(intent4);
            }
        });

    }

}
