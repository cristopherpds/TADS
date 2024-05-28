package com.example.integracaoapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ILocalidade {
    @GET("/ws/{cep}/json/")
    Call<Localidade> getLocal(@Path("cep") String cep);




}
