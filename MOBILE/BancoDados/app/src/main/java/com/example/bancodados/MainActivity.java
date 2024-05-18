package com.example.bancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;

    private Button salvar;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.CPF);
        salvar = findViewById(R.id.salvar);
        listView = findViewById(R.id.listView);


        salvar.setOnClickListener(v -> {
            Estudante e = new Estudante(-1, "", "");
            e.setNome(nome.getText().toString());
            e.setCpf(nome.getText().toString());

            Database db = new Database(getApplicationContext());
            EstudanteDAO eDAO = new EstudanteDAO(db);
            eDAO.salvar(e);
        });

    }
}