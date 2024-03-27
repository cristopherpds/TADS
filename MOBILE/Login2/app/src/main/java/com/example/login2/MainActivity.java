package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText txtUser;
    private EditText txtPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        String user = "Cristopher";
        String passw = "123";

        btnLogin.setOnClickListener(v -> {

            String usr = txtUser.getText().toString();
            String psw =  txtPassword.getText().toString();

            if(usr.equals(user) && psw.equals(passw)) {
                Intent Login = new Intent(this, Home.class);
                Bundle dados = new Bundle();
                dados.putString("usr", usr);
                Login.putExtras(dados);
                startActivity(Login);
            }else {
                Toast.makeText(MainActivity.this, "Usuario ou senha incorreto, por favor tente novamente", Toast.LENGTH_LONG).show();
                limpar();
            }
        });
    }
    private void limpar() {
        txtUser.setText(null);
        txtPassword.setText(null);
    }
}