package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView rootText;
    Button loginpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rootText = findViewById(R.id.textView);
        loginpage = findViewById(R.id.Next);
        IntentFilter intentfilter = new IntentFilter("com.example.fakeapp.CUSTOM_INTENT");
        MyReceiver broadcastreceiver = new MyReceiver();
        registerReceiver(broadcastreceiver,intentfilter);
        Rootchecker("su");

    }

    public void Rootchecker(String Su) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(Su);
            loginpage.setVisibility(View.GONE);
            rootText.setText("It is rooted devices");
        } catch (Exception e) {
            rootText.setText("It is not rooted device");
            loginpage.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity2.this, "It is not rooted device", Toast.LENGTH_LONG).show();
            loginpage.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
                }
            });
        } finally {
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e) {
                }
            }
        }


    }


    }
