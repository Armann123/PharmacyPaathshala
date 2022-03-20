package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class syllabus extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/pharmacy-syllabus/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        webview = findViewById(R.id.webniew);
        webview.loadUrl(url);
    }
}

