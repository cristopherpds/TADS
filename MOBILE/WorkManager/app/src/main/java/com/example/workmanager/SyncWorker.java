package com.example.workmanager;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
public class SyncWorker extends Worker{

    public SyncWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "workmanager_channel";
        String channelName = "workmanager";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setContentTitle("WorkManager")
                .setContentText("Sincronização de dados realizada")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        notificationManager.notify(1, notification);

        Log.d("SyncWorker", "Sincronização de dados realizada 2");
        return Result.success();
    }
}
