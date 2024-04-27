package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.models.TodoItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView noTaskView;
    private ArrayList<TodoItem> todoList;

    private BottomNavigationView menu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);



        recyclerView = findViewById(R.id.recyclerView);
        noTaskView = findViewById(R.id.noTaskView);
        menu = findViewById(R.id.menu);

        Intent i = getIntent();
        todoList = (ArrayList<TodoItem>) i.getSerializableExtra("todoList");

        if (todoList.isEmpty()) {
            noTaskView.setVisibility(View.VISIBLE);
        } else {
            noTaskView.setVisibility(View.GONE);
            TodoListAdapter adapter = new TodoListAdapter(todoList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        menu.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.cadastrar){
                Intent inte = new Intent(this, MainActivity.class);
                startActivity(inte);
                Toast.makeText(this, "Cadastrar", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.listar) {
                Toast.makeText(this, "Listar", Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }
}