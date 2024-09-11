package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //Cristopher Josué Paiva da Silva

    private TextView textView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Inicia a tarefa de download
        new DownloadTask().execute();
    }

    // Classe interna que estende AsyncTask
    //Se modifico o tipo de retorno do metodo para String para retornar o resultado do 
    //download, para poder usar o resultado no metodo onPostExecute
    //alem disso fechamos a conexao HTTP e o InputStream pra evitar vazamanto de recursos
    private class DownloadTask extends AsyncTask{

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Baixando...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    
        @Override
        protected String doInBackground(Void... voids) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("https://rafaelamorim.com.br/dados.txt");
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("DownloadTask", "Erro no download: " + e.getMessage());
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    
        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if (result != null) {
                textView.setText(result);
            } else {
                textView.setText("Erro no download");
            }
        }
    }
}