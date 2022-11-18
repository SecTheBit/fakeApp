package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class xss_activity extends AppCompatActivity {
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xss2);
        WebView webview = findViewById(R.id.xss_webview);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String values = data.getQueryParameter("url");
            webview.getSettings().setJavaScriptEnabled(true);
            JavaScriptInterface myinterface=new JavaScriptInterface(this);
            webview.addJavascriptInterface(myinterface, "AndroidFunction");
            webview.loadUrl(values);
        }
    }

}