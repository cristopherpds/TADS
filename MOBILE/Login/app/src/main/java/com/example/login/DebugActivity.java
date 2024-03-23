package com.example.login;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DebugActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Aula", getClass().getName()+" chamou onCreate().");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Aula", getClass().getName()+" chamou onStart().");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Aula", getClass().getName()+" chamou onRestart().");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Aula", getClass().getName()+" chamou onResume().");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Aula", getClass().getName()+" chamou onPause().");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Aula", getClass().getName()+" chamou onStop().");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Aula", getClass().getName()+" chamou onDestroy().");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
        Log.v("Aula", getClass().getName()+" chamou onPointerCaptureChanged().");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("Aula", getClass().getName()+" chamou onSaveInstanceState().");
    }
}
