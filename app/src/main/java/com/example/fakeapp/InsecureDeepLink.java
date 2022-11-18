package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class InsecureDeepLink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_deep_link);

    WebView webview = findViewById(R.id.Insecure_webview);
    Intent intent = getIntent();
    Uri data = intent.getData();
    String values=data.getQueryParameter("url");

        if(data != null && data.toString().startsWith("https")){
        String pattern = "^(https?)://[-a-zA-Z0-9&/%?=~_|!:,.;]*[-a-zA-Z0-9&/%=~_|]";
        if(values.matches(pattern)){
            values=values;

        }
        else {
            values="";

        }

    }
        webview.loadUrl(values);

}
}
