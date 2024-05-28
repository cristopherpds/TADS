package com.example.integracaoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button btnEnviar;

    private TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        btnEnviar = findViewById(R.id.btnenviar);
        txtView = findViewById(R.id.txtView);

        btnEnviar.setOnClickListener(v -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://viacep.com.br")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ILocalidade req = retrofit.create(ILocalidade.class);
            req.getLocal(input.getText().toString()).enqueue(new Callback<Localidade>() {
                @Override
                public void onResponse(Call<Localidade> call, Response<Localidade> response) {
                    if (response.isSuccessful()) {
                        Localidade localidade = response.body();
                        txtView.setText(localidade.toString());
                    } else {
                        txtView.setText("Erro na resposta");
                    }
                }

                @Override
                public void onFailure(Call<Localidade> call, Throwable throwable) {
                    txtView.setText("Erro: " + throwable.getMessage());
                }
            });
        });
    }
}