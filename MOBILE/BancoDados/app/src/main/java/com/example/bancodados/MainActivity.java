package com.example.bancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;

    private Button salvar;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        salvar = findViewById(R.id.salvar);
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        salvar.setOnClickListener(v -> {
            Estudante e = new Estudante(-1, "", "");
            e.setNome(nome.getText().toString());
            e.setCpf(cpf.getText().toString());

            Database db = new Database(getApplicationContext(), "estudante.sql", null, 1);
            EstudanteDAO eDAO = new EstudanteDAO(db);
            eDAO.salvar(e);

            actualizarLista();
            limpar();
        });
        actualizarLista();


    }

    private void actualizarLista() {
        adapter.clear();
        Database db = new Database(getApplicationContext(), "estudante.sql", null, 1);
        EstudanteDAO eDAO = new EstudanteDAO(db);
        List<Estudante> estudiantes = eDAO.listarTodos();

        for (Estudante estudiante : estudiantes) {
            adapter.add("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNome() + ", CPF: " + estudiante.getCpf());
        }
    }

    private void limpar() {
        nome.setText(null);
        cpf.setText(null);
    }
}