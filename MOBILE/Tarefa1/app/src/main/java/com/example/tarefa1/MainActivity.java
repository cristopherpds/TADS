package com.example.tarefa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText txtAutonomy;
    private EditText txtDistance;
    private EditText txtFuelPrice;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAutonomy = findViewById(R.id.txtAutonomy);
        txtDistance = findViewById(R.id.txtDistance);
        txtFuelPrice = findViewById(R.id.txtFuelPrice);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double autonomy = Double.parseDouble(txtAutonomy.getText().toString());
                double distance = Double.parseDouble(txtDistance.getText().toString());
                double fuelPrice = Double.parseDouble(txtFuelPrice.getText().toString());

                double cost = (distance / autonomy) * fuelPrice;

                Toast.makeText(MainActivity.this, "Custo da viagem: R$" + cost, Toast.LENGTH_LONG).show();
                limpar();
            }

            public void limpar(){
                txtAutonomy.setText(null);
                txtDistance.setText(null);
                txtFuelPrice.setText(null);
            }
        });
    }
}