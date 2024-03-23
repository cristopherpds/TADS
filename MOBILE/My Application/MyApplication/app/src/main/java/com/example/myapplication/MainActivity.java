package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mEdit;

    private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = (EditText)findViewById(R.id.textoEntrada);
        mText = (TextView)findViewById(R.id.txtSaida);
        mButton = (Button)findViewById(R.id.btnEnviar);
        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String txt = mEdit.getText().toString();
                        if (!txt.isEmpty()) {
                            mText.setText(txt);

                        }else {
                            mEdit.setHintTextColor(Color.RED);
                            mText.setText("Porfavor complete o campo");
                            mText.setTextColor(Color.RED);
                        }
                    }
                }
        );

    }
}