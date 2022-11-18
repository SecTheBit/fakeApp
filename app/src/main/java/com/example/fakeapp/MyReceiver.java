package com.example.fakeapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"Broadcast message is received",Toast.LENGTH_LONG).show();
        String extra= intent.getStringExtra("url");
        if(extra!=null){
            Intent newintent= new Intent(context, view.class);
            newintent.putExtra("url",extra);
            context.startActivity(newintent);

        }
    }
}