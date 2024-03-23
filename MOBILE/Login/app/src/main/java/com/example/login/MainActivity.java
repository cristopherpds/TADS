package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends DebugActivity {

    private Button btnLogin;
    private EditText txtUser;
    private EditText txtPassword;
    private TextView txtSaida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        txtSaida = findViewById(R.id.txtSaida);
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
                txtUser.setHintTextColor(Color.RED);
                txtPassword.setHintTextColor(Color.RED);
                txtSaida.setText("Usuario ou senha incorreto, por favor tente novamente");
                txtSaida.setTextColor(Color.RED);
            }
        });
    }
}