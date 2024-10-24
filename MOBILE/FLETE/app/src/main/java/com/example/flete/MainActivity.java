package com.example.flete;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;


import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Entrega> listaEntregas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Simulação de lista de entregas com dados fixos
        listaEntregas = new ArrayList<>();
        listaEntregas.add(new Entrega("Entrega 1", "-30.902232,-55.550500", "Rua A, Cliente 1"));
        listaEntregas.add(new Entrega("Entrega 2", "-30.897850,-55.543102", "Rua B, Cliente 2"));
        listaEntregas.add(new Entrega("Entrega 3", "-30.898987,-55.535192", "Rua C, Cliente 3"));
        listaEntregas.add(new Entrega("Entrega 4", "-30.892784,-55.540113", "Rua D, Cliente 4"));

        List<String> nomesEntregas = new ArrayList<>();
        for (Entrega entrega : listaEntregas) {
            nomesEntregas.add(entrega.getNome());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesEntregas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entrega entregaSelecionada = listaEntregas.get(position);
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                intent.putExtra("origem", "-30.9006365,-55.533645");


                intent.putExtra("destino", entregaSelecionada.getCoordenadas());
                startActivity(intent);
            }
        });
        filtrarEOrdenarEntregas("-30.9006365,-55.533645");
    }
    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        Location locationA = new Location("point A");
        locationA.setLatitude(lat1);
        locationA.setLongitude(lon1);

        Location locationB = new Location("point B");
        locationB.setLatitude(lat2);
        locationB.setLongitude(lon2);

        return locationA.distanceTo(locationB);
    }

    private void filtrarEOrdenarEntregas(String origem) {
        List<Entrega> entregasFiltradas = new ArrayList<>();

        for (Entrega entrega : listaEntregas) {
            if (!entrega.isEntregue()) {
                entregasFiltradas.add(entrega);
            }
        }
        
        entregasFiltradas.sort((e1, e2) -> {
            String[] coords1 = e1.getCoordenadas().split(",");
            String[] coords2 = e2.getCoordenadas().split(",");
            double dist1 = calcularDistancia(Double.parseDouble(origem.split(",")[0]), Double.parseDouble(origem.split(",")[1]),
                    Double.parseDouble(coords1[0]), Double.parseDouble(coords1[1]));
            double dist2 = calcularDistancia(Double.parseDouble(origem.split(",")[0]), Double.parseDouble(origem.split(",")[1]),
                    Double.parseDouble(coords2[0]), Double.parseDouble(coords2[1]));
            return Double.compare(dist1, dist2);
        });

        // Atualiza o adapter com as entregas filtradas
        List<String> nomesEntregas = new ArrayList<>();
        for (Entrega entrega : entregasFiltradas) {
            nomesEntregas.add(entrega.getNome());
        }
        adapter.clear();
        adapter.addAll(nomesEntregas);
        adapter.notifyDataSetChanged();
    }


    class Entrega {
        private String nome;
        private String coordenadas;
        private String detalhes;
        private boolean entregue;

        public Entrega(String nome, String coordenadas, String detalhes) {
            this.nome = nome;
            this.coordenadas = coordenadas;
            this.detalhes = detalhes;
            this.entregue = false;
        }

        public String getNome() {
            return nome;
        }

        public String getCoordenadas() {
            return coordenadas;
        }

        public String getDetalhes() {
            return detalhes;
        }

        public boolean isEntregue() {
            return entregue;
        }

        public void setEntregue(boolean entregue) {
            this.entregue = entregue;
        }
    }

}
