package com.example.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensorProximidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorProximidade = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        if(sensorProximidade != null){
            SensorEventListener sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    Log.i("SensorProximidade", "Distancia " + event.values[0] + " cm");
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                    accuracy = 1;
                }
            };
            sensorManager.registerListener(sensorEventListener, sensorProximidade, SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Log.i("SensorProximidade", "Sensor de Proximidade");
        }

    }
}