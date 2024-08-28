package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();

        PeriodicWorkRequest syncWorkRequest = new PeriodicWorkRequest.Builder(SyncWorker.class, 15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();

        WorkManager.getInstance(this).enqueue(syncWorkRequest);

        
        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(syncWorkRequest);

        UUID workId = syncWorkRequest.getId();

        workManager.getWorkInfoByIdLiveData(workId).observe(this, workInfo -> {
            if (workInfo != null && workInfo.getState() == WorkInfo.State.FAILED) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                String channelId = "workmanager_channel";
                String channelName = "workmanager";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                }
                Notification notification = new NotificationCompat.Builder(this, channelId)
                        .setContentTitle("WorkManager")
                        .setContentText("Sincronização de dados falhou devido a restrições não cumpridas")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                notificationManager.notify(2, notification);
            }
        });
    }
}