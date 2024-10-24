package com.example.flete;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MapActivity extends AppCompatActivity {
    private WebView webViewGMap;
    private Button btnEntregaConcluida, btnNaoPossivel;
    private String origem, destino;
    private LocationManager locationManager;
    private String stringOrigem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        webViewGMap = findViewById(R.id.webViewGMap);
        btnEntregaConcluida = findViewById(R.id.btnEntregaConcluida);
        btnNaoPossivel = findViewById(R.id.btnNaoPossivel);


        origem = getIntent().getStringExtra("origem");
        destino = getIntent().getStringExtra("destino");
        Log.d("MapActivity", "Destino recebido: " + destino);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        } else {
            setupLocationServices();
        }

        btnEntregaConcluida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("entrega_concluida", true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        btnNaoPossivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("entrega_concluida", false);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }

    private void setupLocationServices() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            Location localAtual = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (localAtual != null) {
                stringOrigem = localAtual.getLatitude() + "," + localAtual.getLongitude();
            } else {
                Toast.makeText(this, "Não foi possível obter a localização atual", Toast.LENGTH_SHORT).show();
            }


            String url = "https://www.google.com/maps/dir/" + stringOrigem + "/" + destino;
            WebSettings webSettings = webViewGMap.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webViewGMap.setWebViewClient(new WebViewClient());
            webViewGMap.loadUrl(url);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupLocationServices();
            } else {
                Toast.makeText(this, "Permissão de localização negada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
