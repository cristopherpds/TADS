package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView txtHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtHome = findViewById(R.id.txtHome);

        Intent intent = getIntent();
        String username = intent.getExtras().getString("usr");

        txtHome.setText("Ola " +username+ " seja bem-vindo");
    }
}
