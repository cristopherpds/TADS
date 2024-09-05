package com.example.myreciver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Crea una instancia del BroadcastReceiver
        myReceiver = new MyReceiver();

        // Registra el BroadcastReceiver dinámicamente
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Asegúrate de desregistrar el BroadcastReceiver
        if (myReceiver != null) {
            unregisterReceiver(myReceiver);
        }
    }
}