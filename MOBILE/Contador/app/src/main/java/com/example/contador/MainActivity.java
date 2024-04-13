package com.example.contador;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String COUNT_KEY = "count_key";
    private int count = 0;
    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.count_text_view);
        countTextView.setOnClickListener(v -> {
            count++;
            countTextView.setText(String.valueOf(count));
        });

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT_KEY, 0);
            countTextView.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, count);
    }
}