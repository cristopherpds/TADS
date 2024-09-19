package com.example.downloadplaymp3;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.SimpleExoPlayer;


public class MusicPlayerService extends Service {
    private ExoPlayer player;

    @UnstableApi
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url = intent.getStringExtra("url");
        Log.e("MainActivity", "Playing song from URL: "+ url);

        player = new ExoPlayer.Builder(this).build();
        player.setMediaItem(MediaItem.fromUri(Uri.parse(url)));
        player.prepare();
        player.play();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Este serviço não permite binding, então retornamos null
        return null;
    }
}
