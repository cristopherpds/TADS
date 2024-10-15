package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Cristopher Josué Paiva da Silva
    public static final String MY_ACTION = "com.example.broadcast.MY_ACTION";
    public static final String MY_MESSAGE = "Hello, Broadcast! This is a test of Mobile 2";
    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(myBroadcastReceiver, intentFilter);

        Button button = findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MY_ACTION);
                intent.putExtra("message", MY_MESSAGE);
                sendBroadcast(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}