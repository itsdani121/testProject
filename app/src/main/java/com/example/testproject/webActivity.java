package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webActivity extends AppCompatActivity {
WebView view;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        view = (WebView) findViewById(R.id.webview);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl("https://www.wasisoft.com/softwares/school");

        WebSettings webSettings = view.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

}