package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //Cristopher Josué Paiva da Silva
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (MainActivity.MY_ACTION.equals(action)) {
            String message = intent.getStringExtra("message");

            if (MainActivity.MY_MESSAGE.equals(message)) {
                Log.d("MyBroadcastReceiver", "Mensagem correta recebida!");
            } else {
                Log.d("MyBroadcastReceiver", "Mensagem incorreta recebida.");
            }
        }
    }
}
