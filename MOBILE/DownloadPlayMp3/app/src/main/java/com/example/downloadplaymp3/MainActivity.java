package com.example.downloadplaymp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.rafaelamorim.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MusicService musicService = retrofit.create(MusicService.class);

     
        Call<List<Song>> call = musicService.getMusicList();
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if (response.isSuccessful()) {
                    List<Song> songs = response.body();
        
                
                    Log.d("MainActivity", "Number of songs: " + songs.size());
                    Log.d("MainActivity", "Number of songs: " + response.body());
                    RecyclerView recyclerView = findViewById(R.id.recycler_view);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(new SongAdapter(songs));
        
                    
                    ArrayList<String> urls = new ArrayList<>();
for (Song song : songs) {
    urls.add(song.getUrl());
}
Intent intent = new Intent(MainActivity.this, MusicPlayerService.class);
intent.putStringArrayListExtra("urls", urls);
startService(intent);
                }
            }
        
            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.e("MainActivity", "Error loading songs", t);
            }
        });
    }
}