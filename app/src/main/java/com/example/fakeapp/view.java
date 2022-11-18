package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();
        String data = intent.getStringExtra("url");
        if (data != null) {
            String pattern = "^(https?)://[-a-zA-Z0-9&/%?=~_|!:,.;]*[-a-zA-Z0-9&/%=~_|]";
            if (data.matches(pattern)) {
                WebView webView = findViewById(R.id.deeplink_webview);
                webView.loadUrl(data);


            }
        }
    }
}