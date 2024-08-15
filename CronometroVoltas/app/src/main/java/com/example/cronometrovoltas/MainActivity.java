package com.example.cronometrovoltas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView timerValue;
    private Button startButton, lapButton;
    private Handler customHandler = new Handler();
    private ListView lapList;
    private ArrayAdapter<String> adapter;
    private List<String> lapTimes = new ArrayList<>();
    private int lapCounter = 1;
    long startTime = 0L, timeInMilliseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;

    Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updateTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updateTime / 1000);
            int mins = secs / 60;
            secs %= 60;
            int milliseconds = (int) (updateTime % 1000);
            timerValue.setText("" + mins + ":" + String.format("%02d", secs) + ":" + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerValue = (TextView) findViewById(R.id.timerValue);
        startButton = (Button) findViewById(R.id.startButton);
        lapButton = (Button) findViewById(R.id.lapButton);
        lapList = (ListView) findViewById(R.id.lapList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lapTimes);
        lapList.setAdapter(adapter);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (startButton.getText().equals("Start")) {
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);
                    startButton.setText("Stop");
                } else {
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                    startButton.setText("Start");
                }
            }
        });

        lapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String lapTime = timerValue.getText().toString();
                int secs = (int) (updateTime / 1000);
                int mins = secs / 60;
                secs %= 60;
                int milliseconds = (int) (updateTime % 1000);
                String totalTime = "" + mins + ":" + String.format("%02d", secs) + ":" + String.format("%03d", milliseconds);
                lapTimes.add(0, "N° " + lapCounter + "   " + lapTime + "   " + totalTime);
                lapCounter++;
                adapter.notifyDataSetChanged();
            }
        });
    }
}