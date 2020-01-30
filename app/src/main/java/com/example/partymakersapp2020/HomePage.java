package com.example.partymakersapp2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.aboutus);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.aboutus:
                        return true;

                    case R.id.portfolio:
                        startActivity(new Intent(getApplicationContext(),Gallery.class));

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


    }
}
