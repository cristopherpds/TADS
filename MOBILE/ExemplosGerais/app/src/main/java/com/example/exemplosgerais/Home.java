package com.example.exemplosgerais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private ListView lv;
    private Spinner spinner;

    private BottomNavigationView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lv = findViewById(R.id.lv);
        spinner = findViewById(R.id.spinner);
        menu = findViewById(R.id.menu);
        String [] itens = {"prog mobile 1", "web 1", "testes", "sistemas distribuidos"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, itens);

        lv.setAdapter(adaptador);
        spinner.setAdapter(adaptador);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            String aux = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_LONG).show();
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String aux2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), aux2, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        menu.setOnItemReselectedListener(item -> {
            if(item.getItemId() == R.id.item1){
                Toast.makeText(this, "item1", Toast.LENGTH_LONG).show();
            } else if (item.getItemId() == R.id.item2) {
                Toast.makeText(this, "item2", Toast.LENGTH_LONG).show();
            }
        });
    }
}