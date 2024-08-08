package com.example.asyncwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView countdownText;
    private ExecutorService executorService;
    private Future<?> countdownFuture;
    private long countdownTime;
    private Button startButton;
    private boolean isCountingDown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = findViewById(R.id.countdown_text);
        startButton = findViewById(R.id.button);

        executorService = Executors.newSingleThreadExecutor();
        countdownTime = 10000; // Inicializa countdownTime com 10 segundos

        startButton.setOnClickListener(v -> {
            if (!isCountingDown) {
                startCountdown();
            } else {
                Toast.makeText(MainActivity.this, "Contagem regressiva já está em andamento", Toast.LENGTH_SHORT).show();
            }
        });
        updateButtonVisibility();
    }

    private void startCountdown() {
        isCountingDown = true;
        countdownTime = 10000; // Reinicia o tempo da contagem regressiva para 10 segundos

        countdownFuture = executorService.submit(() -> {
            while (countdownTime > 0) {
                long finalCountdownTime = countdownTime;
                runOnUiThread(() -> {
                    countdownText.setText("Tempo Restante: " + (finalCountdownTime / 1000) + " segundos");
                    Log.d(TAG, "Updating UI with time: " + (finalCountdownTime / 1000) + " segundos");
                });

                try {
                    Thread.sleep(1000); // Aguarde 1 segundo
                    countdownTime -= 1000; // Subtraia 1 segundo do tempo restante
                    Log.d(TAG, "Countdown time remaining: " + countdownTime);
                } catch (InterruptedException e) {
                    Log.e(TAG, "Countdown interrupted", e);
                }
            }

            runOnUiThread(() -> {
                countdownText.setText("Contagem Regressiva Concluída");
                Toast.makeText(MainActivity.this, "Contagem Regressiva Concluída", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Countdown completed");
                isCountingDown = false; // Permite reiniciar a contagem regressiva
                updateButtonVisibility();
            });
        });
        updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        runOnUiThread(() -> {
            if (!isCountingDown) {
                startButton.setVisibility(View.VISIBLE);
            } else {
                startButton.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countdownFuture != null) {
            countdownFuture.cancel(true); // Cancela a tarefa se a atividade for destruída
            Log.d(TAG, "Countdown future cancelled");
        }
        executorService.shutdown(); // Encerra o executor service
        Log.d(TAG, "Executor service shut down");
    }

}