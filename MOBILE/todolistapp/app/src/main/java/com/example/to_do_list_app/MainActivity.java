package com.example.to_do_list_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button continuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continuar = findViewById(R.id.continuar);

        continuar.setOnClickListener(v -> {
            if (continuar.isClickable()){
                Intent Home = new Intent(this, Home.class);
                startActivity(Home);
            }else {
                Toast.makeText(MainActivity.this, "Nao foi possivel continuar", Toast.LENGTH_LONG).show();
            }
        });
    }
}