package com.example.downloadplaymp3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusicService {
    @GET("mobile2/musicas/list.json")
    Call<List<Song>> getMusicList();
}
