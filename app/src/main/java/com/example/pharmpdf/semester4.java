package com.example.pharmpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class semester4 extends AppCompatActivity {
    WebView webview;
    String url = "https://cosmeticsadda.in/2022/03/download-b-pharmacy-4-semester-notes-and-books/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester4);

        webview = findViewById(R.id.webv);
        webview.loadUrl(url);
    }
}