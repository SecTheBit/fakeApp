package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class ArbitaryfileTheft extends AppCompatActivity {

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbitaryfile_theft2);
        WebView webview = findViewById(R.id.theft_webview);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String values = data.getQueryParameter("url");
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
            JavaScriptInterface myinterface=new JavaScriptInterface(this);
            webview.addJavascriptInterface(myinterface, "AndroidFunction");
            webview.loadUrl(values);
        }
    }

}

