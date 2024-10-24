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

import java.util.ArrayList;


public class MusicPlayerService extends Service {
    private ExoPlayer player;

    @UnstableApi
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ArrayList<String> urls = intent.getStringArrayListExtra("urls");
        if (urls != null && !urls.isEmpty()) {
            String url = urls.get(0); // Toca a primeira música ou implemente uma abordagem mais sofisticada
            Log.e("MusicPlayerService", "Tocando música da URL: " + url);
            player = new ExoPlayer.Builder(this).build();
            player.setMediaItem(MediaItem.fromUri(Uri.parse(url)));
            player.prepare();
            player.play();
        } else {
            Log.e("MusicPlayerService", "Nenhuma URL fornecida.");
        }

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
