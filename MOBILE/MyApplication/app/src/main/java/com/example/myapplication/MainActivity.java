package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_RECORD_AUDIO = 1;
    private static final int SAMPLE_RATE = 44100;
    private static final int CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT;

    private AudioRecord audioRecord;
    private boolean isRecording = false;
    private Thread recordingThread;
    private int bufferSize;

    private TextView tvDecibelValue;
    private TextView tvDecibelLevel;
    private Button btnStartStop;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDecibelValue = findViewById(R.id.tvDecibelValue);
        tvDecibelLevel = findViewById(R.id.tvDecibelLevel);
        btnStartStop = findViewById(R.id.btnStartStop);

        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecording) {
                    stopRecording();
                } else {
                    startRecording();
                }
            }
        });

        bufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNEL_CONFIG, AUDIO_FORMAT);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSION_RECORD_AUDIO);
        }
    }

    private void startRecording() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLE_RATE, CHANNEL_CONFIG, AUDIO_FORMAT, bufferSize);

        if (audioRecord.getState() != AudioRecord.STATE_INITIALIZED) {
            Toast.makeText(this, "Erro ao inicializar o AudioRecord", Toast.LENGTH_SHORT).show();
            return;
        }

        audioRecord.startRecording();
        isRecording = true;
        btnStartStop.setText("Parar Medição");

        recordingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                short[] audioBuffer = new short[bufferSize / 2];
                while (isRecording) {
                    audioRecord.read(audioBuffer, 0, audioBuffer.length);
                    double amplitude = calculateAmplitude(audioBuffer);
                    final double db = calculateDecibels(amplitude);
                    updateUI(db);
                }
            }
        });
        recordingThread.start();
    }

    private void stopRecording() {
        if (audioRecord != null) {
            isRecording = false;
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
            recordingThread = null;
            btnStartStop.setText("Iniciar Medição");
        }
    }

    private double calculateAmplitude(short[] buffer) {
        double sum = 0;
        for (short sample : buffer) {
            sum += Math.abs(sample);
        }
        return sum / buffer.length;
    }

    private double calculateDecibels(double pressaoSomCapturado) {
        final double PRESSAO_REFERENCIA = 20.0;
        return 20 * Math.log10(pressaoSomCapturado / PRESSAO_REFERENCIA);
    }

    private void updateUI(final double db) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvDecibelValue.setText(String.format("%.1f dB", db));
                updateDecibelLevel(db);
            }
        });
    }

    private void updateDecibelLevel(double db) {
        String level;
        int color;
        if (db <= 60) {
            level = "Seguro";
            color = ContextCompat.getColor(this, R.color.safe);
        } else if (db <= 85) {
            level = "Moderado";
            color = ContextCompat.getColor(this, R.color.moderate);
        } else if (db <= 100) {
            level = "Perigoso";
            color = ContextCompat.getColor(this, R.color.dangerous);
        } else {
            level = "Muito Perigoso";
            color = ContextCompat.getColor(this, R.color.very_dangerous);
        }
        tvDecibelLevel.setText("Nível: " + level);
        tvDecibelLevel.setTextColor(color);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopRecording();
    }
}