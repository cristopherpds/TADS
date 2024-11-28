package com.example.avaliacaodois;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private List<String> shoppingList;
    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        shoppingList = new ArrayList<>();
        adapter = new ShoppingListAdapter(shoppingList, this::removeItem);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.voiceButton).setOnClickListener(v -> startVoiceRecognition());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void startVoiceRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR");
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale o item para adicionar ou remover");
        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (result != null && !result.isEmpty()) {
                handleVoiceCommand(result);
            } else {
                Toast.makeText(this, "Não foi possível reconhecer o comando. Tente novamente em um ambiente mais silencioso.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void handleVoiceCommand(ArrayList<String> commands) {
        for (String command : commands) {
            if (command.toLowerCase().startsWith("adicionar ")) {
                String item = command.substring(10).trim();
                addItem(item);
                return;
            } else if (command.toLowerCase().startsWith("remover ")) {
                String item = command.substring(8).trim();
                removeItemByName(item);
                return;
            }else if (command.equalsIgnoreCase("ordenar lista")) {
                sortList();
                return;
            } else if (command.equalsIgnoreCase("limpar tudo")) {
                clearList();
                return;
            }
        }
        Toast.makeText(this, "Comando não reconhecido", Toast.LENGTH_SHORT).show();
    }

    private void sortList() {
        Collections.sort(shoppingList);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Lista ordenada", Toast.LENGTH_SHORT).show();
    }

    private void clearList() {
        shoppingList.clear();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Lista limpa", Toast.LENGTH_SHORT).show();
    }

    private void addItem(String item) {
        shoppingList.add(item);
        adapter.notifyItemInserted(shoppingList.size() - 1);
    }

    private void removeItem(int position) {
        shoppingList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void removeItemByName(String item) {
        int position = shoppingList.indexOf(item);
        if (position != -1) {
            removeItem(position);
        } else {
            Toast.makeText(this, "Item não encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}