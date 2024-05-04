package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragmento1 fragmento1;
    private Fragmento2 fragmento2;
    private Fragmento3 fragmento3;

    private BottomNavigationView navMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmento1 = new Fragmento1();
        fragmento2 = new Fragmento2();
        fragmento3 = new Fragmento3();

        navMenu = findViewById(R.id.navMenu);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmento1).commit();

        navMenu.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.item1){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmento1).commit();
                return true;
            } else if (item.getItemId() == R.id.item2) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmento2).commit();
                return true;
            } else if (item.getItemId() == R.id.item3) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmento3).commit();
                return true;
            }
            return false;
        });
    }


}