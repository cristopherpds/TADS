package com.example.cadastro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadastro.models.TodoItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView menu;
    private EditText taskInput;
    private Button addButton;
    private ArrayList<TodoItem> todoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu);
        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        todoList = new ArrayList<>();

        addButton.setOnClickListener(v -> {
            String task = taskInput.getText().toString();
            todoList.add(new TodoItem(task));
            limpar();
        });

        menu.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.cadastrar){
                Toast.makeText(this, "Cadastrar", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.listar) {
                Intent i = new Intent(this, ListaActivity.class);
                i.putExtra("todoList", todoList);
                startActivity(i);
                Toast.makeText(this, "Listar", Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }
    private void limpar() {
        taskInput.setText(null);
    }
}