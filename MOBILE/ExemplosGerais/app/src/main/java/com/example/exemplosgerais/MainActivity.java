package com.example.exemplosgerais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String usr = user.getText().toString();
            String psw = password.getText().toString();

            if(usr.equals("cris") && psw.equals("123")){
                Intent i = new Intent(this, Home.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Dados Invalidos", Toast.LENGTH_LONG).show();
            }
        });
    }
}